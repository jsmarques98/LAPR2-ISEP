package app.controller;

import org.junit.jupiter.api.Test;

public class RecordTestResultsControllerTest {
    @Test
    public void testResults (){
        RecordSamplesController recordSamplesController = new RecordSamplesController();
        recordSamplesController.generateSamples(0,3);
        recordSamplesController.generateSamples(0,2);
        System.out.println(App.getInstance().getCompany().getTests().get(0));
        System.out.println(App.getInstance().getCompany().getTests().get(1));
    }
}
