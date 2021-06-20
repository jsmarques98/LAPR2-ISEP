package app.ui.console;

import app.controller.App;
import app.controller.RegisterLabController;
import app.controller.Company;
import app.ui.console.utils.Utils;

public class RegisterLabUI implements Runnable{

    private RegisterLabController controller;
    private Company company;

    public RegisterLabUI(){
        controller = new RegisterLabController();
        company = App.getInstance().getCompany();
    }


    @Override
    public void run() {

        String labId = selectLab();
        String name = selectName();
        String address = selectAddr();
        String phoneNr = selectPhoneNr();
        String tin = selectTin();

        if(controller.registerLab(labId, name, address, phoneNr, tin)){
            System.out.println("Lab registered with success");
            controller.saveLab();
        }else{
            System.out.println("Lab not registered");
        }

        for(int i = 0; i< company.labList.size(); i++){
            System.out.println(company.labList.get(i));
        }
    }



    public String selectLab(){
        return Utils.readLineFromConsole("LabId: ");
    }
    public String selectName(){
        return Utils.readLineFromConsole("Name: ");
    }
    public String selectAddr(){
        return Utils.readLineFromConsole("Address: ");
    }
    public String selectPhoneNr(){
        return Utils.readLineFromConsole("Phone: ");
    }
    public String selectTin(){
        return Utils.readLineFromConsole("TIN: ");
    }
}
