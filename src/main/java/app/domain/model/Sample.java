package app.domain.model;

import app.Adapter.BarcodeInterface;
import app.Adapter.ReflectorUtility;
import app.controller.App;
import net.sourceforge.barbecue.Barcode;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class Sample implements Serializable {

    private Barcode barcode;

    public Sample( String code ){
        generateBarcode(code);
    }
    public Sample( String code, String adapter){
        generateBarcode(code, adapter);
    }


    private void generateBarcode(String code ){
        BarcodeInterface imp = null;
        try {
            imp = ReflectorUtility.adapterReflection(App.getInstance().getBarcodeAdapter());
       }
       catch(NullPointerException e){};
        if (imp != null)
            barcode = imp.generateBarcode(code);
    }

    private void generateBarcode(String code, String adapter ){
        BarcodeInterface imp = null;
        try {
            imp = ReflectorUtility.adapterReflection(App.getInstance().getBarcodeAdapter());
        }
        catch(NullPointerException e){};
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
