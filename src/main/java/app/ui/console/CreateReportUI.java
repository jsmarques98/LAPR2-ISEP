package app.ui.console;

import app.controller.CreateReportController;
import app.domain.model.Company;
import app.ui.console.utils.Utils;

public class CreateReportUI implements Runnable {

    private CreateReportController controller;

    public CreateReportUI() {
        controller = new CreateReportController();
    }

    @Override
    public void run() {

        String report = selectReport();


        if (controller.createReport(report)) {
            if (true) {
                System.out.print("Report written with success and added to the test");
                controller.addReport();
            } else {
                System.out.println("Report not added to the test");
            }

        }

    }

    public String selectReport() {
        return Utils.readLineFromConsole("Report: ");
    }

}
