package app.controller;

import app.domain.model.Company;
import app.domain.model.ValueRecords;
import app.domain.shared.Constants;
import app.ui.console.SendCovidReportUI;
import app.ui.console.utils.Utils;

import java.time.LocalDate;
import java.util.Arrays;

public class SendCovidReportController {

    private Company company;

    public SendCovidReportController() {
        this.company = App.getInstance().getCompany();
    }

    public void regressionMenu() {
        System.out.println("What regression do you want to choose?\n1- Simple linear regression model.\n2- Multilinear regression model.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        int[] totalCovidTests = new int[company.finaldatesList.size()];
        int[] totalPositiveCovidTests = new int[company.dateList.size()];
        switch(op) {
            case 1:
                simpleRegression(totalCovidTests, totalPositiveCovidTests);
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                regressionMenu();
        }
    }

    private void simpleRegression(int[] totalCovidTests, int[] totalPositiveCovidTests) {
        System.out.println("Choose the independent variable:\n1- Number of tests.\n2- Mean age.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        Double confidenceValue = Utils.readDoubleFromConsole("Enter the confidence level value: ");
        String parameter;
        do {
            parameter = Utils.readLineFromConsole("Select witch parameter you want to analyzed (A/B): ");
        }while(!(parameter.equalsIgnoreCase("A") || parameter.equalsIgnoreCase("B")));

        for (ValueRecords v:company.valueRecordsList) {
            System.out.println(v.toString());
        }

        switch(op) {
            case 1:
                totalOfCovidTests(totalCovidTests);
                totalPositiveCases(totalPositiveCovidTests);
                printTotals(totalCovidTests, totalPositiveCovidTests);
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                simpleRegression(totalCovidTests, totalPositiveCovidTests);
        }
    }

    public int[] totalOfCovidTests(int[] totalCovidTests) {
        int counter = 0,i = 0;
        for (LocalDate date : company.finaldatesList) {
            for (ValueRecords valueRecords : company.valueRecordsList) {
                if(valueRecords.getData().equals(date) && valueRecords.getParametro().equals("IgGAN")){
                    counter++;
                }
            }
            totalCovidTests[i] = counter;
            i++;
            counter = 0;
        }
        return totalCovidTests;
    }


    private void totalPositiveCases(int[] totalPositiveCovidTests) {
        int counter = 0,i = 0;
        for (LocalDate date : company.dateList) {
            for (ValueRecords valueRecords : company.valueRecordsList) {
                if(valueRecords.getData().equals(date) && valueRecords.getParametro().equals("IgGAN") && valueRecords.getRegisteredValue() > Constants.MIN_VALUE_OF_IGGAN){
                    System.out.println("Dateeeeee " + date);
                    System.out.println("Date -------- "+ valueRecords.getData());
                    counter++;
                }
            }
            totalPositiveCovidTests[i] = counter;
            i++;
            totalPositiveCovidTests[counter] = counter;
            counter = 0;
        }
    }

    private void printTotals(int[] totalCovidTests, int[] totalPositiveCovidTests) {
        LocalDate date1 = company.finaldatesList.get(0);
        LocalDate date2 = company.dateList.get(0);
        for (int i = 0; i < totalCovidTests.length; i++) {
            System.out.println("No dia " + date1.plusDays(i) + " houveram " + totalCovidTests[i] + " total de casos");
        }
        for (int i = 0; i < totalPositiveCovidTests.length; i++) {
            System.out.println("No dia " + date2.plusDays(i) + " houveram " + totalPositiveCovidTests[i] + " total de casos positivos");
        }
    }

}
