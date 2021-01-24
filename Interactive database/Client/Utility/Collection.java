package Utility;

import Stuff.*;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.LinkedHashSet;

/**
 * The type Collection.
 */
public class Collection {
    /**
     * The Collection.
     */
    LinkedHashSet<Movie> collection;

    /**
     * Instantiates a new Collection.
     */
    public Collection() {
        collection = new LinkedHashSet<Movie>();
        MovieCollection.setCollection(collection);
        MovieCollection.setDateCreation(LocalDate.now());
        System.out.println("Коллекция создана. ");
    }


}