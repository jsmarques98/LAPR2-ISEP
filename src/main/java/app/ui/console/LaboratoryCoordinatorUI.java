package app.ui.console;

import app.ui.console.utils.Utils;
import app.ui.gui.LineChartGraph;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryCoordinatorUI implements Runnable {


    @Override
    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Validate work done by the clinical chemistry, " +
                "technologist and specialist doctor", new ValidationUI()));
        options.add(new MenuItem("Import file with tests", new ImportTestsUI()));
        options.add(new MenuItem("See overview of tests", new OverviewTestsUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nLaboratory Coordinator Menu:");
            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}
