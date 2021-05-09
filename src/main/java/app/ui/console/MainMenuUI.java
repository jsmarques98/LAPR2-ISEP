package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    public MainMenuUI()
    {
    }

    public void run() throws IOException
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do the registration",new RegisterClientUI()));
        options.add(new MenuItem("Do the registration of an Employee",new EmployeeUI()));
        options.add(new MenuItem("Do Login", new AuthUI()));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        options.add(new MenuItem("Specify a new test type", new SpecifyTypeTestUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}
