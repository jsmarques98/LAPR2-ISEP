package app.controller;

import app.domain.model.Company;
import app.domain.model.ValueRecords;
import app.ui.console.utils.Utils;

import java.time.LocalDate;

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
        switch(op) {
            case 1:
                simpleRegression();
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                regressionMenu();
        }
    }

    private void simpleRegression() {
        System.out.println("Choose the independent variable\n1- Number of tests.\n2- Mean age.");
        int op = Utils.readIntegerFromConsole("Select the option number:");
        switch(op) {
            case 1:
                numberOfTests();
                break;
            case 2:

                break;
            default:
                System.out.println("Option not found");
                simpleRegression();
        }
    }

    private int numberOfTests() {
        int counter = 0;
        for (ValueRecords vr : Company.valueRecordsList) {
            for (LocalDate ld : Company.finaldatesList) {
                if(vr.getData().equals(ld) && vr.getParametro().equals("")){
                    System.out.println(vr.toString());
                    counter++;
                }
            }
        }
        return counter;
    }


}
