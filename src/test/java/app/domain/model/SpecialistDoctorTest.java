package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialistDoctorTest {

    public final SpecialistDoctor sd1;
    public final List<Employee> employeeList;
    public final Lab lab1;

    public SpecialistDoctorTest() {
        lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
        sd1 = new SpecialistDoctor("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd", lab1,"1111");
        employeeList = new ArrayList<>();
        employeeList.add(sd1);
    }

    @Test
    public void teste(){
        Employee criada = employeeList.get(0);
        assertEquals(sd1,criada);
    }

}