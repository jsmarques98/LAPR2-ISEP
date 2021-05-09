package app.domain.model;

import app.controller.RegisterTest;
import app.controller.TestTypeRecord;
import auth.AuthFacade;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;


    private Set<Client> clients;
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




    public boolean save(Client client) {
        //return false if already exists
        if(clients.contains(client)){
            return false;

        }
        else{

            clients.add(client);
            System.out.println(clients);
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
            sendEmailWithPassword(e.getId(), e.getPasswordEmployee());
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
    private List<RegisterLab> registerLabList;

    /**
     * The array list where the objects of the test are going to be stored
     */
    private List<RegisterTest> registerTestList;

    /**
     * Registering the lab that is going to be created
     *
     * @param labId   the id of the lab that is being registered
     * @param name    the name of the lab that is being registered
     * @param address the address of the lab that is being registered
     * @param phoneNr the phone number of the lab that is being registered
     * @param TINnr   the TIN number of the lab that is being registered
     * @return the object of the lab created
     */
    public RegisterLab registerLab(String labId, String name, String address, int phoneNr, int TINnr) {
        return new RegisterLab(labId, name, address, phoneNr, TINnr);
    }

    /**
     * Registering the test that is going to be created
     *
     * @param testName the name of the test that is being registered
     * @param sample   the sample of the test that is being registered
     * @return the object of the test created
     */
    public RegisterTest registerTest(String testName, String sample) {
        return new RegisterTest(testName, sample);
    }

    /**
     * Checking if the lab is valid or not
     *
     * @param lab object of the lab created
     * @return if the object of the lab can or cannot be validated
     */
    public boolean validateLab(RegisterLab lab) {
        if (lab == null) {
            return false;
        }
        return !this.registerLabList.contains(lab);
    }

    /**
     * Checking if the test is valid or not
     *
     * @param test object of the test created
     * @return if the object of the test can or cannot be created
     */
    public boolean validateTest(RegisterTest test) {
        if (test == null) {
            return false;
        }
        return !this.registerTestList.contains(test);
    }

    /**
     * Saves the object lab in the array list
     *
     * @param lab object of the lab to be saved
     * @return the object lab added to the array list
     */
    public boolean saveLab(RegisterLab lab) {
        if (!validateLab(lab)) {
            return false;
        }
        return this.registerLabList.add(lab);
    }

    /**
     * Saves the object test in the array list
     *
     * @param test object of the test to be saved
     * @return the object test added to the array list
     */
    public boolean saveTest(RegisterTest test) {
        if (!validateTest(test)) {
            return false;
        }
        return this.registerTestList.add(test);
    }


}
