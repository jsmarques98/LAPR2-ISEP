package app.controller;
import app.domain.model.Category;
import app.domain.model.TestType;

import java.util.Set;

public class SpecifyTypeTestController {


    public void specifyTypeOfTest(String id, String description, String collection, Set<Category>categories){
        TestType type = new TestType(id, description, collection, categories);
        if (validateTestType(type)){
            App.getInstance().accessPlatform().getTestTypes().appendTestType(type);
        }else{
            //TODO catch exception on UI
            throw new IllegalArgumentException("dados introduzidos são inválidos");
        }
    }

    private boolean validateTestType(TestType testType){
        return testType.validate();
    }


}
