package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable{

    @Override
    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do the registration of a Client",new RegisterClientUI()));
//        options.add(new MenuItem("Registration of a test on a client"));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionis Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
