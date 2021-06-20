package app.domain.model;
import app.controller.App;
import app.controller.Company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test implements Serializable, Comparable {

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
        while(!setTestID(String.valueOf(integer)))
            integer++;

        return String.valueOf(integer);
    }

    //if manual id attribution is required
    public boolean setTestID( String testID ){

        //look for every test id
        Company company = App.getInstance().getCompany();

        Test foundTest = company.getTest(testID);

        //Integer.valueOf(this.testID)<=Integer.valueOf(testID)
        if(foundTest == null) {
            this.testID = testID;
            return true;
        } else {
            System.out.println("Test with this id exists!");
            return false;

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

    public Date getTest_Reg_DateHour() {
        return Test_Reg_DateHour;
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

    public String toStringIdTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String Reg_DateHour = (this.Test_Reg_DateHour != null) ? sdf.format(this.Test_Reg_DateHour) : "null";
        return "Test ID: " + testID + " | Date: " + Reg_DateHour;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String Validation_DateHour = (this.Test_Validation_DateHour != null) ? sdf.format(this.Test_Validation_DateHour) : "null";
        String Doctor_DateHour = (this.Test_Doctor_DateHour != null) ? sdf.format(this.Test_Doctor_DateHour) : "null";
        String Chemical_DateHour = (this.Test_Chemical_DateHour != null) ? sdf.format(this.Test_Chemical_DateHour) : "null";
        String Reg_DateHour = (this.Test_Reg_DateHour != null) ? sdf.format(this.Test_Reg_DateHour) : "null";

        return "Test{" + " Test ID: " + testID + " | TIN Number: " + tinNumber + " | Description: " + description + " | Test Type ID: " + idTestType + " | List Code Category: " +
                listCodeCategory + " | List Parameter Test Code: " + listParameterTestCode + " | Samples: " + samples + " | Test Validation Date/Hour: " + Validation_DateHour +
                " | Doctor Test Date/Hour: " + Doctor_DateHour + " | Chemical Test Date/Hour: " + Chemical_DateHour + " | Reg. Test Date/Hour: " + Reg_DateHour + " }";

    }

    @Override
    public int compareTo(Object test) {
        Date date1 = this.Test_Reg_DateHour;
        Date date2 = ((Test) test).Test_Reg_DateHour;

        if (date1.before(date2))
            return -1;
        else if (date1.after(date2))
            return 1;
        else
            return 0;

    }
    public Date getTest_Validation_DateHour() {
        return Test_Validation_DateHour;
    }

    public Date getTest_Doctor_DateHour() {
        return Test_Doctor_DateHour;
    }

    public Date getTest_Chemical_DateHour() {
        return Test_Chemical_DateHour;
    }
}
