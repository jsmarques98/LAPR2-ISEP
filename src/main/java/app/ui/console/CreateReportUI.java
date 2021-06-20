package app.ui.console;

import app.controller.App;
import app.controller.CreateReportController;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.ValueRecords;
import app.ui.console.utils.Utils;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;

public class CreateReportUI implements Runnable {

    private CreateReportController controller;
    private Company company;

    public CreateReportUI() {
        controller = new CreateReportController();
        company = App.getInstance().getCompany();

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

        for(int i = 0; i< company.reportedTestsList.size(); i++){
            System.out.println(company.reportedTestsList.get(i));
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
        for(int i = 0; i< company.valueRecordsList.size(); i++){
            System.out.println(company.valueRecordsList.get(i));
        }
    }

    public String setTest() {
        String testToReport = Utils.readLineFromConsole("Choose the test you want to do the report for :");
        ArrayList<ValueRecords> valueRecords = company.getValueRecordsList(testToReport);
        for (ValueRecords v : valueRecords) {
            if(v.getId().equals(testToReport)){
                return v.getId();
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
