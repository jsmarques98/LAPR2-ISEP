package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParameterTestTest {
    private final ParameterTest pt1;
    private final List<ParameterTest> ParameterTestList;

    public ParameterTestTest() {
        pt1 = new ParameterTest( "123", "rggg", "gfdgfdg");
        ParameterTestList = new ArrayList<>();
        ParameterTestList.add(pt1);
    }

    @Test
    void getCode() {
        String code = "123";
        String criada = pt1.getCode();
        assertEquals(code, criada);
    }

    @Test
    void testToString() {

        String result = String.format("ParameterTest{" +
                "code='" + pt1.getCode() + '\'' +
                ", shortName='" + "rggg" + '\'' +
                ", designation='" + "gfdgfdg" + '\'' +

                '}');

        Assertions.assertEquals(result, pt1.toString());
    }

}