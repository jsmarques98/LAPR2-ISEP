package app.ui.console;

import app.controller.App;
import app.controller.RecordTestResultsController;
import app.controller.RegisterLabController;
import app.controller.ValidationController;
import app.controller.utils.FileUtil;
import app.domain.model.Company;
import app.ui.console.utils.Utils;

import java.util.Scanner;

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
        int i;
        for(i = 0; i< company.reportedTestsList.size(); i++){
            System.out.println(company.reportedTestsList.get(i));
        }

        int j;
        for( j = 0; j< company.valueRecordsList.size(); j++){
            System.out.println(company.valueRecordsList.get(i));
        }


        System.out.println("Do you validate the reports and the values of tests?(yes/no)");


        if(Utils.confirm()) {
            controller.validate(company.reportedTestsList.get(i).getTest());
            fileutil.createFile("./results/emailAndSMSMessages.txt");
            fileutil.writeFile("Your tests are now available in the app!");
        } else {
            System.out.println("Need to check the results and report before");
        }
    }
}
