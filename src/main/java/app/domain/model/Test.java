package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private String testID;
    private String nhscode;

    public Test(String testID, String nhscode) {
        this.testID = testID;
        this.nhscode = nhscode;
    }




    List<Sample> samples;

    public Test(){
        samples = new ArrayList<>();
    }




}
