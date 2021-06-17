package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable{

    @Override
    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("View my test results:", new ViewTestResultsUI()));
        options.add(new MenuItem("Update my information:", new UpdateClientUI()));


        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");
            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}

