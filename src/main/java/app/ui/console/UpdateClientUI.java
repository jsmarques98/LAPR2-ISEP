package app.ui.console;

import app.controller.App;
import app.domain.model.Client;
import app.domain.model.Company;
import auth.domain.model.Email;

import static app.ui.console.utils.Utils.*;

public class UpdateClientUI implements Runnable {

    @Override
    public void run(){
        Email email = App.getInstance().getCurrentUserSession().getUserId();
        Client currentClient = null;
        for (Client c : Company.clientsList) {
           if(email.getEmail().equals(c.getEmail())){
               currentClient = c;
           }
        }
        System.out.println("Client Menu:\n");
        System.out.println("Client info:\n" + currentClient.toString());
        selectParameter(currentClient);
        System.out.println("Client info:\n" + currentClient.toString());
    }

    public void selectParameter(Client c){
        System.out.println("What do you want to change ?\n1- Name\n2- Address\n3- Phone Number\n4- Gender");
        int op = readIntegerFromConsole("Select the option number:");
        switch(op) {
            case 1:
                String name = readLineFromConsole("Insert the new name: ");
                if(confirm()){
                    c.setName(name);
                    System.out.println("Info updated");
                }
                break;
            case 2:
                String address = readLineFromConsole("Insert the new address: ");
                if(confirm()) {
                    c.setAddress(address);
                    System.out.println("Info updated");
                }
                break;
            case 3:
                String phoneNumber = readLineFromConsole("Insert the new Phone Number: ");
                if(confirm()) {
                    c.setPhoneNumber(phoneNumber);
                    System.out.println("Info updated");
                }
                break;
            case 4:
                String gender = RegisterClientUI.AskGender();
                if(confirm()) {
                    c.setGender(gender);
<<<<<<< HEAD
                    System.out.println("Info updated");
=======
<<<<<<< HEAD
                    System.out.println("Info updated");
=======
                    System.out.println("Falta fazer o sexo");
>>>>>>> 269958ed990bc98d72826704946620c2300fbf93
>>>>>>> d309098d02fe892c2444bdf0ea9db181ad317e4d
                }
                break;
            default:
                System.out.println("Option not found\n");
                selectParameter(c);
        }


    }

}
