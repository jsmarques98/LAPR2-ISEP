package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private String testID;
    private String ccNum;
    private String nhscode;
    private String description;
    private String idTestType;
    private ArrayList listCodeCategory;
    private ArrayList listParameterTestCode;

    private List<Sample> samples;

    public Test(String ccNum, String nhscode, String description, String idTestType ,ArrayList listCodeCategory, ArrayList listParameterTestCode) {
        this.testID = String.valueOf(Company.tests.size()+1);
        this.ccNum = ccNum;
        this.nhscode = nhscode;
        this.description = description;
        this.idTestType = idTestType;
        this.listCodeCategory = listCodeCategory;
        this.listParameterTestCode = listParameterTestCode;
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
