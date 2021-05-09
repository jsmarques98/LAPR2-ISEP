package app.ui.console;

import app.controller.AuthController;
import app.controller.RegisterEmployeeController;
import app.domain.model.Company;
import app.domain.model.Employee;

public class EmployeeUI implements Runnable{

    private RegisterEmployeeController controller;

    public EmployeeUI(){
        controller = new RegisterEmployeeController();
    }

    @Override
    public void run() {
        Employee.roles.add("recepcionist");
        Employee.roles.add("clincal chemestry technologist");
        Employee.roles.add("laboratory coordinator");
        Employee.roles.add("medical lab technician");
        Employee.roles.add("specialist doctor");
        Employee.roles.add("administrator");

        Employee employeeAdmin = new Employee("JO1","administrator", "Joao Silva Oliveira", "address", "99999999999", "email@gmail.com", "1254","qwertyuiop");
        Company.employeeList.add(employeeAdmin);

        if(controller.createEmloyee("clincal chemestry technologist", "Manel Jorge", "address", "99999999999", "email", "1254"))
            controller.saveEmployee();



//        Employee e2 = new Employee("clincal chemestry technologist", "Manel Jorge", "address", "99999999999", "email", "1254");
//        Employee e3 = new Employee("specialist doctor", "Palhaço Luis", "address", "99999999999", "email", "1254");
//        Company.employeeList.add(e2);
//        Company.employeeList.add(e3);

        for(int i=0;i<Company.employeeList.size();i++){
            System.out.println(Company.employeeList.get(i));
        }



    }

}
