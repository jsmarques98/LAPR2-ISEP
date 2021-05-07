package app.domain.model;

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

    String[] r = new String[5];
    r[0] = "recepcionist";
    r[1] = "clincal chemestry technologist";
    r[2] = "laboratory coordinator";
    r[3] = "medical lab technician";
    r[4] = "specialist doctor";



    public Employee createEmloyee(String id, String role, String name, String address, String phoneNumber, String email, String socCode){
        return  new Employee(id, role, name, address, phoneNumber, email, socCode);
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



}
