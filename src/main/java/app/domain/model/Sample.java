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
    public Sample( String code, String adapter){
        generateBarcode(code, adapter);
    }


    private void generateBarcode(String code ){
        BarcodeInterface imp = ReflectorUtility.adapterReflection(App.getInstance().getBarcodeAdapter());
        if (imp != null)
            barcode = imp.generateBarcode(code);
    }

    private void generateBarcode(String code, String adapter ){
        BarcodeInterface imp = ReflectorUtility.adapterReflection(adapter);
        if (imp != null)
            barcode = imp.generateBarcode(code);
    }


    public Barcode getBarcode() {
        return barcode;
    }

    public String toString(){
        return getBarcode().toString();
    }
}
