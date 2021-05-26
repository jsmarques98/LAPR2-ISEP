package app.ui.console;

import app.controller.RegisterTestToClientController;
import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.ui.console.utils.Utils;

public class RegisterTestToClientUI implements Runnable{

    private RegisterTestToClientController controller;

    public RegisterTestToClientUI(){
        controller = new RegisterTestToClientController();
    }

    @Override
    public void run() {

        String ccNum = selectCCNumber();
        System.out.println(ccNum);
//        controller.createTest(ccNum, nhscode, description, idTestType ,codeCategory, designation);

    }

    private String selectCCNumber() {
        String ccNum = Utils.readLineFromConsole("Enter CC Number: ");
        for(Client client : Company.clientsList) {
            if (client.getCCNumber().equals(ccNum)){
                return client.getCCNumber();
            }
        }
        return null;
    }
}
