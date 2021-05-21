package app.domain.model;

import app.Adapter.BarcodeInterface;
import app.Adapter.ReflectorUtility;
import net.sourceforge.barbecue.Barcode;

public class Sample {

    private Barcode barcode;

    public Sample(){
    }

    public void generateBarcode( String code ){
        BarcodeInterface imp = ReflectorUtility.adapterReflection("app.Adapter.BarcodeAdapter");
        barcode = imp.generateBarcode(code);
    }


    public Barcode getBarcode() {
        return barcode;
    }
}
