//package app.controller;
//
//import app.domain.model.Category;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SpecifyTypeTestControllerTest {
//
//    @BeforeEach
//    void setUp() {
//
//        controller = new SpecifyTypeTestController();
//
//    }
//
//    @AfterEach
//    void tearDown() {
//        controller = null;
//    }
//
//    @Test
//    void specifyTypeOfTest() {
//        try {
//            Set<Category> categories = new HashSet<>();
//            categories.add(new Category("name", "2112432"));
//            controller.specifyTypeOfTest("214ad", "Teste", "Seringa", categories);
//
//        } catch (IllegalArgumentException e) {
//            fail();
//        }
//        try {
//            Set<Category> categories = new HashSet<>();
//            categories.add(new Category("name", "2112432"));
//            controller.specifyTypeOfTest("214add", "Teste", "Seringa", categories);
//            fail();
//
//        } catch (IllegalArgumentException e) {
//
//        }
//    }
//
//
//    SpecifyTypeTestController controller;
//}