package Commands;

import Stuff.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The type Update id.
 */
public class Update_by_id implements Commandable {
    /**
     * The Name.
     */
    String name = "update_by_id";
    /**
     * The Create movie.
     */

    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();





    @Override
    public String execute(Object o, Socket clientSocket, String user) throws FileNotFoundException, SQLException {
        return null;

    }

    @Override
    public String getName() {
        return name;
    }
}
