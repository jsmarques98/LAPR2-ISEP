package app.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Comparable, Serializable {
    private String name;
    private String code;
    public ArrayList<ParameterTest> parameterTests;

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

    @Override
    public int compareTo( Object o) {
        Category c = (Category) o ;
        return code.compareTo(c.getName());
    }

    @Override
    public String toString() {
        return "Category{" + " Name: " + name + " | Code: " + code + " }";
    }
}
