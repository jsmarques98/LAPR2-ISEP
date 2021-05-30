package app.ui.console;

import app.controller.App;
import app.controller.RecordTestResultsController;
import app.controller.RegisterLabController;
import app.controller.ValidationController;
import app.controller.utils.FileUtil;
import app.domain.model.Company;

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
        for(int i = 0; i< Company.reportedTestsList.size(); i++){
            System.out.println(Company.reportedTestsList.get(i));
        }
        for(int i = 0; i< Company.valueRecordsList.size(); i++){
            System.out.println(Company.valueRecordsList.get(i));
        }

        System.out.println("Do you validate the reports and the values of tests?(yes/no)");
        Scanner scanner = new Scanner(System.in);

        if(scanner.nextBoolean()==true) {
            fileutil.createFile("./results/emailAndSMSMessages.txt");
            fileutil.writeFile("Your tests are now available in the app!");
        } else {
            System.out.println("Need to check the results and report before");
        }



    }

}
