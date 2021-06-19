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
        double[] covidTestsInterval = new double[company.finaldatesList.size()];
        double[] covidPositiveTestsInterval = new double[company.finaldatesList.size()];
        double[] covidPositiveTestsTotal = new double[company.dateList.size()];
        switch(op) {
            case 1:
                simpleRegression(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal);
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                regressionMenu();
        }
    }

    private void simpleRegression(double[] covidTestsInterval, double[] covidPositiveTestsInterval, double[] covidPositiveTestsTotal) {
        System.out.println("Choose the independent variable:\n1- Number of tests.\n2- Mean age.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        Double confidenceValue = Utils.readDoubleFromConsole("Enter the confidence level value: ");
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
                System.out.println(equacaoReta + "\nR2: " + coeficienteDeterminacao);
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                simpleRegression(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal);
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
        System.out.println("Total de testes de Covid: ");
        for (int i = 0; i < covidTestsInterval.length; i++) {
            System.out.println("No dia " + date1.plusDays(i) + " houveram " + covidTestsInterval[i] + " total de testes de Covid");
            System.out.println("Sendo que " + covidPositiveTestsInterval[i] + " foram positivos");
        }
        System.out.println("Total de testes Positivos: ");
        for (int i = 0; i < covidPositiveTestsTotal.length; i++) {
            System.out.println("No dia " + date2.plusDays(i) + " houveram " + covidPositiveTestsTotal[i] + " total de casos positivos");
        }
    }



}
