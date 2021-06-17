package app.domain.model;

import java.io.Serializable;

public class ValueRecords implements Serializable {

    /**
     * The id of value records.
     */
    private String id;

    /**
     * The min. value of value records.
     */
    private double minValue;

    /**
     * The max. value of value records.
     */
    private double maxValue;

    /**
     * The registered value of value records.
     */
    private double registeredValue;

    /**
     * The parameter of value records.
     */
    private String parametro;

    /**
     * The empty constructor of value records.
     */
    public ValueRecords() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The constructor of value records.
     *
     * @param id
     * @param minValue
     * @param maxValue
     * @param registeredValue
     * @param parametro
     */
    public ValueRecords(String id, double minValue, double maxValue, double registeredValue, String parametro) {
        this.id = id;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.registeredValue = registeredValue;
        this.parametro = parametro;
    }

    public void setParameter(String parametro) {
        this.parametro = parametro;
    }

    /**
     * Gets the min. value of a value record.
     *
     * @return
     */
    public double getMinValue() {
        return minValue;
    }

    /**
     * Sets the min. value of a value record.
     *
     * @param minValue
     */
    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    /**
     * Gets the max value of a value record.
     *
     * @return
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the max value of a value record.
     *
     * @param maxValue
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Gets the registered value of a value record.
     *
     * @return
     */
    public double getRegisteredValue() {
        return registeredValue;
    }

    /**
     * Sets the registered value of value record.
     *
     * @param registeredValue
     */
    public void setRegisteredValue(double registeredValue) {
        this.registeredValue = registeredValue;
    }

    /**
     * Gets the id of a value record.
     *
     * @return
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Value Records{ Min. Value: " + minValue + " | Max. Value: " + maxValue + " | Registered Value: " + registeredValue
                + " | ID: " + id + " | Parameter: " + parametro + " }";

    }
}

