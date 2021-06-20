package app.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category("categoria1", "codigo1");
    }

    @AfterEach
    void tearDown() {
        category = null;
    }

    @Test
    void getName() {
        assertEquals("categoria1", category.getName());
    }

    @Test
    void setName() {
        assertEquals("categoria1", category.getName());
        category.setName("categorianumero1");
        assertEquals("categorianumero1", category.getName());
    }

    @Test
    void getCode() {
        assertEquals("codigo1", category.getCode());
    }

    @Test
    void setCode() {
        assertEquals("codigo1", category.getCode());
        category.setCode("codigonumero1");
        assertEquals("codigonumero1", category.getCode());
    }

    @Test
    void compareTo() {
        Category c1= new Category("categoria1", "codigo1");
        Category c2= new Category("categoria2", "codigo2");
        Assertions.assertEquals(14, c1.compareTo(c2));

    }

    @Test
    void testToString() {
        assertFalse(category.toString().isEmpty());
    }
}