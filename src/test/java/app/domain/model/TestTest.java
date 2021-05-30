package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTest {

    private final app.domain.model.Test test1;
    private final List<app.domain.model.Test> TestList;
    private final ArrayList listCat;
    private final ArrayList listPara;


    public TestTest() {

        Category category1 = new Category("categoria1","codigo1");
        Category category2 = new Category("categoria2","codigo2");
        ParameterTest parameterTest1 = new ParameterTest("c1","sangue","desc1");
        ParameterTest parameterTest2 = new ParameterTest("c2","sangue","desc2");
        listCat = new ArrayList<>();
        listPara = new ArrayList<>();
        listCat.add(category1);
        listCat.add(category2);
        listPara.add(parameterTest1);
        listPara.add(parameterTest2);
        test1 = new app.domain.model.Test("0000000000","0000","sad","sdsad", listCat, listPara);
        TestList = new ArrayList<>();
        TestList.add(test1);
    }

    @Test
    void getTestID() {
        assertEquals(test1.getTestID(),test1.getTestID());
    }

    @Test
    void getNhscode() {
        assertEquals("0000",test1.getNhscode());
    }

    @Test
    void getDescription() {
        assertEquals("sad",test1.getDescription());
    }

//    @Test
//    void getSamples() {
//
//    }

    @Test
    void testToString() {
        String result = "Test{" +
                "testID='" + test1.getTestID() + '\'' +
                ", tinNumber='" + "0000000000" + '\'' +
                ", nhscode='" + test1.getNhscode() + '\'' +
                ", description='" + test1.getDescription() + '\'' +
                ", idTestType='" + "sdsad" + '\'' +
                ", listCodeCategory=" + listCat +
                ", listParameterTestCode=" + listPara +
                ", samples=" + "[]" + ", sampleLocalTime=null, sampleLocalDate=null" +
                '}';
        System.out.println(test1.toString());
        Assertions.assertEquals(result, test1.toString());
    }
}