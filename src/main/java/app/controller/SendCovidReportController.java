package app.controller;

import app.domain.model.Company;

public class SendCovidReportController {

    private Company company;

    public SendCovidReportController() {
        this(App.getInstance().getCompany());
    }

    public SendCovidReportController(Company company){
        this.company = company;
    }

}
