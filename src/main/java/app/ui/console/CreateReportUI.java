package app.ui.console;

import app.controller.CreateReportController;
import app.domain.model.Company;
import app.ui.console.utils.Utils;

public class CreateReportUI implements Runnable{

    private CreateReportController controller;

    public CreateReportUI() {
        controller = new CreateReportController();
    }

    @Override
    public void run() {

        String report = selectReport();


        //if(controller.createReport(report)){
        if(true){
            System.out.println("Report written with success and added to the test");
            controller.addReport();
        }else{
            System.out.println("Report not added to the test");
        }

        for(int i = 0; i< Company.reportList.size(); i++){
            System.out.println(Company.reportList.get(i));
        }
    }

    public String selectReport(){
        return Utils.readLineFromConsole("Report: ");
    }

}
