/*
package app.domain.model;

import app.Adapter.BarcodeInterface;
import app.Adapter.ReflectorUtility;
import app.controller.App;
import net.sourceforge.barbecue.Barcode;

public class Sample {

    private Barcode barcode;

    public Sample( String code ){
        generateBarcode(code);
    }

    private void generateBarcode( String code ){
        BarcodeInterface imp = ReflectorUtility.adapterReflection(App.getInstance().getBarcodeAdapter());
        barcode = imp.generateBarcode(code);
    }


    public Barcode getBarcode() {
        return barcode;
    }
}
*/
