package Utility;
import Stuff.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * The type Writer to file.
 */
public class WriterToFile {
    /**
     * The Filename.
     */
    static String filename ;

    /**
     * Sets filename.
     *
     * @param filename the filename
     */
    public static void setFilename(String filename) {
        WriterToFile.filename = filename;
    }

}