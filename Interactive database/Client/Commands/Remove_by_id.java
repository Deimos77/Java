package Commands;

import Stuff.Commandable;
import Stuff.Movie;
import Stuff.MovieCollection;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * The type Remove id.
 */
public class Remove_by_id implements Commandable {
    /**
     * The Name.
     */
    String name = "remove_by_id";
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
