package app.ui.console;

import app.controller.RecordSamplesController;
import app.domain.model.Test;
import app.dto.TestDTO;
import app.ui.console.utils.Utils;

public class RecordSamplesUI implements Runnable{
    @Override
    public void run() {

        RecordSamplesController recordSamplesController = new RecordSamplesController();

        int index = Utils.showAndSelectIndex(recordSamplesController.getAvailableTests(),
                "Select which test to record Samples");

        TestDTO testDTO = recordSamplesController.getAvailableTests().get(index);

        System.out.println("Selected: " + testDTO.toString());

        int numSamples = Utils.readIntegerFromConsole("How many samples do you want to record? 0 to quit");
        if (numSamples <= 0)
            System.out.println("Number of samples cannot be 0 or less!");

        recordSamplesController.generateSamples(index, numSamples);

        //retrieve updated test with new samples
        testDTO = recordSamplesController.getAvailableTests().get(index-1);
        Utils.showList(testDTO.getSamples(), "Barcodes");

    }
}
