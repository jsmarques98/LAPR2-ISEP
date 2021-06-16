package app.domain.model;

import app.controller.App;
import app.controller.TestTypeRecord;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.domain.store.UserRoleStore;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company implements Serializable {

    private String designation;
    private AuthFacade authFacade;


    public static List<Test> tests = new ArrayList<>();

    public static List<ValueRecords> valueRecordsList = new ArrayList<>();


    public Client getClient(String email){
        for( Client client : clientsList )
            if( client.email.equals(email) )
                return client;
        return null;
    }


    public static List<ParameterTest> parameterList = new ArrayList<>();

    public static List<TestType> record;

    //us9

    /**
     * Array list where the objects are going to be stored
     */
    public static List<Category> categories;

    /**
     * The test type record.
     */
    public static TestTypeRecord testTypes;

    /**
     * Get TestTypes
     * @return
     */
    public static TestTypeRecord getTestTypes() {
        return testTypes;
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
        return testTypes.appendTestType(testType);
    }

    public List<Test> getTests() {
        return tests;
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



    public boolean save(Client client) {
        //return false if already exists
        if(clientsList.contains(client)){
            return false;
        }
        else{
            authFacade.addUserWithRole(client.getName(),client.getEmail(),client.getPassword(), Constants.ROLE_CLIENT);
            clientsList.add(client);
            return true;
        }

    }

    public Company(String designation) {
        if (designation.length() < 1)
            throw new IllegalArgumentException("Designation cannot be blank.");
        this.testTypes = new TestTypeRecord();
        this.categories = new ArrayList<>();

        this.designation = designation;
        this.authFacade = new AuthFacade();

        this.tests = new ArrayList<>();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }


//    us7

    public static List<Employee> employeeList = new ArrayList<>(1);

    public static Employee createEmloyee(String role, String name, String address, String phoneNumber, String email, String socCode, Lab lab) {
        return new Employee(role, name, address, phoneNumber, email, socCode,lab);
    }

    public static Employee createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String socCode, Lab lab, String indxNumber) {
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
            sendEmailWithPassword(e.getId(), text);
            authFacade.addUserWithRole(e.getName(),e.getEmail(),e.getPassword(),e.getRoleId());
            return this.employeeList.add(e);
        }
    }

    public static void sendEmailWithPassword(String idParaONome, String textoAEnviar) {
        try {
            File myObj = new File(idParaONome);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                writePassword(idParaONome, textoAEnviar);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writePassword(String idParaONome, String textToWrite) {
        try {
            FileWriter myWriter = new FileWriter(idParaONome);
            myWriter.write(textToWrite);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //us3

    public static List<Client> clientsList = new ArrayList<>();


    public static Client createClient(String name, String TINNumber, String cCard, String nhs, String date, String phoneNumber, String email) {

        return new Client(name, TINNumber, cCard, nhs, date, phoneNumber, email);
    }
        public boolean validateClient(Client e) {
            if (e == null)
                return false;
            return !this.clientsList.contains(e);
        }

        public boolean saveClient(Client e) {
            if (!validateClient(e)) {
                return false;
            } else {
                sendEmailWithPassword(e.getRoleID(), e.getPassword());
                authFacade.addUserWithRole(e.getName(),e.getEmail(),e.getPassword(),e.getRoleID());
                return this.clientsList.add(e);
            }
        }





//    us8

    /**
     * The array list where the objects of the lab are going to be stored
     */
    public static List<Lab> labList = new ArrayList<>(1);


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

    public static List<Diagnosis> reportedTestsList = new ArrayList<>(1);

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


    public static Test createtest(String tinNumber, String nhscode, String description, String idTestType , ArrayList listCodeCategory, ArrayList listParameterTestCode)  {
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


    //us12

    public ValueRecords createValueRecords(String id, double min, double max, double registeredValue, String parametro) {

        return new ValueRecords(id, min, max, registeredValue, parametro);
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
}



