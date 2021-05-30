package app.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private final String testID;
    private final String tinNumber;
    private final String nhscode;
    private final String description;
    private final String idTestType;
    private final ArrayList<String> listCodeCategory;
    private final ArrayList<String> listParameterTestCode;

    private final List<Sample> samples;
    private LocalTime sampleLocalTime;
    private LocalDate sampleLocalDate;


    public Test(String tinNumber, String nhscode, String description, String idTestType ,ArrayList<String> listCodeCategory, ArrayList<String> listParameterTestCode) {
        this.testID = generateID();
        this.tinNumber = tinNumber;
        this.nhscode = nhscode;
        this.description = description;
        this.idTestType = idTestType;
        this.listCodeCategory = listCodeCategory;
        this.listParameterTestCode = listParameterTestCode;
        this.samples = new ArrayList<>();
    }
    private String generateID() {
        return String.valueOf(Company.tests.size()+1);
    }

    public String getTestID() {
        return testID;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getNhscode() {
        return nhscode;
    }

    public ArrayList getListParameterTestCode() {
        return listParameterTestCode;
    }

    public ArrayList<String> getListCodeCategory() {
        return listCodeCategory;
    }

    public String getDescription() {
        return description;
    }


    public List<Sample> getSamples() {
        return samples;
    }

    public void setSampleLocalTime() {
        this.sampleLocalTime = LocalTime.now();
    }
    public void setSampleLocalDate() {
        this.sampleLocalDate = LocalDate.now();
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
                ", sampleLocalTime=" + sampleLocalTime +
                ", sampleLocalDate=" + sampleLocalDate +
                '}';
    }
}
