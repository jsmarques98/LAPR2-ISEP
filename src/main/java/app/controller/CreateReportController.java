package app.controller;

import app.domain.model.Company;
import app.domain.model.Report;

public class CreateReportController {

    /**
     * The company of CreateReportController
     */
    private Company company;

    /**
     * The report of the CreateReportController
     */
    private Report report;

    public CreateReportController() {
        this(App.getInstance().getCompany());
    }

    /**
     *Builds an instance of CreateReportController receiving the company and the report.
     *
     * @param company the name of the company.
     */
    public CreateReportController(Company company) {
        this.company = company;
        this.report = null;
    }

    /**
     * Builds an instance of the report for the test result
     * @param report the report of the test result
     * @return if the report is valid or not and if it was created or not
     */
   /* public boolean createReport(String report) {
        this.report = this.company.createReport(report);
        return this.company.validateReport(report);
    }*/


    /**
     * Adds the report to the given test
     * @return if it was added with success or insuccess
     */
    public boolean addReport (){
        return this.company.addReport(report);
    }
}
