package app.domain.model;

public class Category {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
