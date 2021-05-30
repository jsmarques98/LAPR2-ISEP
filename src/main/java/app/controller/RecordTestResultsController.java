package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.ValueRecords;
import com.example1.ExternalModule3API;


public class RecordTestResultsController {

    private Test test;

    private Company company;

    private ValueRecords valueRecords;

    public void setTest(Test test) {
        this.test = test;
    }

    public RecordTestResultsController() {
        this(App.getInstance().getCompany());
    }

    public RecordTestResultsController(Company company) {
        this.company = company;
        this.valueRecords = null;
    }

    public boolean createValueRecords( double min, double max, double registeredValue) {
        this.valueRecords = this.company.createValueRecords(min, max, registeredValue);
        return this.company.validateValueRecords(valueRecords);
    }

    public boolean saveValueRecords() {
        System.out.println(valueRecords);
        return this.company.saveValueRecords(valueRecords);
    }

}
