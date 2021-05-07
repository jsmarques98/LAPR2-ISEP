package app.domain.model;

import app.controller.RegisterLab;
import app.controller.RegisterTest;
import auth.AuthFacade;


import javax.management.relation.Role;
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

    public List<Employee>employeeList;


    public Employee createEmloyee(String id, String role, String name, String address, String phoneNumber, String email, String socCode, String passe){
        return  new Employee(id, role, name, address, phoneNumber, email, socCode, passe);
    }

    public boolean validateEmployee(Employee e) {
        if (e == null)
            return false;
        return ! this.employeeList.contains(e);
    }
    public boolean saveEmployee(Employee e) {
        if (!validateEmployee(e))
            return false;
        return this.employeeList.add(e);
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
