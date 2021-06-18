package app.domain.model;

import app.domain.shared.Constants;
import auth.AuthFacade;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company implements Serializable {

    private String designation;
    private AuthFacade authFacade;
    public List<Test> tests;
    public List<ValueRecords> valueRecordsList;
    public List<ParameterTest> parameterList;
    public List<TestType> records;
    public List<Category> categories;
    public List<Client> clientsList;
    //us18/19
    //All dates from yesterday and x days ago acording to the number of historical day points
    public List<LocalDate> dateList;
    //Date interval chosen by admin
    public List<LocalDate> finaldatesList;
    public List<Lab> labList;
    public List<Employee> employeeList;
    public List<Diagnosis> reportedTestsList;


    //us3
    public Company(String designation) {
        if (designation.length() < 1)
            throw new IllegalArgumentException("Designation cannot be blank.");
        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.valueRecordsList = new ArrayList<>();
        this.tests = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.clientsList =  new ArrayList<>();
        this.parameterList = new ArrayList<>();
        this.records = new ArrayList<>();
        dateList = new ArrayList<>();
        finaldatesList = new ArrayList<>();
        labList = new ArrayList<>(1);
        employeeList = new ArrayList<>(1);
        reportedTestsList = new ArrayList<>(1);

    }


    public List<ValueRecords> getValueRecords(String testID) {
        ArrayList<ValueRecords> returnList = new ArrayList<>();
        for( ValueRecords valueRecords : valueRecordsList){
            if (valueRecords.getId().equals(testID))
                returnList.add(valueRecords);
        }
        return returnList;
    }


    public Client getClient(String email){
        for( Client client : clientsList )
            if( client.email.equals(email) )
                return client;
        return null;
    }

    Category getCategory(String codeCategory){
        //for (Category category : TestType.getCategories()) {
          //  if (category.getCode().equals(codeCategory)) {
            //    return category;
         //   }
       // }
        return new Category(codeCategory,codeCategory);
    }

    public ParameterTest getParameterTest(String code){
        for( ParameterTest parameterTest : parameterList ) {
            if (parameterTest.getCode().equals(code))
                return parameterTest;
        }
        return null;
    }


    public List<ValueRecords> getValueRecordsList() {
        return valueRecordsList;
    }

    public ArrayList<ValueRecords> getValueRecordsList(String testId) {
        ArrayList<ValueRecords> valueRecordsList = new ArrayList<>();
        for (ValueRecords valueRecords : this.getValueRecordsList())
            if(valueRecords.getId().equals(testId))
                valueRecordsList.add(valueRecords);

    return valueRecordsList;
    }

    /**
     * Get Categories
     * @return
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Saves the instance of the testType created in the SpecifyTypeTest
     * @param testType
     * @return
     */
    public boolean save(TestType testType) {
        return records.add(testType);
    }

    public List<Test> getTests() {
        return tests;
    }

    public Test getTest( String testId ) {
        for(Test current : this.getTests())
            if(current.getTestID().equals(testId))
                return current;

        return null;
    }

    public List<Test> getAvailableTests() {
        ArrayList<Test> availableTests = new ArrayList<>();
        for(Test current : this.getTests())
            if(current.getSamples().size() == 0)
                availableTests.add(current);

        return availableTests;
    }

    public boolean save(Test test){
        return this.getTests().add(test);
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }


//    us7


    public Employee createEmloyee(String role, String name, String address, String phoneNumber, String email, String socCode, Lab lab) {
        return new Employee(role, name, address, phoneNumber, email, socCode,lab);
    }

    public Employee createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String socCode, Lab lab, String indxNumber) {
        return new SpecialistDoctor(role, name, address, phoneNumber, email, socCode, lab, indxNumber);
    }

    public boolean validateEmployee(Employee e) {
        if (e == null)
            return false;
        return !this.employeeList.contains(e);
    }

    public boolean saveEmployee(Employee e) {
        if (!validateEmployee(e)) {
            return false;
        } else {
            String text = "Email: " + e.getEmail() + "\nPassword: " + e.getPassword();
            createFile(e.getId(), text);
            authFacade.addUserWithRole(e.getName(),e.getEmail(),e.getPassword(),e.getRoleId());
            return this.employeeList.add(e);
        }
    }

    public void createFile(String name, String textToWrite) {
        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                writeFile(name, textToWrite);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeFile(String name, String textToWrite) {
        try {
            FileWriter myWriter = new FileWriter(name);
            myWriter.write(textToWrite);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public List<Client> getClientsList() {
        return clientsList;
    }

    public Client createClient(String name, String TINNumber, String address, String gender, String cCard, String nhs, String date, String phoneNumber, String email) {
        return new Client(name, TINNumber, address, gender, cCard, nhs, date, phoneNumber, email);
    }
        public boolean validateClient(Client c) {
            if (c == null)
                return false;
            return !this.clientsList.contains(c);
        }

        public boolean saveClient(Client c) {
            if (!validateClient(c)) {
                return false;
            } else {
                authFacade.addUserWithRole(c.getName(),c.getEmail(),c.getPassword(), Constants.ROLE_CLIENT);
                String text = "Email: " + c.getEmail() + "\nPassword: " + c.getPassword();
                createFile("clients/"+c.getName(), text);
                return this.clientsList.add(c);
            }
        }


    /**
     * Registering the lab that is going to be created
     *
     * @param labId   the id of the lab that is being registered
     * @param name    the name of the lab that is being registered
     * @param address the address of the lab that is being registered
     * @param phoneNr the phone number of the lab that is being registered
     * @param tin   the TIN number of the lab that is being registered
     * @return the object of the lab created
     */
    public Lab registerLab(String labId, String name, String address, String phoneNr, String tin) {
        return new Lab(labId, name, address, phoneNr, tin);
    }


    /**
     * Checking if the lab is valid or not
     *
     * @param lab object of the lab created
     * @return if the object of the lab can or cannot be validated
     */
    public boolean validateLab(Lab lab) {
        if (lab == null) {
            return false;
        }
        return !this.labList.contains(lab);
    }

    /**
     * Saves the object lab in the array list
     *
     * @param lab object of the lab to be saved
     * @return the object lab added to the array list
     */
    public boolean saveLab(Lab lab) {
        if (!validateLab(lab)) {
            return false;
        }
        return this.labList.add(lab);
    }

    // US14
   public List<Test> getTest(){
        return this.tests;
    }

    public Diagnosis createReport(String report, Test test){
        return new Diagnosis(report, test);
    }

    public boolean validateReport(Diagnosis writeRep){
        if (writeRep == null){
            return false;
        }
        return !this.reportedTestsList.contains(writeRep);
    }


    public boolean addReport(Diagnosis writeRep){
        if (!validateReport(writeRep)) {
            return false;
        }
        return this.reportedTestsList.add(writeRep);
    }

    //us4
    public Test createtest(String tinNumber, String nhscode, String description, String idTestType , ArrayList listCodeCategory, ArrayList listParameterTestCode)  {
        return new Test(tinNumber, nhscode, description, idTestType ,listCodeCategory, listParameterTestCode);
    }

    public boolean validateTest(Test t) {
        if (t == null)
            return false;
        return !this.tests.contains(t);
    }

    public boolean saveTest(Test t) {
        if (!validateTest(t)) {
            return false;
        } else {
            return this.tests.add(t);
        }
    }


    public TestType getTestType(String collection) {
        //for(TestType testType : Company.getTestTypes().getRecord()){
          //  if(testType.getCollection().equals(collection))
            //    return testType;
        //}
        return new TestType("00000",collection,collection,null);
    }



    //us12

    public ValueRecords createValueRecords(String id, double min, double max, double registeredValue, String parametro, Date data) {

        return new ValueRecords(id, min, max, registeredValue, parametro, data);
    }


    public boolean validateValueRecords(ValueRecords valueRecords) {
        if (valueRecords == null)
            return false;
        return !this.valueRecordsList.contains(valueRecords);
    }

    public boolean saveValueRecords(ValueRecords valueRecords) {
        if (!validateValueRecords(valueRecords)) {
            return false;
        } else {
            return this.valueRecordsList.add(valueRecords);
        }
    }


    //us15

   public List<Test> getTestsWhitSamples() {
       ArrayList<Test> availableTests = new ArrayList<>();
       for(Test current : this.getTests())
           if(current.getSamples().size() != 0)
               availableTests.add(current);
       return availableTests;
   }

    public List<Test> getTestsToValidate() {
        ArrayList<Test> availableTests = new ArrayList<>();
        for(Test current : this.getTests())
            if(current.getTest_Chemical_DateHour()!=null &&
            current.getTest_Doctor_DateHour()!=null &&
            current.getTest_Reg_DateHour() != null &&
            current.getTest_Validation_DateHour() == null)
                availableTests.add(current);
        return availableTests;
    }




}



