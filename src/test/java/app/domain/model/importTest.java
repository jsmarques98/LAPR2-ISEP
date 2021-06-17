package app.domain.model;

import app.Adapter.ImportTestsCSV;
import app.controller.App;
import app.ui.console.utils.Utils;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class importTest {

    @Test
    void start() {
        //ImportTestsCSV csv = new ImportTestsCSV("csv/tests_Blood100.csv");
        Company company = App.getInstance().getCompany();
        try {
            ImportTestsCSV csv = new ImportTestsCSV("csv/tests_BloodMDISCCSV.csv");
        } catch (InvalidParameterException e){
            System.out.println(e.toString());
        }
       App.getInstance().save(company);


    }

}
