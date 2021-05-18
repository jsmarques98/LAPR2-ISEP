package app.ui;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.Constants;
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
