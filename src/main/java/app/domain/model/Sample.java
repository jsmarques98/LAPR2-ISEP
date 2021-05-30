package app.domain.model;

import app.Adapter.BarcodeInterface;
import app.Adapter.ReflectorUtility;
import app.controller.App;
import net.sourceforge.barbecue.Barcode;

public class Sample {

    private Barcode barcode;
    private double HB000; // Haemoglobin (HB)
    private double WBC00; // White Cell Count (WBC)
    private double PLT00; // Platelet Count (PLT)
    private double RBC00; // Red Blood Count (RBC)
    private double MCV00; // Mean Cell Volume (MCV)
    private double MCH00; // Mean Cell Haemoglobin (MCH)
    private double MCHC0; // Mean Cell Haemoglobin Concentration (MCHC)
    private double ESR00; // Erythrocyte Sedimentation Rate (ESR)

    public Sample( String code ){
        generateBarcode(code);
    }

    public double getHB000() {
        return HB000;
    }

    public void setHB000(double HB000) {
        this.HB000 = HB000;
    }

    public double getWBC00() {
        return WBC00;
    }

    public void setWBC00(double WBC00) {
        this.WBC00 = WBC00;
    }

    public double getPLT00() {
        return PLT00;
    }

    public void setPLT00(double PLT00) {
        this.PLT00 = PLT00;
    }

    public double getRBC00() {
        return RBC00;
    }

    public void setRBC00(double RBC00) {
        this.RBC00 = RBC00;
    }

    public double getMCV00() {
        return MCV00;
    }

    public void setMCV00(double MCV00) {
        this.MCV00 = MCV00;
    }

    public double getMCH00() {
        return MCH00;
    }

    public void setMCH00(double MCH00) {
        this.MCH00 = MCH00;
    }

    public double getMCHC0() {
        return MCHC0;
    }

    public void setMCHC0(double MCHC0) {
        this.MCHC0 = MCHC0;
    }

    public double getESR00() {
        return ESR00;
    }

    public void setESR00(double ESR00) {
        this.ESR00 = ESR00;
    }

    private void generateBarcode(String code ){
        BarcodeInterface imp = ReflectorUtility.adapterReflection(App.getBarcodeAdapter());
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
