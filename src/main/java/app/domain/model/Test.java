package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private String testID;
    private String nhscode;
    private TestType testType;
    private Category category;
    private parameterTest parameterTest;

    private List<Sample> samples;

    public Test(String testID, String nhscode,TestType testType, Category category,parameterTest parameterTest ) {
        this.testID = testID;
        this.nhscode = nhscode;
        this.testType = testType;
        this.category = category;
        this.parameterTest = parameterTest;

        this.samples = new ArrayList<>();
    }

    public String getTestID() {
        return testID;
    }

    public String getNhscode() {
        return nhscode;
    }



    public List<Sample> getSamples() {
        return samples;
    }

    public String toString(){
        return ("testID: " + this.testID + " nhscode: " + this.nhscode);
    }

}
