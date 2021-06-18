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
        this(App.getInstance().getCompany());
    }

    public SendCovidReportController(Company company){
        this.company = company;
    }

    public void regressionMenu() {
        System.out.println("What regression do you want to choose?\n1- Simple linear regression model.\n2- Multilinear regression model.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        int[] totalCovidTests = new int[Company.finaldatesList.size()];
        int[] totalPositiveCovidTests = new int[Company.dateList.size()];
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
        System.out.println("Choose the independent variable\n1- Number of tests.\n2- Mean age.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
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
        for (LocalDate date : Company.finaldatesList) {
            for (ValueRecords valueRecords : Company.valueRecordsList) {
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
        for (LocalDate date : Company.dateList) {
            for (ValueRecords valueRecords : Company.valueRecordsList) {
                if(valueRecords.getData().equals(date) && valueRecords.getParametro().equals("IgGAN") && valueRecords.getRegisteredValue() > Constants.MIN_VALUE_OF_IGGAN){
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
        LocalDate date1 = Company.finaldatesList.get(0);
        LocalDate date2 = Company.dateList.get(0);
        for (int i = 0; i < totalCovidTests.length; i++) {
            System.out.println("No dia " + date1.plusDays(i) + " houveram " + totalCovidTests[i] + " total de casos");
        }
        for (int i = 0; i < totalPositiveCovidTests.length; i++) {
            System.out.println("No dia " + date2.plusDays(i) + " houveram " + totalPositiveCovidTests[i] + " total de casos positivos");
        }
    }

}
