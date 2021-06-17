package app.ui.console;

import app.controller.App;
import app.controller.CreateReportController;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.ValueRecords;
import app.ui.console.utils.Utils;

import java.util.ArrayList;

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

        String id = setTest();

        String report = selectReport();

        Test test = grabTestId(id);
        if (controller.createReport(report, test)) {
            if (true) {
                System.out.print("Report written with success and added to the test");
                controller.addReport();
            } else {
                System.out.println("Report not added to the test");
            }

        }

        for(int i = 0; i< Company.reportedTestsList.size(); i++){
            System.out.println(Company.reportedTestsList.get(i));
        }

    }

    private Test grabTestId(String id) {
        for (Test test : company.getTests()){
            if (test.getTestID().equals(id)){
                return test;
            }
        }
        throw new IllegalArgumentException("Id de teste não encontrado!");
    }

    public void showTests() {
        System.out.println("Tests to make a report :");
        for(int i = 0; i< Company.valueRecordsList.size(); i++){
            System.out.println(Company.valueRecordsList.get(i));
        }
    }

    public String setTest() {
        String testToReport = Utils.readLineFromConsole("Choose the test you want to do the report for :");

        ArrayList<ValueRecords> valueRecords = company.getValueRecordsList(testToReport);
        if(valueRecords.size() != 0)
            Utils.showList(valueRecords, "valueRecords");

        System.out.println("There are no reports to show, exiting");
        System.exit(0);
        return null;
    }


    public String selectReport() {
        return Utils.readLineFromConsole("Report: ");
    }

}
