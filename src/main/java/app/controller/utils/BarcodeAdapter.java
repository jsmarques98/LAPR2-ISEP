package app.controller.utils;

import app.Adapter.BarcodeInterface;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class BarcodeAdapter implements BarcodeInterface {
    private static final Logger LOGGER = Logger.getLogger(BarcodeAdapter.class.getName());

    @Override
    public Barcode generateBarcode(String filename) {
        Barcode barcode = null;
        try {
            barcode = BarcodeFactory.createUPCA(filename);
            File file = new File("barcodes/" + filename + ".png");
            barcode.setPreferredBarHeight(100);
            BarcodeImageHandler.savePNG(barcode,file);

        } catch (OutputException | BarcodeException | IOException e) {
            LOGGER.info(e.getMessage());
        }
        return barcode;
    }
}
