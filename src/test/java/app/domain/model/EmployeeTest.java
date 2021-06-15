package app.domain.model;

import app.domain.shared.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private final Employee e1;
    private final List<Employee> employeeList;
    public final Lab lab1;

    public EmployeeTest() {
        lab1 = new Lab("11111","laboratorio1","porto","99999999999","999999999");
        e1 = new Employee("ADMINISTRATOR","Maria Alegre","sad","asd","maria@gmail.com","asd", lab1);
        employeeList = new ArrayList<>();
        employeeList.add(e1);
    }

    @Test
    public void createEmployeeId() {
        String id = "MA1";
        String criada = e1.createEmployeeId();
        assertEquals(id,criada);
    }


    @Test
    public void generatePasswordEmployee() {
        String teste = "aaaaaaaaaa";
        String criada = Employee.generatePasswordEmployee();

        assertEquals(criada.length(),teste.length());
    }

    @Test
    public void testgetName() {
        String name = "Maria Alegre";
        String criada = e1.getName();
        assertEquals(name, criada);
    }

    @Test
    public void getId() {
        String id = "MA1";
        String criada = e1.getId();
        assertEquals(id, criada);
    }

    @Test
    public void getPassword() {
        int pass = 10;
        int criada = e1.getPassword().length();
        assertEquals(pass, criada);
    }

    @Test
    public void getRoleId() {
        String roleid = "ADMINISTRATOR";
        String criada = e1.getRoleId();
        assertEquals(roleid, criada);
    }

    @Test
    public void getEmail() {
        String mail = "maria@gmail.com";
        String criada = e1.getEmail();
        assertEquals(mail, criada);
    }

    @Test
    public void constantes() {
        String ROLE_ADMIN = "ADMINISTRATOR";
        String ROLE_RECEPTIONIST = "RECEPTIONIST";
        String ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST = "CLINICAL_CHEMESTRY_TECHNOLOGIST";
        String ROLE_LABORATORY_COORDINATOR = "LABORATORY_COORDINATOR";
        String ROLE_MEDICAL_LAB_TECHNICIAN = "MEDICAL_LAB_TECHNICIAN";
        String ROLE_SEPECIALIST_DOCTOR = "SPECIALIST_DOCTOR";
        String PARAMS_FILENAME = "config.properties";
        String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
        assertEquals(ROLE_ADMIN, Constants.ROLE_ADMIN);
        assertEquals(ROLE_RECEPTIONIST, Constants.ROLE_RECEPTIONIST);
        assertEquals(ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST, Constants.ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST);
        assertEquals(ROLE_LABORATORY_COORDINATOR, Constants.ROLE_LABORATORY_COORDINATOR);
        assertEquals(ROLE_MEDICAL_LAB_TECHNICIAN, Constants.ROLE_MEDICAL_LAB_TECHNICIAN);
        assertEquals(ROLE_SEPECIALIST_DOCTOR, Constants.ROLE_SEPECIALIST_DOCTOR);
        assertEquals(PARAMS_FILENAME, Constants.PARAMS_FILENAME);
        assertEquals(PARAMS_COMPANY_DESIGNATION, Constants.PARAMS_COMPANY_DESIGNATION);
    }

    @Test
    void testToString() {
        String result = String.format("Employee{" +
                "id='" + e1.getId() + '\'' +
                ", roleId='" + e1.getRoleId() + '\'' +
                ", name='" + e1.getName() + '\'' +
                ", address='" + "sad" + '\'' +
                ", phoneNumber='" + "asd" + '\'' +
                ", email='" + e1.getEmail() + '\'' +
                ", socCode='" + "asd" + '\'' +
                ", password='" + e1.getPassword() + '\'' +
                '}');

        Assertions.assertEquals(result, e1.toString());
    }


}
