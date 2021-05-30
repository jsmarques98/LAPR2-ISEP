package app.dto;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDTOTest {

    @Test
    public void TestTestDTO() {
        app.domain.model.Test test = new app.domain.model.Test("0000000000","0000","sad","sdsad", null, null);
        TestDTO testDTO = new TestDTO(test);

        assertEquals(test.getTestID(), testDTO.getTestID());
        assertEquals(test.getNhscode(), testDTO.getNhscode());

        String testID = test.getTestID();
        String nhscode = test.getNhscode();
        String str = "testID: " + testID + " nhscode: " + nhscode;
        assertEquals(str, testDTO.toString());

    }
}