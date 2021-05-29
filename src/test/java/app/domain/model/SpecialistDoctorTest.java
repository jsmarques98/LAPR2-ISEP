package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialistDoctorTest {

    public final SpecialistDoctor sd1;
    public final List<Employee> employeeList;

    public SpecialistDoctorTest() {
        sd1 = new SpecialistDoctor("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd", "1111");
        employeeList = new ArrayList<>();
        employeeList.add(sd1);
    }

    @Test
    public void teste(){
        Employee criada = employeeList.get(0);
        assertEquals(sd1,criada);
    }

}