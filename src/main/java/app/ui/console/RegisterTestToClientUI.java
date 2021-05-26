package app.ui.console;

import app.controller.RegisterTestToClientController;
import app.controller.TestTypeRecord;
import app.domain.model.*;
import app.ui.console.utils.Utils;

import java.util.ArrayList;

public class RegisterTestToClientUI implements Runnable{

    private RegisterTestToClientController controller;

    public RegisterTestToClientUI(){
        controller = new RegisterTestToClientController();
    }

    @Override
    public void run() {

        String ccNum = selectCCNumber();
        if(!ccNum.equals("0")){
        String nhscode = selectNhsCode();
        String description = selectDescription();

        String idTestType = selectIdTestType();

        ArrayList listCodeCategory = selectCodeCategory();
        ArrayList listParameterTestCode = selectParameterTestCode();

        controller.createTest(ccNum, nhscode, description, idTestType , listCodeCategory, listParameterTestCode);
        }
    }

    private String selectCCNumber() {
        String ccNum = Utils.readLineFromConsole("Enter CC Number (0 to cancel): ");
        for(Client client : Company.clientsList) {
            if (client.getCCNumber().equals(ccNum)){
                return client.getCCNumber();
            }
            if(ccNum.equals("0")){
                return ccNum;
            }
        }
        System.out.println("CCNumber not found.");
        return selectCCNumber();
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
        System.out.println("TestType List: " + "\n" + TestTypeRecord.record);
        String idTest = Utils.readLineFromConsole("Enter idTest: ");
        for(TestType testType : TestTypeRecord.record) {
            if (testType.getId().equals(idTest)){

            }
        }
        System.out.println("Id not found.");
        return selectIdTestType();
    }

    private ArrayList selectCodeCategory() {

        return null;
    }
    private ArrayList selectParameterTestCode() {

        return null;
    }
}
