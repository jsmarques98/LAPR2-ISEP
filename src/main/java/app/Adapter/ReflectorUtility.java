package app.Adapter;

import java.lang.reflect.InvocationTargetException;

/**
 * Class responsible for constructing adapters using reflection
 */
public class ReflectorUtility {

    /**
     * Method that builds a Barcode Adapter
     * @param adapterClass The package and name of the class that will be built using reflection
     * @return The barcode interface implemented
     */
    public static BarcodeInterface adapterReflection(String adapterClass) {
        try {
            Class<?> oClass = Class.forName(adapterClass);
            return ( (BarcodeInterface) oClass.getDeclaredConstructor().newInstance());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
