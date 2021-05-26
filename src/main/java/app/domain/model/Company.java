package app.domain.model;

import app.controller.TestTypeRecord;
import auth.AuthFacade;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;


    private List<Test> tests;

    public static List<Client> clientsList = new ArrayList<>();

    private Set<Receptionist> receptionists;


    //us9

    /**
     * Array list where the objects are going to be stored
     */
    private List<Category> categories;

    /**
     * The test type record.
     */
    private TestTypeRecord testTypes;

    /**
     * Get TestTypes
     * @return
     */
    public TestTypeRecord getTestTypes() {
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

            clientsList.add(client);
            System.out.println(clientsList);
            return true;
        }

    }

    public Receptionist getReceptionist(String username) {

        return null;
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

    public static Employee createEmloyee(String role, String name, String address, String phoneNumber, String email, String socCode) {
        return new Employee(role, name, address, phoneNumber, email, socCode);
    }

    public static Employee createSpecialistDoctor(String role, String name, String address, String phoneNumber, String email, String socCode, String indxNumber) {
        return new SpecialistDoctor(role, name, address, phoneNumber, email, socCode, indxNumber);
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
            sendEmailWithPassword(e.getId(), e.getPassword());
            authFacade.addUserWithRole(e.getName(),e.getEmail(),e.getPassword(),e.getRoleId());
            return this.employeeList.add(e);
        }
    }

    public void sendEmailWithPassword(String idParaONome, String textoAEnviar) {
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

    public void writePassword(String idParaONome, String textToWrite) {
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


    public static List<Report> reportList = new ArrayList<>(1);

    public Report createReport(String report){
        return new Report(report);
    }

    public boolean validateReport(Report report){
        if (report == null){
            return false;
        }
        return !this.reportList.contains(report);
    }


    public boolean addReport(Report report){
        if (!validateReport(report)) {
            return false;
        }
        return this.reportList.add(report);
    }



    //us4

    public static List<Test> TestList = new ArrayList<>();

    public static Test createtest(String ccNum, String nhscode, String description, String idTestType ,String codeCategory, String designation)  {
        return new Test(ccNum, nhscode, description, idTestType ,codeCategory, designation);
    }

    public boolean validateTest(Test t) {
        if (t == null)
            return false;
        return !this.TestList.contains(t);
    }

    public boolean saveTest(Test t) {
        if (!validateTest(t)) {
            return false;
        } else {
            return this.TestList.add(t);
        }
    }
}



