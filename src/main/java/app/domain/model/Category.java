package app.domain.model;

public class Category implements Comparable {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s", this.getName());
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

    @Override
    public int compareTo( Object o) {
        Category c = (Category) o ;
        return code.compareTo(c.getName());
    }
}
