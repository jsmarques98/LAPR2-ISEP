package app.domain.model;

public class ParameterTest {

    private String code;
    private String shortName;
    private String designation;

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
        return "ParameterTest{" +
                "code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
