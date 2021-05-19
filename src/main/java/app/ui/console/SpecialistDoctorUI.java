package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecialistDoctorUI implements Runnable {


    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        //Para ja esta new employeeUI porque ainda nao criei o createReportUI
        options.add(new MenuItem("Write the diagnosis report of a test",new EmployeeUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSpecialist Doctor Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }

}

