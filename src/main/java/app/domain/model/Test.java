package app.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private String testID;
    private final String tinNumber;
    private final String nhscode;
    private final String description;
    private final String idTestType;
    private final ArrayList listCodeCategory;
    private final ArrayList listParameterTestCode;

    private List<Sample> samples;
    private LocalTime sampleLocalTime;
    private LocalDate sampleLocalDate;


    private Map<Sample , Map <String, ValueRecords> > map ;



    public Test(String tinNumber, String nhscode, String description, String idTestType ,ArrayList listCodeCategory, ArrayList listParameterTestCode) {
        this.testID = generateID();
        this.tinNumber = tinNumber;
        this.nhscode = nhscode;
        this.description = description;
        this.idTestType = idTestType;
        this.listCodeCategory = listCodeCategory;
        this.listParameterTestCode = listParameterTestCode;
        this.samples = new ArrayList<>();
        this.map = new HashMap<>();

       /* for(Map.Entry <Sample, Map <String, ValueRecords> > e : map.entrySet()){
            for(Map.Entry<String, ValueRecords> e1 : map.get(e.getKey()).entrySet()){
                Sample sample = e.getKey();
                String sigla = e1.getKey();
                ValueRecords records = e1.getValue();
                records.getMinValue();
                records.getMaxValue();
                records.getRegisteredValue();
            }
        }*/
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

    public String getDescription() {
        return description;
    }

    public Map<Sample, Map<String, ValueRecords>> getMap() {
        return map;
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
