package app.ui.console;

import app.controller.App;
import app.controller.Company;
import app.controller.RegisterTestToClientController;
import app.domain.model.*;
import app.ui.console.utils.Utils;
import java.util.ArrayList;

public class RegisterTestToClientUI implements Runnable{

    private RegisterTestToClientController controller;
    private Company company;

    public RegisterTestToClientUI(){
        controller = new RegisterTestToClientController();
        company = App.getInstance().getCompany();
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



        if(Utils.confirm()){
            if (controller.createTest(tinNumber, nhscode, description, idTestType , listCodeCategory, listParameterTestCode)) {
                System.out.println("Test successfully created");
                controller.saveTest();
            } else {
                System.out.println("Test not created");
            }
        }else{
            System.out.println("Operation canceled");
        }

        Company company = App.getInstance().getCompany();

        for (int i = 0; i < company.tests.size(); i++) {
            System.out.println(company.tests.get(i));
        }
        }
    }

    private String selectTINNumber() {
        Company company = App.getInstance().getCompany();
        String tinNumber = Utils.readLineFromConsole("Enter TIN Number (0 to cancel): ");
        for(Client client : company.clientsList) {
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
        System.out.println("Test Type List: ");
        System.out.println(company.records);
        String idTest = Utils.readLineFromConsole("Enter id Test type: ");
        for(TestType testType : company.records) {
            if (testType.getId().equals(idTest)){
                return idTest;
            }

        }
        System.out.println("Id not found.");
        return selectIdTestType();
    }
    private ArrayList selectCodeCategory(String idTestType) {
        Company company = App.getInstance().getCompany();
        ArrayList codeCategoryList = new ArrayList();
        String codeCategory = "";
        boolean flag1 = false;
        System.out.println("\nCodeCategory List: ");
        for(TestType testType : company.records) {
            if(testType.getId().equals(idTestType)){
                System.out.println(testType.getCategories());
            }
        }
        while(!codeCategory.equals("0")){
            codeCategory = Utils.readLineFromConsole("Enter Code Category or 0 to exit: ");
            for(Category category : TestType.getCategories()) {

                System.out.println(category.toString());

                if(category.getCode().equals(codeCategory)){
                    if(!codeCategoryList.contains(codeCategory)){
                        codeCategoryList.add(category.getCode());
                        flag1 = true;
                    }
                }
            }
            if(!codeCategory.equals("0") && flag1 == false){
                System.out.println("Code Category not found or already insert.");
            }
            flag1 = false;
        }
        return codeCategoryList;
    }


    private ArrayList selectParameterTestCode() {
        Company company = App.getInstance().getCompany();
        ArrayList parameterTestCodeList = new ArrayList();
        String parameterTestCode = "";
        boolean flag1 = false;
        System.out.println("\nParameter Test List: ");
        for(ParameterTest parameterTest : company.parameterList) {
            System.out.println(parameterTest.toString());
        }
        while(!parameterTestCode.equals("0")){
            parameterTestCode = Utils.readLineFromConsole("Enter Parameter Test Code or 0 to exit: ");
            for(ParameterTest parameterTest : company.parameterList) {
                if(parameterTest.getCode().equals(parameterTestCode)){
                    if(!parameterTestCodeList.contains(parameterTestCode)){
                        parameterTestCodeList.add(parameterTest.getCode());
                        flag1 = true;
                    }
                }
            }
            if(!parameterTestCode.equals("0") && flag1 == false){
                System.out.println("Parameter Test Code not found or already insert.");
            }
            flag1 = false;
        }
        return parameterTestCodeList;
    }
}
