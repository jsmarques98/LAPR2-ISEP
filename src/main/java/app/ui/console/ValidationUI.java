package app.ui.console;

import app.controller.App;
import app.controller.ValidationController;
import app.controller.utils.FileUtil;
import app.domain.model.Company;
import app.domain.model.Test;
import app.ui.console.utils.Utils;

public class ValidationUI implements Runnable{

    private ValidationController controller;
    private Company company;
    private FileUtil fileutil;

    public ValidationUI(){
        company = App.getInstance().getCompany();
        controller = new ValidationController();
        fileutil = new FileUtil();
    }

    public void run(){

        Test test = (Test)Utils.showAndSelectOne(company.getTestsToValidate(),"test");

        Utils.showList(company.getValueRecords(test.getTestID()),"valueRecords");


        System.out.println("Do you validate the reports and the values of tests?(yes/no)");


        if(Utils.confirm()) {
            controller.validate(test);
            fileutil.createFile("./results/emailAndSMSMessages.txt");
            fileutil.writeFile("Your tests are now available in the app!");
        } else {
            System.out.println("Need to check the results and report before");
        }
    }
}
