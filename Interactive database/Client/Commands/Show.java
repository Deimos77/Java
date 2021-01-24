package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;

import java.net.Socket;
import java.sql.SQLException;
import java.util.Map;

/**
 * The type Show.
 */
public class Show implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "show";
    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        return null;
    }


    @Override
    public String getName() {
        return name;
    }
}