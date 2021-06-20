package app.domain.model;

import java.io.Serializable;
import java.util.Set;

public class TestType implements Serializable {


    /**
     * The id of the test type.
     */
    private final String id;

    /**
     * The description of the test type.
     */
    private final String description;

    /**
     * The collection method of the test type.
     */
    private final String collection;

    /**
     * The set of categories of the test type.
     */
    private static Set<Category> categories;

    /**
     * Builds an instance of TestType receiving the id, description, collection method and set of categories.
     * @param id
     * @param description
     * @param collection
     * @param categories
     */
    public TestType(String id, String description, String collection, Set<Category> categories) {
        this.id = id;
        this.description = description;
        this.collection = collection;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCollection() {
        return collection;
    }

    public static Set<Category> getCategories() {
        return categories;
    }



    /**
     * Validates if attributes are valid.
     * @return
     */
    public boolean validate() {
        return id.toLowerCase().matches("^[0-9a-z]{5}$") && description.length() <= 15 &&
                collection.length() <= 20 && categories != null && !description.isEmpty() &&
                !collection.isEmpty() && !categories.isEmpty();
    }

    @Override
    public String toString() {
        return "TestType{" + " ID: " + id + " | Description: " + description + " }";

    }
}
