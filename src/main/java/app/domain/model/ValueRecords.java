package app.domain.model;

import java.io.Serializable;
import java.util.Date;

public class ValueRecords implements Serializable {

    //test id
    private String id;
    private double minValue;
    private double maxValue;
    private double registeredValue;
    private String parametro;
    private Date date;

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
    public ValueRecords(String id, double minValue, double maxValue, double registeredValue, String parametro, Date data) {
        this.id = id;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.registeredValue = registeredValue;
        this.parametro = parametro;
        this.date = data;
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

    public String getParametro() {
        return parametro;
    }

    public Date getData() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "ValueRecords{" +
                "id='" + id + '\'' +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", registeredValue=" + registeredValue +
                ", parametro='" + parametro + '\'' +
                ", data=" + date +
                '}';
    }
}

