package app.ui.console;

import app.Adapter.ImportTestsCSV;
import app.controller.OverviewTestsController;
import app.ui.console.utils.Utils;
import app.ui.gui.LineChartGraph;
import javafx.application.Application;

import java.io.FileNotFoundException;
import java.security.InvalidParameterException;

public class OverviewTestsUI implements Runnable{
    @Override
    public void run() {

        LineChartGraph.main(null);
        }
}
