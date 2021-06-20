package app.ui.console;

import app.controller.utils.ImportTestsCSV;
import app.ui.console.utils.Utils;

import java.io.FileNotFoundException;
import java.security.InvalidParameterException;

public class ImportTestsUI implements Runnable{
    @Override
    public void run() {

        //RecordSamplesController recordSamplesController = new RecordSamplesController();

        String file = Utils.readLineFromConsole("Insert pathfile to import");

        try {
            new ImportTestsCSV(file);
        } catch (InvalidParameterException | FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
}
