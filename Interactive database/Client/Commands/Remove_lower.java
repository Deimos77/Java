package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Stuff.Movie;
import Stuff.MovieCollection;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * The type Remove lower.
 */
public class Remove_lower implements Commandable {
    /**
     * The Name.
     */
    String name = "remove_lower";
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