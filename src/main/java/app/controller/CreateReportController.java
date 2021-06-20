package app.controller;

import app.domain.model.Company;
import app.domain.model.Diagnosis;
import app.domain.model.Test;

import java.io.Serializable;
import java.util.Date;

public class CreateReportController implements Serializable {

    /**
     * The company of CreateReportController
     */
    private Company company;

    /**
     * The report of the CreateReportController
     */
    private Diagnosis writeRep;

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
        this.writeRep = null;
    }

    /**
     * Builds an instance of the report for the test result
     * @param report the report of the test result
     * @return if the report is valid or not and if it was created or not
     */
     public boolean createReport(String report, Test test) {
        this.writeRep = this.company.createReport(report, test);
        test.setTest_Doctor_DateHour(new Date());
        return this.company.validateReport(writeRep);
     }


    /**
     * Adds the report to the given test
     * @return if it was added with success or insuccess
     */
    public boolean addReport (){
        return this.company.addReport(writeRep);
    }
}
