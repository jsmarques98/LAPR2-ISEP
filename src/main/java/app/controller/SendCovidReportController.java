package app.controller;

import app.domain.model.Company;
import app.domain.model.LinearRegression;
import app.domain.model.ValueRecords;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import javax.xml.bind.SchemaOutputResolver;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SendCovidReportController {

    private Company company;

    public SendCovidReportController() {
        this.company = App.getInstance().getCompany();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void regressionMenu() {
        System.out.println("What regression do you want to choose?\n1- Simple linear regression model.\n2- Multilinear regression model.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        // For an interval of dates given by admin
        double[] covidTestsInterval = new double[company.finaldatesList.size()];
        double[] covidPositiveTestsInterval = new double[company.finaldatesList.size()];
        // For all x given Historical points
        double[] covidPositiveTestsTotal = new double[company.dateList.size()];

        double[][] intrevaloPrevisao = new double[company.dateList.size()][2];

        switch(op) {
            case 1:
                simpleRegression(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal, intrevaloPrevisao);
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                regressionMenu();
        }
    }

    private void simpleRegression(double[] covidTestsInterval, double[] covidPositiveTestsInterval, double[] covidPositiveTestsTotal, double[][] intrevaloPrevisao) {
        System.out.println("Choose the independent variable:\n1- Number of tests.\n2- Mean age.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        Double confidenceValue = Utils.readDoubleFromConsole("Enter the confidence level value: ");
        Double tc = (1-confidenceValue/100)/2;
        String parameter;
        do {
            parameter = Utils.readLineFromConsole("Select witch parameter you want to analyzed (A/B): ");
        }while(!(parameter.equalsIgnoreCase("A") || parameter.equalsIgnoreCase("B")));

        switch(op) {
            case 1:
                totalOfCovidTests(covidTestsInterval, covidPositiveTestsInterval);
                totalPositiveCases(covidPositiveTestsTotal);
                printTotals(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal);

                LinearRegression lr = new LinearRegression(covidTestsInterval, covidPositiveTestsInterval);
                String equacaoReta = ("Y = " + lr.intercept() + " + " + lr.slope() + " * X");
                String coeficienteDeterminacao = String.valueOf(lr.R2());

                intrevaloPrevisao = intervaloPrevisao(intrevaloPrevisao, covidTestsInterval, lr, covidPositiveTestsTotal, tc);
                for (int i = 0; i < intrevaloPrevisao.length; i++) {
                    System.out.println("\n" + i + ": " + intrevaloPrevisao[i][0]);
                    System.out.println(i + ": " + intrevaloPrevisao[i][1] + "\n");
                }

                testeHipotese(covidTestsInterval, parameter, lr, tc);
                break;
            case 2:
                break;
            default:
                System.out.println("Option not found");
                simpleRegression(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal, intrevaloPrevisao);
        }
    }

    public void totalOfCovidTests(double[] covidTestsInterval,double[]  covidPositiveTestsInterval) {
        int totalCounter = 0, positivesCounter = 0, i = 0;
        for (LocalDate d : company.finaldatesList) {
            for (ValueRecords valueRecords : company.valueRecordsList) {
                Date date = Utils.localDateToDate(d);
                Date vrDate = valueRecords.getData();
                if(sdf.format(vrDate).equals(sdf.format(date)) && valueRecords.getParametro().equals("IgGAN")){
                    totalCounter++;
                    if(valueRecords.getRegisteredValue() > Constants.MIN_VALUE_OF_IGGAN){
                        positivesCounter++;
                    }
                }
            }
            covidTestsInterval[i] = totalCounter;
            covidPositiveTestsInterval[i] = positivesCounter;
            i++;
            totalCounter = 0;
            positivesCounter = 0;
        }
    }

    private void totalPositiveCases(double[] covidPositiveTestsTotal) {
        int counter = 0,i = 0;
        for (LocalDate d : company.dateList) {
            for (ValueRecords valueRecords : company.valueRecordsList) {
                Date date = Utils.localDateToDate(d);
                Date vrDate = valueRecords.getData();
                if(sdf.format(vrDate).equals(sdf.format(date)) && valueRecords.getParametro().equals("IgGAN") && valueRecords.getRegisteredValue() > Constants.MIN_VALUE_OF_IGGAN){
                    counter++;
                }
            }
            covidPositiveTestsTotal[i] = counter;
            i++;
            counter = 0;
        }
    }

    private void printTotals(double[] covidTestsInterval, double[] covidPositiveTestsInterval, double[] covidPositiveTestsTotal) {
        LocalDate date1 = company.finaldatesList.get(0);
        LocalDate date2 = company.dateList.get(0);
        System.out.println("Total of Covid cases: ");
        for (int i = 0; i < covidTestsInterval.length; i++) {
            System.out.println("On day " + date1.plusDays(i) + " ----> " + covidTestsInterval[i] + " total of Covid tests");
            System.out.println("Knowing that " + covidPositiveTestsInterval[i] + " of them were positives");
        }
        System.out.println("Total of positives tests: ");
        for (int i = 0; i < covidPositiveTestsTotal.length; i++) {
            System.out.println("On day " + date2.plusDays(i) + " ----> " + covidPositiveTestsTotal[i] + " total of positive cases");
        }
    }

    private double[][] intervaloPrevisao(double[][] intrevaloPrevisao, double[] covidTestsInterval, LinearRegression lr, double[] covidPositiveTestsTotal, Double tc) {
        for (int i = 0; i < intrevaloPrevisao.length; i++) {
            intrevaloPrevisao[i][0] = covidPositiveTestsTotal[i]-tc*Math.sqrt(1+1/covidTestsInterval.length+ Math.pow(-lr.averageX(),2)/lr.sumX());
            intrevaloPrevisao[i][1] = covidPositiveTestsTotal[i]+tc*Math.sqrt(1+1/covidTestsInterval.length+ Math.pow(-lr.averageX(),2)/lr.sumX());
        }
        return intrevaloPrevisao;
    }

    private void testeHipotese(double[] covidTestsInterval, String parameter, LinearRegression lr, Double tc) {
        if(parameter.equalsIgnoreCase("A")){
            Double ta = lr.intercept()/Math.sqrt(1/covidTestsInterval.length+Math.pow(lr.averageX(),2)/lr.sumX());
            if(ta > tc)
                anova();
            else
                System.out.println("Inconclusive test");
        }else{
            Double tb = lr.slope()/Math.sqrt(lr.sumX());
            if(tb > tc)
                anova();
            else
                System.out.println("Inconclusive test");
        }

    }

    private void anova() {
    }

}
