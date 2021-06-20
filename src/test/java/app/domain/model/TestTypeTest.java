package app.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TestTypeTest {

    private TestType testType;

    @BeforeEach
    void setUp() {
        Set<Category> categories = new HashSet<>();
        Category category1 = new Category("categoria1","codigo1");
        categories.add(category1);
        testType = new TestType("12345", "Descricao", "Seringa", categories );
    }

    @AfterEach
    void tearDown() {
        testType = null;
    }

    @Test
    void getId() {
        assertEquals("12345", testType.getId());
    }

    @Test
    void getDescription() {
        assertEquals("Descricao", testType.getDescription());
    }

    @Test
    void getCollection() {assertEquals("Seringa", testType.getCollection());
    }

    @Test
    void getCategories() {
        Set<Category> categories = new HashSet<>();
        Category category1 = new Category("categoria1","codigo1");
        categories.add(category1);
        assertEquals(categories.size(), testType.getCategories().size());
    }

    @Test
    void validate() {
        boolean flag = true;
        flag = testType.validate();
        assertTrue(flag);
    }

    @Test
    void testToString() {
        assertFalse(testType.toString().isEmpty());
    }
}