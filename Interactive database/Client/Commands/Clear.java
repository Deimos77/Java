package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;


import java.net.Socket;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * The type Clear.
 */
public class Clear implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "clear";
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
