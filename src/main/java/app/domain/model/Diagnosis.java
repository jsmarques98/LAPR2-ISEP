package app.domain.model;

import java.io.Serializable;

public class Diagnosis implements Serializable {

    /**
     * The report of the test result
     */
    private String report;

    /**
     * The test we are going to grab the results to do the report
     */
    private final transient Test test;

    /**
     * Receives the information necessary to make the diagnosis
     * @param report the report of the test result
     * @param test the test with the results we are going to do the report for
     */
    public Diagnosis(String report, Test test) {
        checkReport(report);
        this.report = report;
        this.test = test;

    }

    /**
     * Checks if the report of the test result is correct given the constraints
     * @param report the report of the test result
     */
    private void checkReport(String report){

        if (report == null){
            throw new IllegalArgumentException("The report can't be null");
        }

        if (report.isEmpty()){
            throw new IllegalArgumentException("The report can't be empty, you have to write something");
        }

        if (report.length() > 400){
            throw new IllegalArgumentException("The report can't have mora than 400 characters");
        }

    }

    /**
     * Gets the report made for the test result
     * @return the report of the test result
     */
    public String getReport() {
        return report;
    }

    /**
     * Sets the report of the test result
     * @param report the report of the test result
     */
    public void setReport(String report) {
        checkReport(report);
        this.report = report;
    }


    @Override
    public String toString() {
        return String.format("Report: %s%nTest: %s%n", this.report, this.test);
    }
}
