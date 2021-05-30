package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClinicalChemestryTechnologistUI implements Runnable {

    @Override
    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Record the results of a given test" , new RecordTestResultsUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClinical Chemestry Technologist Menu:");
            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
