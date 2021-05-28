package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private final Employee e1;
    private final List<Employee> employeeList;

    public EmployeeTest() {
        e1 = new Employee("ADMINISTRATOR","Maria Alegre","sad","asd","maria@gmail.com","asd");
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

}
