package app.ui.console.utils;

import app.controller.SendCovidReportController;
import app.domain.model.Company;

public class SendCovidReportUI implements Runnable{

    private SendCovidReportController controller;

    public SendCovidReportUI(){
        controller = new SendCovidReportController();
    }

    @Override
    public void run() {
        for (int i = 0; i < Company.valueRecordsList.size(); i++) {
            System.out.println(Company.valueRecordsList.get(i));
        }

    }
}
