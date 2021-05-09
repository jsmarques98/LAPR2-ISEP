package app.domain.model;

import app.controller.RegisterLab;
import app.controller.RegisterTest;
import app.controller.TestTypeRecord;
import auth.AuthFacade;


import javax.management.relation.Role;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;


    private Set<Client> clients;
    private Set<Receptionist> receptionists;



    //us9

    private List<Category> categories;
    private TestTypeRecord testTypes;

    public TestTypeRecord getTestTypes() {
        return testTypes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public boolean save(TestType testType){
        return testTypes.appendTestType(testType);
    }






    public boolean save(Client client){
        //return false if already exists
        return true;
    }

    public Receptionist getReceptionist(String username){

        return null;
    }


    public Company(String designation)
    {
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

    public static List<Employee> employeeList;

    public Employee createEmloyee(String id, String role, String name, String address, String phoneNumber, String email, String socCode, String passe){
        return  new Employee(id, role, name, address, phoneNumber, email, socCode);
    }

    public boolean validateEmployee(Employee e) {
        if (e == null)
            return false;
        return ! this.employeeList.contains(e);
    }
    public boolean saveEmployee(Employee e) {
        if (!validateEmployee(e)){
            return false;
        }else {
            sendEmailWithPassword(e.getId(),e.getPasswordEmployee());
            return this.employeeList.add(e);
        }
    }

    public void sendEmailWithPassword(String idParaONome, String textoAEnviar){
        try {
            File myObj = new File(idParaONome);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                writePassword(idParaONome,textoAEnviar);
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
    private List<RegisterLab>registerLabList;
    private List<RegisterTest>registerTestList;

    public RegisterLab registerLab(String labId, String name, String address, int phoneNr, int TINnr){
        return new RegisterLab(labId, name, address, phoneNr, TINnr);
    }

    public RegisterTest registerTest(String testName, String sample){
        return new RegisterTest(testName, sample);
    }

    public boolean validateLab(RegisterLab lab){
        if (lab == null)
        {
            return false;
        }
        return ! this.registerLabList.contains(lab);
    }

    public boolean validateTest(RegisterTest test){
        if (test == null){
            return false;
        }
        return ! this.registerTestList.contains(test);
    }

    public boolean saveLab(RegisterLab lab){
        if (!validateLab(lab)){
            return false;
        }
        return this.registerLabList.add(lab);
    }

    public boolean saveTest(RegisterTest test){
        if (!validateTest(test)) {
            return false;
        }
        return this.registerTestList.add(test);
    }



}
