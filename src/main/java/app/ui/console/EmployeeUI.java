package app.ui.console;

import app.controller.AuthController;
import app.controller.RegisterEmployeeController;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

public class EmployeeUI implements Runnable{

    private RegisterEmployeeController controller;

    public EmployeeUI(){
        controller = new RegisterEmployeeController();
    }

    @Override
    public void run() {

        String roleId = selectRoleId();
        String name = selectName();
        String address = selectAddress();
        String phoneNumber = selectPhoneNumber();
        String email = selectEmail();
        String socCode = selectSocCode();

        if(roleId.equals("specialist doctor")){
            String indxNumber =  selectIndxNumber();
            if(controller.createSpecialistDoctor(roleId, name, address, phoneNumber, email, socCode, indxNumber)){
                System.out.println("Specialist Doctor criado com sucesso com o index: " + indxNumber);
                controller.saveEmployee();
            }else{
                System.out.println("Empregado não criado");
            }
        }else{
            if(controller.createEmloyee(roleId, name, address, phoneNumber, email, socCode)){
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

    public String selectRoleId(){
        System.out.println("Select one of the following roles:");
        for(int i=0;i<Employee.roles.size();i++){
            System.out.println(Employee.roles.get(i));
        }
        String role = Utils.readLineFromConsole("Enter Employee's role: ");
        if(!Employee.roles.contains(role)){
            System.out.println("Role not found."+"\n");
            return selectRoleId();
        }
        return role;
    }

    public String selectName(){
        String name = Utils.readLineFromConsole("Enter Employee's name: ");
        if (name.length() > 36 || name.length() == 0){
            System.out.println("Name must have less than 36 chars and can't null.");
            return selectName();
        }
        return name;
    }
    public String selectAddress(){
        String addr = Utils.readLineFromConsole("Enter Employee's address: ");
        if (addr.length() > 31 || addr.length() == 0){
            System.out.println("Address must have less than 31 chars and can't null.");
            return selectAddress();
        }
        return addr;
    }
    public String selectPhoneNumber(){
        String phoneNumber = Utils.readLineFromConsole("Enter Employee's phone number: ");
        if (!(phoneNumber.length() == 11)){
            System.out.println("Phone Number must have 11 chars.");
            return selectPhoneNumber();
        }
        return phoneNumber;
    }
    public String selectEmail(){
        String mail = Utils.readLineFromConsole("Enter Employee's email: ");
        if(!Email.checkFormat(mail)){
            System.out.println("Invalid Email.");
            return selectEmail();
        }
        return mail;
    }
    public String selectSocCode(){
        String socCode = Utils.readLineFromConsole("Enter Employee's socCode: ");
        if (socCode.length() > 5 || socCode.length() == 0){
            System.out.println("SocCode must have less than 5 chars and can't null.");
            return selectSocCode();
        }
        return socCode;
    }
    public String selectIndxNumber(){
        String indexNumb =  Utils.readLineFromConsole("Enter Employee's IndxNumber: ");
        if (indexNumb.length() > 7 || indexNumb.length() == 0){
            System.out.println("SocCode must have less than 7 chars and can't null.");
            return selectIndxNumber();
        }
        return indexNumb;
    }

}
