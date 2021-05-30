package app.domain.model;

public class ValueRecords {

    private String id;
    private double minValue;
    private double maxValue;
    private double registeredValue;

    public ValueRecords() {
    }

    public ValueRecords(String id, double minValue, double maxValue, double registeredValue) {
        this.id = id;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.registeredValue = registeredValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getRegisteredValue() {
        return registeredValue;
    }

    public void setRegisteredValue(double registeredValue) {
        this.registeredValue = registeredValue;
    }

    @Override
    public String toString() {
        return "ValueRecords{" +
                "minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", registeredValue=" + registeredValue +
                '}';
    }
}
