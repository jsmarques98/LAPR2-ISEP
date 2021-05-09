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

        // Criar o 1º empregado com o role de Administrator
        Employee employeeAdmin = new Employee("JO1","administrator", "Joao Silva Oliveira", "address", "99999999999", "email@gmail.com", "1254","qwertyuiop");
        Company.employeeList.add(employeeAdmin);

        try
        {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

}
