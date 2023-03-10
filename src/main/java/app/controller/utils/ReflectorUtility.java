package app.controller.utils;

import app.Adapter.AlgorithmInterface;
import app.Adapter.BarcodeInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

/**
 * Class responsible for constructing adapters using reflection
 */
public class ReflectorUtility {

    private static final Logger LOGGER = Logger.getLogger(ReflectorUtility.class.getName());

    private ReflectorUtility() {
        throw new IllegalStateException("Utility class");
    }

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
            LOGGER.warning("Current class not found: " + e.getMessage());
            return null;
        }
    }

    public static AlgorithmInterface AlgorithmReflection(String adapterClass) {
        try {
            Class<?> oClass = Class.forName(adapterClass);
            return ( (AlgorithmInterface) oClass.getDeclaredConstructor().newInstance());

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.warning("Current class not found: " + e.getMessage());
            return null;
        }
    }
}
