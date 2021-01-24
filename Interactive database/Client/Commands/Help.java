package Commands;

import Stuff.CommandWithoutArg;
import Stuff.MovieCollection;

import java.net.Socket;

/**
 * The type Help.
 */
public class Help implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "help";
    /**
     * The Movie collection.
     */
    MovieCollection movieCollection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}