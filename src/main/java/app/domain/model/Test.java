package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private String testID;
    private String tinNumber;
    private String nhscode;
    private String description;
    private String idTestType;
    private ArrayList listCodeCategory;
    private ArrayList listParameterTestCode;

    private List<Sample> samples;

    public Test(String tinNumber, String nhscode, String description, String idTestType ,ArrayList listCodeCategory, ArrayList listParameterTestCode) {
        this.testID = String.valueOf(Company.tests.size()+1);
        this.tinNumber = tinNumber;
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

    @Override
    public String toString() {
        return "Test{" +
                "testID='" + testID + '\'' +
                ", tinNumber='" + tinNumber + '\'' +
                ", nhscode='" + nhscode + '\'' +
                ", description='" + description + '\'' +
                ", idTestType='" + idTestType + '\'' +
                ", listCodeCategory=" + listCodeCategory +
                ", listParameterTestCode=" + listParameterTestCode +
                ", samples=" + samples +
                '}';
    }
}
