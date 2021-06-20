package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.ValueRecords;
import java.util.Date;


public class RecordTestResultsController {

    /**
     * The test of RecordTestResultsController
     */
    private Test test;

    /**
     * The company of RecordTestResultsController
     */
    private Company company;

    /**
     * The Value Records of RecordTestResultsController
     */
    private ValueRecords valueRecords;

    /**
     * Set the test of the value records
     *
     * @param test
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * Construtor do RecordTestResultsController
     */
    public RecordTestResultsController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Construtor com a company do RecordTestResultsController
     *
     * @param company
     */
    public RecordTestResultsController(Company company) {
        this.company = company;
        this.valueRecords = null;
    }

    /**
     * Builds an instance of RecordTestResultsController receiving the id, min, max, registeredValue and parametro
     *
     * @param id
     * @param min
     * @param max
     * @param registeredValue
     * @param parametro
     * @return
     */
    public boolean createValueRecords(String id, double min, double max, double registeredValue, String parametro, Date data) {
        this.valueRecords = this.company.createValueRecords(id, min, max, registeredValue, parametro, data);
        return this.company.validateValueRecords(valueRecords);
    }

    /**
     * Saves the value records
     *
     * @return
     */
    public boolean saveValueRecords() {
        System.out.println(valueRecords);
        this.test.setTest_Chemical_DateHour(new Date());
        return this.company.saveValueRecords(valueRecords);
    }

}
