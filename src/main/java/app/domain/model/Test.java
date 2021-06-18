package app.domain.model;
import app.controller.App;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test implements Serializable {

    private String testID;
    private final String tinNumber;
    private final String nhscode;
    private final String description;
    private final String idTestType;
    private final ArrayList<String> listCodeCategory;
    private final ArrayList<String> listParameterTestCode;
    private final ArrayList<Sample> samples;

    //Test_Validation_DateHour
    private Date Test_Validation_DateHour;

    //Test_Doctor_DateHour
    private Date Test_Doctor_DateHour;

    //Test_Chemical_DateHour
    private Date Test_Chemical_DateHour;

    //Test_Reg_DateHour
    private Date Test_Reg_DateHour;

    public Test(String tinNumber, String nhscode, String description, String idTestType ,ArrayList<String> listCodeCategory, ArrayList<String> listParameterTestCode) {
        this.testID = generateID();
        this.tinNumber = tinNumber;
        this.nhscode = nhscode;
        this.description = description;
        this.idTestType = idTestType;
        this.listCodeCategory = listCodeCategory;
        this.listParameterTestCode = listParameterTestCode;
        this.samples = new ArrayList<>();

        this.Test_Chemical_DateHour = null;
        this.Test_Doctor_DateHour = null;
        this.Test_Reg_DateHour = null;
        this.Test_Validation_DateHour = null;
    }


    private String generateID() {
        Company company = App.getInstance().getCompany();
        if(company.tests.size()==0)
            return String.valueOf(1);
        //look for the last id and generate the next id
        Integer integer = Integer.parseInt(company.tests.get(company.tests.size()-1).getTestID())+1;

        return String.valueOf(integer);
    }

    //if manual id attribution is required
    public boolean setTestID( String testID ){
        //System.out.println(this.testID);
        //System.out.println(testID);
        Company company = App.getInstance().getCompany();
        if(Integer.valueOf(this.testID)<=Integer.valueOf(testID)) {
            this.testID = testID;
            return true;
        } else {
            throw new IllegalArgumentException("This test ID invalidates logical order: " + testID +
                    ", previous id: " + company.tests.get(company.tests.size() - 1).getTestID());
        }
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

    public void setTest_Validation_DateHour(Date test_Validation_DateHour) {
        Test_Validation_DateHour = test_Validation_DateHour;
    }

    public void setTest_Doctor_DateHour(Date test_Doctor_DateHour) {
        Test_Doctor_DateHour = test_Doctor_DateHour;
    }

    public void setTest_Chemical_DateHour(Date test_Chemical_DateHour) {
        Test_Chemical_DateHour = test_Chemical_DateHour;
    }

    public void setTest_Reg_DateHour(Date test_Reg_DateHour) {
        Test_Reg_DateHour = test_Reg_DateHour;
    }

    public String toStringIdTest(){
        return "Test ID: " + testID;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String Validation_DateHour = (this.Test_Validation_DateHour!=null)?sdf.format(this.Test_Validation_DateHour):"null";
        String Doctor_DateHour = (this.Test_Doctor_DateHour!=null)?sdf.format(this.Test_Doctor_DateHour):"null";
        String Chemical_DateHour = (this.Test_Chemical_DateHour!=null)?sdf.format(this.Test_Chemical_DateHour):"null";
        String Reg_DateHour = (this.Test_Reg_DateHour!=null)?sdf.format(this.Test_Reg_DateHour):"null";

        return "Test{" +
                "testID='" + testID + '\'' +
                ", tinNumber='" + tinNumber + '\'' +
                ", nhscode='" + nhscode + '\'' +
                ", description='" + description + '\'' +
                ", idTestType='" + idTestType + '\'' +
                ", listCodeCategory=" + listCodeCategory +
                ", listParameterTestCode=" + listParameterTestCode +
                ", samples=" + samples +
                ", Test_Validation_DateHour=" + Validation_DateHour +
                ", Test_Doctor_DateHour=" + Doctor_DateHour +
                ", Test_Chemical_DateHour=" + Chemical_DateHour +
                ", Test_Reg_DateHour=" + Reg_DateHour +
                '}';
    }
}
