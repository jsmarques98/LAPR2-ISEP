package app.Adapter;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;

public class BarcodeAdapter implements BarcodeInterface {
    @Override
    public Barcode generateBarcode(String filename) {
        Barcode barcode = null;
        try {
            barcode = BarcodeFactory.create2of7(filename);
            File file = new File("barcodes/" + filename + ".png");
            BarcodeImageHandler.savePNG(barcode,file);

        } catch (OutputException | BarcodeException e) {
            e.printStackTrace();
        }
        return barcode;
    }
}
