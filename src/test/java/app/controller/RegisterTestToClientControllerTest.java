package app.controller;

import app.domain.model.Category;
import app.domain.model.ParameterTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTestToClientControllerTest {

    private RegisterTestToClientController ctrl;


    @BeforeEach
    void setUp() {

        ctrl = new RegisterTestToClientController();

    }

    @AfterEach
    void tearDown() {
        ctrl = null;
    }
    @Test
    void createTest() {



        ctrl = new RegisterTestToClientController();

         try {
             ArrayList<Category> categories = new ArrayList<>();
             ArrayList<ParameterTest> parameterTests = new ArrayList<>();
             categories.add(new Category("name", "2112432"));
             parameterTests.add(new ParameterTest("1111", "asd", "jjjj"));
             ctrl.createTest("1111111111", "1111", "safs", "1111", categories, parameterTests);

         } catch (IllegalArgumentException e) {
             fail();
         }
         try {
             ArrayList<Category> categories = new ArrayList<>();
             ArrayList<ParameterTest> parameterTests = new ArrayList<>();
             categories.add(new Category("name", "2112432"));
             parameterTests.add(new ParameterTest("1111", "asd", "jjjj"));
             ctrl.createTest("1111111111", "1111", "safs", "1111", categories, parameterTests);


         } catch (IllegalArgumentException e) {

         }

    }

    RegisterTestToClientController controller;
    }
