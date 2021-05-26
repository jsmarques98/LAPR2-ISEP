package app.domain.model;

public class Report {

    /**
     * The report of the test result
     */
    private String report;

    /**
     * Builds an instance of the report that is being made
     * @param report the report of the test result
     */
    public Report(String report) {
        checkReport(report);
        this.report = report;
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
        return String.format("Report: %s%n", this.report);
    }
}
