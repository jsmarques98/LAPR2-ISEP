package app.controller;

import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestTypeRecord {
    private List<TestType>record;

    public TestTypeRecord() {
        record = new ArrayList<>();
    }

    public boolean appendTestType(TestType type){
        return record.add(type);
    }
}
