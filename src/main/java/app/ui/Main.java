package app.ui;

import app.ui.console.MainMenuUI;

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
        ArrayList<String> roles = new ArrayList<>(5);

        roles.add("recepcionist");
        roles.add("clincal chemestry technologist");
        roles.add("laboratory coordinator");
        roles.add("medical lab technician");
        roles.add("specialist doctor");
    }




}
