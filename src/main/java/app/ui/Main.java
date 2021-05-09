package app.ui;

import app.domain.model.Employee;
import app.ui.console.MainMenuUI;
import app.ui.console.SpecifyTypeTestUI;

import java.util.ArrayList;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main {

    public static void main(String[] args)
    {
        try
        {
            MainMenuUI menu = new MainMenuUI();

            menu.run();

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        Employee.roles.add("recepcionist");
        Employee.roles.add("clincal chemestry technologist");
        Employee.roles.add("laboratory coordinator");
        Employee.roles.add("medical lab technician");
        Employee.roles.add("specialist doctor");
    }




}
