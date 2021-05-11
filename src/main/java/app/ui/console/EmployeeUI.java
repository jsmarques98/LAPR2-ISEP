package app.ui.console;

import app.controller.AuthController;
import app.controller.RegisterEmployeeController;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.ui.console.utils.Utils;

public class EmployeeUI implements Runnable{

    private RegisterEmployeeController controller;

    public EmployeeUI(){
        controller = new RegisterEmployeeController();
    }

    @Override
    public void run() {

        String role = selectRole();
        String name = selectName();
        String address = selectAddress();
        String phoneNumber = selectPhoneNumber();
        String email = selectEmail();
        String socCode = selectSocCode();

        if(role.equals("specialist doctor")){
            String indxNumber =  selectIndxNumber();
            if(controller.createSpecialistDoctor(role, name, address, phoneNumber, email, socCode, indxNumber)){
                System.out.println("Specialist Doctor criado com sucesso com o index: " + indxNumber);
                controller.saveEmployee();
            }else{
                System.out.println("Empregado não criado");
            }
        }else{
            if(controller.createEmloyee(role, name, address, phoneNumber, email, socCode)){
                System.out.println("Empregado criado com sucesso");
                controller.saveEmployee();
            }else{
                System.out.println("Empregado não criado");
            }
        }


        for(int i=0;i<Company.employeeList.size();i++){
            System.out.println(Company.employeeList.get(i));
        }
    }

    public String selectRole(){
        return Utils.readLineFromConsole("Enter Employee's role: ");
    }
    public String selectName(){
        return Utils.readLineFromConsole("Enter Employee's name: ");
    }
    public String selectAddress(){
        return Utils.readLineFromConsole("Enter Employee's address: ");

    }public String selectPhoneNumber(){
        return Utils.readLineFromConsole("Enter Employee's phone number: ");
    }
    public String selectEmail(){
        return Utils.readLineFromConsole("Enter Employee's email: ");
    }
    public String selectSocCode(){
        return Utils.readLineFromConsole("Enter Employee's socCode: ");
    }
    public String selectIndxNumber(){
        return Utils.readLineFromConsole("Enter Employee's IndxNumber: ");
    }

}
