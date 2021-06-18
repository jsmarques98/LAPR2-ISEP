package app.domain.model;

import app.Adapter.BarcodeInterface;
import app.Adapter.ReflectorUtility;
import app.controller.App;
import net.sourceforge.barbecue.Barcode;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class Sample implements Serializable {

    private Barcode barcode;

    private static String lastCode = "000000000";

    public Sample(){
        Long code = Long.parseLong(lastCode)+1;

        String codeString = code.toString();
        int length = codeString.length();
        for(int i = 0; i < (11-length); i++)
            codeString = "0" + codeString;

        System.out.println(codeString);
        lastCode = codeString;

        generateBarcode(codeString);
    }

    public Sample( String code, String adapter){
        generateBarcode(code, adapter);
    }

    public Sample(String adapter){
        Long code = Long.parseLong(lastCode)+1;

        String codeString = code.toString();
        int length = codeString.length();
        for(int i = 0; i < (11-length); i++)
            codeString = "0" + codeString;

        System.out.println(codeString);
        lastCode = codeString;

        generateBarcode(codeString, adapter);
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
            imp = ReflectorUtility.adapterReflection(adapter);
        }
        catch(NullPointerException e){};
        if (imp != null)
            barcode = imp.generateBarcode(code);
    }


    public Barcode getBarcode() {
        return barcode;
    }

    public String toString(){
        return barcode.toString();
    }

}
