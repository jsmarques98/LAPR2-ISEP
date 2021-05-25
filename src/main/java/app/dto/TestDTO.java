package app.dto;

import app.domain.model.Sample;
import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDTO {

    private String testID;
    private String nhscode;
    private List<Sample> samples;

    public String getTestID() {
        return testID;
    }

    public String getNhscode() {
        return nhscode;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public TestDTO(Test test) {
        this.testID = test.getTestID();
        this.nhscode = test.getNhscode();
        this.samples = test.getSamples();
    }

    public String toString(){
        return ("testID: " + this.testID + " nhscode: " + this.nhscode);
    }

}
