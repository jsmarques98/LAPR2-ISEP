package app.ui.console;

import app.controller.RegisterLabController;
import app.ui.console.utils.Utils;

public class RegisterLabUI implements Runnable{

    private RegisterLabController controller;

    public RegisterLabUI(){
        controller = new RegisterLabController();
    }


    @Override
    public void run() {

        String labId = selectLab();
        String name = selectName();
        String address = selectAddr();
        int phoneNr = selectPhoneNr();
        int TINnr = selectTINnr();

        if(controller.registerLab(labId, name, address, phoneNr, TINnr)){
            System.out.println("Lab criado com sucesso");
            controller.saveLab();
        }else{
            System.out.println("Lab não criado");
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
    public int selectPhoneNr(){
        return Utils.readIntegerFromConsole("Phone: ");
    }
    public int selectTINnr(){
        return Utils.readIntegerFromConsole("TINnr: ");
    }
}
