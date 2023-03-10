package app.ui.console;

import app.controller.App;
import app.controller.RegisterEmployeeController;
import app.controller.Company;
import app.domain.model.Employee;
import app.domain.model.Lab;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

public class EmployeeUI implements Runnable{

    private RegisterEmployeeController controller;
    private Company company;

    public EmployeeUI(){
        controller = new RegisterEmployeeController();
        company = App.getInstance().getCompany();
    }

    @Override
    public void run() {

        String roleId = selectRoleId();
        String name = selectName();
        String address = selectAddress();
        String phoneNumber = selectPhoneNumber();
        String email = selectEmail();
        String socCode = selectSocCode();
        Lab lab = selectLab();

        if (roleId.equalsIgnoreCase("SPECIALIST_DOCTOR")) {
            String indxNumber = selectIndxNumber();
            if(Utils.confirm()){
                if (controller.createSpecialistDoctor(roleId, name, address, phoneNumber, email, socCode, lab, indxNumber)) {
                    System.out.println("Specialist Doctor successfully created with index: " + indxNumber);
                    controller.saveEmployee();
                } else {
                    System.out.println("Employee not created");
                }
            }else{
                System.out.println("Operation canceld");
            }
        } else {
            if(Utils.confirm()){
                if (controller.createEmloyee(roleId, name, address, phoneNumber, email, socCode, lab)) {
                    System.out.println("Employee successfully created");
                    controller.saveEmployee();
                } else {
                    System.out.println("Employee not created");
                }
            }else{
                System.out.println("Operation canceld");
            }
        }
        for (int i = 0; i < company.employeeList.size(); i++) {
            System.out.println(company.employeeList.get(i));
        }
    }


    public String selectRoleId(){
        System.out.println("Select one of the following roles:");
        for(int i=0;i<Employee.roles.size();i++){
            System.out.println(Employee.roles.get(i));
        }
        String role = Utils.readLineFromConsole("Enter Employee's role: ");
        if(!Employee.roles.contains(role)){
            System.out.println("Role not found.\n");
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

    private Lab selectLab() {
        for (int i = 0; i < company.labList.size(); i++) {
            System.out.println(company.labList.get(i));
        }
        String labId =  Utils.readLineFromConsole("Enter Employee's labId: ");
        for (Lab l : company.labList) {
            if(l.getLabId().equals(labId)){
                return l;
            }
        }
        System.out.println("labId not found\n");
        return selectLab();
    }


}
