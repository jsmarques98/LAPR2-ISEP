package app.domain.model;

import java.util.Locale;
import java.util.Set;

public class TestType {

    private final String id;
    private final String description;
    private final String collection;
    private final Set<Category> categories;

    public TestType(String id, String description, String collection, Set<Category> categories) {
        this.id = id;
        this.description = description;
        this.collection = collection;
        this.categories = categories;
    }

    public boolean validate() {
        return id.toLowerCase().matches("^[0-9a-z]{5}$") && description.length()<=15 &&
                collection.length()<= 20 && categories != null && !description.isEmpty() &&
                !collection.isEmpty() && !categories.isEmpty();
    }
}
