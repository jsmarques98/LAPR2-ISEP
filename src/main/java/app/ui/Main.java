package app.ui;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.ui.console.MainMenuUI;
import app.ui.console.SpecifyTypeTestUI;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main {

    public static void main(String[] args)
    {
        Employee.roles.add("recepcionist");
        Employee.roles.add("clincal chemestry technologist");
        Employee.roles.add("laboratory coordinator");
        Employee.roles.add("medical lab technician");
        Employee.roles.add("specialist doctor");
        Employee.roles.add("administrator");

        Employee e1 = new Employee("1","administrator", "Joao Oliveira", "address", "99999999999", "email", "1254");
        Employee e2 = new Employee("recepcionist", "Manel Jorge", "address", "99999999999", "email", "1254");
//        Employee e3 = new Employee("specialist doctor", "palhaço", "address", "99999999999", "email", "1254");



        Company.employeeList.add(e1);
        Company.employeeList.add(e2);
//        Company.employeeList.add(e3);

        for(int i=0;i<Company.employeeList.size();i++){
            System.out.println(Company.employeeList.get(i));
        }


//        try
//        {
//            MainMenuUI menu = new MainMenuUI();
//
//            menu.run();
//
//        }
//        catch( Exception e )
//        {
//            e.printStackTrace();
//        }


    }




}
