package app.domain.model;

import java.io.Serializable;

public class ParameterTest implements Serializable {

    private final String code;
    private final String shortName;
    private final String designation;

    public ParameterTest(String code, String shortName, String designation){
        this.code = code;
        this.shortName = shortName;
        this.designation = designation;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ParameterTest{" + " Code: " + code + " | Short Name" + shortName + " | Designation: " + designation + " }";

    }
}
