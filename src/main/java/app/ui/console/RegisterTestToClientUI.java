package app.ui.console;

import app.controller.RegisterTestToClientController;
import app.controller.TestTypeRecord;
import app.domain.model.*;
import app.ui.console.utils.Utils;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;

public class RegisterTestToClientUI implements Runnable{

    private RegisterTestToClientController controller;

    public RegisterTestToClientUI(){
        controller = new RegisterTestToClientController();
    }

    @Override
    public void run() {

        String tinNumber = selectTINNumber();
        if(!tinNumber.equals("0")){
        String nhscode = selectNhsCode();
        String description = selectDescription();
        String idTestType = selectIdTestType();
        ArrayList listCodeCategory = selectCodeCategory(idTestType);
        ArrayList listParameterTestCode = selectParameterTestCode();

        controller.createTest(tinNumber, nhscode, description, idTestType , listCodeCategory, listParameterTestCode);
        }
    }

    private String selectTINNumber() {
        String tinNumber = Utils.readLineFromConsole("Enter TIN Number (0 to cancel): ");
        for(Client client : Company.clientsList) {
            if (client.getTINNumber().equals(tinNumber)){
                return client.getTINNumber();
            }
            if(tinNumber.equals("0")){
                return tinNumber;
            }
        }
        System.out.println("TIN Number not found.");
        return selectTINNumber();
    }
    public String selectNhsCode(){
        String nhscode = Utils.readLineFromConsole("Enter nhsCode: ");
        if (nhscode.length() > 12 || nhscode.length() == 0){
            System.out.println("nhsCode must have less than 12 chars and can't null.");
            return selectNhsCode();
        }
        return nhscode;
    }
    public String selectDescription(){
        String description = Utils.readLineFromConsole("Enter description: ");
        if (description.length() > 20 || description.length() == 0){
            System.out.println("description must have less than 20 chars and can't null.");
            return selectDescription();
        }
        return description;
    }
    public String selectIdTestType(){
        System.out.println("TestType List: ");
        for(TestType testType : Company.testList) {
            System.out.println(testType.toString());
        }
        String idTest = Utils.readLineFromConsole("Enter idTest: ");
        for(TestType testType : Company.testList) {
            if (testType.getId().equals(idTest)){
                return idTest;
            }
        }
        System.out.println("Id not found.");
        return selectIdTestType();
    }


    private ArrayList selectCodeCategory(String idTestType) {
        System.out.println("CodeCategory List: ");
        for(TestType testType : Company.testList) {
            if (testType.getId().equals(idTestType)){
                for(Category cat : Company.categories) {
                    System.out.println(cat);
                }
            }
        }
        String codeCategory = Utils.readLineFromConsole("Enter CodeCategory: ");

        return null;
    }
    private ArrayList selectParameterTestCode() {

        return null;
    }
}
