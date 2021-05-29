package app.ui.console;

import app.controller.App;
import app.controller.CreateReportController;
import app.domain.model.Company;
import app.domain.model.Test;
import app.ui.console.utils.Utils;

public class CreateReportUI implements Runnable {

    private Company company;

    private CreateReportController controller;

    public CreateReportUI(){
        this(App.getInstance().getCompany());
    }

    public CreateReportUI(Company company) {
        this.company = company;
        controller = new CreateReportController();
    }

    @Override
   public void run() {
        showTests();

        Test test = setTest();

        String report = selectReport();

        if (controller.createReport(report, test)) {
            if (true) {
                System.out.print("Report written with success and added to the test");
                controller.addReport();
            } else {
                System.out.println("Report not added to the test");
            }

        }

    }

    public void showTests() {
        System.out.println("Tests to make a report :");
        for (Test test: company.getTests()) {
            System.out.println(test.getNhscode());
        }
    }

    public Test setTest() {
        String testToReport = Utils.readLineFromConsole("Choose the test you want to do the report for :");
        for (Test test : company.getTests()) {
            if (test.getNhscode().equals(testToReport)) {
                return test;
            }
        }
        System.out.println("There are no reports to show, exiting");
        System.exit(0);
        return null;
    }


    public String selectReport() {
        return Utils.readLineFromConsole("Report: ");
    }

}
