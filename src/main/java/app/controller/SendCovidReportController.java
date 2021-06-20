package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SendCovidReportController{

    private Company company;

    public SendCovidReportController() {
        this.company = App.getInstance().getCompany();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



    public void regressionMenu() {
        double[] covidTestsInterval = new double[company.finaldatesList.size()];
        double[] covidPositiveTestsInterval = new double[company.finaldatesList.size()];
        // For all x given Historical points
        double[] covidPositiveTestsTotal = new double[company.dateList.size()];
        double[] covidTestsTotal = new double[company.dateList.size()];

        double[][] intrevaloPrevisao = new double[company.dateList.size()][2];

        double[] estimatedPositiveCases = new double[company.dateList.size()];

        double[][] anova = new double[3][4];

        double[] covidMeanAgeInterval = new double[company.finaldatesList.size()];
        double[] covidMeanAgeTotal = new double[company.dateList.size()];

        System.out.println("What regression do you want to choose?\n1- Simple linear regression model.\n2- Multilinear regression model.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        // For an interval of dates given by admin
        switch(op) {
            case 1:
                simpleRegression(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal, covidTestsTotal, intrevaloPrevisao, estimatedPositiveCases, anova, covidMeanAgeInterval, covidMeanAgeTotal);
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                regressionMenu();
        }
    }

    private void simpleRegression(double[] covidTestsInterval, double[] covidPositiveTestsInterval, double[] covidTestsTotal, double[] covidPositiveTestsTotal, double[][] intrevaloPrevisao, double[] estimatedPositiveCases, double[][] anova, double[] covidMeanAgeInterval, double[] covidMeanAgeTotal) {
        System.out.println("Choose the independent variable:\n1- Number of tests.\n2- Mean age.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        Double confidenceValue = Utils.readDoubleFromConsole("Enter the confidence level value: ");
        LinearRegression lr;
        Double tc = (1-confidenceValue/100)/2;
        String parameter;
        do {
            parameter = Utils.readLineFromConsole("Select witch parameter you want to analyzed (A/B): ");
        }while(!(parameter.equalsIgnoreCase("A") || parameter.equalsIgnoreCase("B")));

        switch(op) {
            case 1:
                totalOfCovidTests(covidTestsInterval, covidPositiveTestsInterval);
                totalPositiveCases(covidTestsTotal, covidPositiveTestsTotal);
//                printTotals(covidTestsInterval, covidPositiveTestsInterval, covidPositiveTestsTotal);
                lr = new LinearRegression(covidTestsInterval, covidPositiveTestsInterval);
                String equacaoReta = ("Y = " + lr.intercept() + " + " + lr.slope() + " * X");
                String r2 = String.valueOf(lr.R2());
                String r = String.valueOf(Math.sqrt(lr.R2()));
                String finalR = "R2 = " + r2 + "\nR = " + r;
                intrevaloPrevisao = intervaloPrevisao(intrevaloPrevisao, covidTestsInterval, lr, covidPositiveTestsTotal, tc);
                Double test = testeHipotese(covidTestsInterval, parameter, lr);
                estimatedPositiveCases = estimatedPositives(covidTestsTotal, lr);
                String decision;
                String t = String.valueOf(test);
                if(test > tc){
                    decision = t + "\nDecision:\nNo reject";
                    anova(anova, covidTestsInterval, lr);
                }else {
                    decision = t + "\nDecision:\nReject";
                    System.out.println("Inconclusive test");
                }
                exportToFile(equacaoReta, finalR, decision, anova, covidPositiveTestsTotal, estimatedPositiveCases, intrevaloPrevisao);
                break;
            case 2:
                totalOfCovidTests2(covidMeanAgeInterval, covidPositiveTestsInterval);
                totalPositiveCases2(covidMeanAgeTotal, covidPositiveTestsTotal);
                lr = new LinearRegression(covidMeanAgeInterval, covidPositiveTestsInterval);
                String equacaoReta2 = ("Y = " + lr.intercept() + " + " + lr.slope() + " * X");
                String r2for2 = String.valueOf(lr.R2());
                String rfor2 = String.valueOf(Math.sqrt(lr.R2()));
                String finalR2 = "R2 = " + r2for2 + "\nR = " + rfor2;
                intrevaloPrevisao = intervaloPrevisao(intrevaloPrevisao, covidMeanAgeInterval, lr, covidPositiveTestsTotal, tc);
                Double test2 = testeHipotese(covidTestsInterval, parameter, lr);
                estimatedPositiveCases = estimatedPositives(covidMeanAgeTotal, lr);

                String decision2;
                String t2 = String.valueOf(test2);
                if(test2 > tc){
                    decision2 = t2 + "\nDecision:\nNo reject";
                    anova(anova, covidTestsInterval, lr);
                }else {
                    decision2 = t2 + "\nDecision:\nReject";
                    System.out.println("Inconclusive test");
                }
                exportToFile2(equacaoReta2, finalR2, decision2, anova, covidPositiveTestsTotal, estimatedPositiveCases, intrevaloPrevisao);
                break;
            default:
                System.out.println("Option not found");
        }
    }

    public void totalOfCovidTests(double[] covidTestsInterval, double[]  covidPositiveTestsInterval) {
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

    private void totalPositiveCases(double[] covidTestsTotal, double[] covidPositiveTestsTotal) {
        int totalCounter = 0, positivesCounter = 0, i = 0;
        for (LocalDate d : company.dateList) {
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
            covidPositiveTestsTotal[i] = totalCounter;
            covidTestsTotal[i] = positivesCounter;
            i++;
            totalCounter = 0;
            positivesCounter = 0;
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

    private Double testeHipotese(double[] covidTestsInterval, String parameter, LinearRegression lr) {
        if(parameter.equalsIgnoreCase("A")){
            return lr.intercept()/Math.sqrt(1/covidTestsInterval.length+Math.pow(lr.averageX(),2)/lr.sumX());
        }else{
            return lr.slope()/Math.sqrt(lr.sumX());
        }
    }

    private double[] estimatedPositives(double[] covidTestsTotal, LinearRegression lr) {
        double[] temp = new double[covidTestsTotal.length];
        for (int i = 0; i < covidTestsTotal.length; i++) {
            temp[i] = lr.predict(covidTestsTotal[i]);
        }
        return temp;
    }

    private void anova(double[][] anova, double[] covidTestsInterval, LinearRegression lr) {
        anova[0][0] = 1;
        anova[1][0] = covidTestsInterval.length-2;
        anova[2][0] = anova[0][0]+anova[1][0];
        anova[0][1] = lr.sumY();
        anova[1][1] = Math.pow(lr.averageY(),2);
        anova[2][1] = anova[0][1]+anova[1][1];
        anova[0][2] = anova[0][1]/anova[0][0];
        anova[1][2] = anova[1][1]/anova[1][0];
        anova[0][3] = anova[0][2]/anova[1][2];
    }


    private void exportToFile(String equacaoReta, String coeficienteDeterminacao, String decision, double[][] anova, double[] covidPositiveTestsTotal, double[] estimatedPositiveCases, double[][] intrevaloPrevisao) {
        String [] positiveTest = Utils.convertDoubleToStringArr(covidPositiveTestsTotal);
        String [] estimatedCases = Utils.convertDoubleToStringArr(estimatedPositiveCases);
        String [][] intervalo = Utils.convertDoubleToStringArr2(intrevaloPrevisao);

        String texto = "The regression model fitted using data from the interval\n" + equacaoReta + "\nOther statistics\n"
                + coeficienteDeterminacao + "\n" + "Hypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)\nt_obs = "
                + decision + "\nSignificance model with Anova\nH0: b=0  H1:b<>0\n"
                + "\t\t df\tSS\tMS\tF\n"
                + "Regression\t" + anova[0][0] + "\t" + anova[0][1] + "\t" + anova[0][2] + "\t" + anova[0][3] + "\n"
                + "Residual  \t" + anova[1][0] + "\t" + anova[1][1] + "\t" + anova[1][2] + "\n"
                + "Total     \t" + anova[2][0] + "\t" + anova[2][1]
                + "\nDate                              : " + company.dateList.toString()
                + "\nNumber of OBSERVED positive cases : " + positiveTest
                + "\nNumber of ESTIMATED positive cases: " + estimatedCases
                + "\n95% intervals                     : " + intervalo;

        Utils.createFile("Linear Regression", texto);
    }

    public void totalOfCovidTests2(double[] covidMeanAgeInterval, double[]  covidPositiveTestsInterval) {
        int totalCounter = 0, positivesCounter = 0, i = 0, totalAge=0;
        for (LocalDate d : company.finaldatesList) {
            for (ValueRecords valueRecords : company.valueRecordsList) {
                Date date = Utils.localDateToDate(d);
                Date vrDate = valueRecords.getData();
                if(sdf.format(vrDate).equals(sdf.format(date)) && valueRecords.getParametro().equals("IgGAN")){
                    for (Test t : company.tests) {
                        for (Client c : company.clientsList) {
                            if(c.getTINNumber().equals(t.getTinNumber()) && t.getTestID().equals(valueRecords.getId())){
                                totalAge += 18 + (Math.random() * 90);
                            }
                        }
                    }
                    totalCounter++;
                    if(valueRecords.getRegisteredValue() > Constants.MIN_VALUE_OF_IGGAN){
                        positivesCounter++;
                    }
                }
            }
            double media  = totalAge/totalCounter;
            covidMeanAgeInterval[i] = media;
            covidPositiveTestsInterval[i] = positivesCounter;
            i++;
            totalCounter = 0;
            positivesCounter = 0;
        }
    }

    private void totalPositiveCases2(double[] covidMeanAgeTotal, double[] covidPositiveTestsTotal) {
        int totalCounter = 0, positivesCounter = 0, i = 0, totalAge=0;
        double media = 0;
        for (LocalDate d : company.dateList) {
            for (ValueRecords valueRecords : company.valueRecordsList) {
                Date date = Utils.localDateToDate(d);
                Date vrDate = valueRecords.getData();
                if(sdf.format(vrDate).equals(sdf.format(date)) && valueRecords.getParametro().equals("IgGAN")){
                    for (Test t : company.tests) {
                        for (Client c : company.clientsList) {
                            if(c.getTINNumber().equals(t.getTinNumber()) && t.getTestID().equals(valueRecords.getId())){
                                totalAge += 18 + (Math.random() * 90);
                            }
                        }
                    }
                    totalCounter++;
                    if(valueRecords.getRegisteredValue() > Constants.MIN_VALUE_OF_IGGAN){
                        positivesCounter++;
                    }
                }
            }
            if(totalCounter != 0 ) {
                media = totalAge / totalCounter;
                covidPositiveTestsTotal[i] = media;
            }else {
                covidPositiveTestsTotal[i] = 0;
            }
            covidMeanAgeTotal[i] = positivesCounter;
            i++;
            totalCounter = 0;
            totalAge = 0;
            positivesCounter = 0;
        }
    }


    private void exportToFile2(String equacaoReta, String coeficienteDeterminacao, String decision, double[][] anova, double[] covidPositiveTestsTotal, double[] estimatedPositiveCases, double[][] intrevaloPrevisao) {
        String [] positiveTest = Utils.convertDoubleToStringArr(covidPositiveTestsTotal);
        String [] estimatedCases = Utils.convertDoubleToStringArr(estimatedPositiveCases);
        String [][] intervalo = Utils.convertDoubleToStringArr2(intrevaloPrevisao);

        String texto = "The regression model fitted using data from the interval\n" + equacaoReta + "\nOther statistics\n"
                + coeficienteDeterminacao + "\n" + "Hypothesis tests for regression coefficients\nHO:b=0 (a=0) H1: b<>0 (a<>0)\nt_obs = "
                + decision + "\nSignificance model with Anova\nH0: b=0  H1:b<>0\n"
                + "\t\t df\tSS\tMS\tF\n"
                + "Regression\t" + anova[0][0] + "\t" + anova[0][1] + "\t" + anova[0][2] + "\t" + anova[0][3] + "\n"
                + "Residual  \t" + anova[1][0] + "\t" + anova[1][1] + "\t" + anova[1][2] + "\n"
                + "Total     \t" + anova[2][0] + "\t" + anova[2][1]
                + "\nDate                              : " + company.dateList.toString()
                + "\nNumber of OBSERVED positive cases : " + positiveTest
                + "\nNumber of ESTIMATED positive cases: " + estimatedCases
                + "\n95% intervals                     : " + intervalo;

        Utils.createFile("Linear Regression", texto);
    }


    private void goToFile(double[] covidPositiveTestsTotal,double[] covidTestsTotal){

        String [] positiveTest = Utils.convertDoubleToStringArr(covidPositiveTestsTotal);


        //String texto = ;

        //Utils.createFile("Linear Regression", texto);
    }

    private void multilinearRegression(double[] covidTestsInterval, double[] covidPositiveTestsInterval, double[] covidTestsTotal, double[] covidPositiveTestsTotal, double[][] intrevaloPrevisao, double[] estimatedPositiveCases, double[][] anova){

        totalOfCovidTests(covidTestsInterval, covidPositiveTestsInterval);
        totalPositiveCases(covidTestsTotal, covidPositiveTestsTotal);


    }

    public Double medianage(){
        System.out.println("Choose a median age for the covid tests");
        double age = Utils.readDoubleFromConsole("Write de median age of the covid tests:");

        return age;
    }
}
