package Commands;

import Stuff.Commandable;
import Stuff.Commands;
import Stuff.MovieCollection;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Execute script.
 */
public class ExecuteScript implements Commandable {
    /**
     * The Name.
     */
    String name = "execute_script";
    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();
    static ArrayList<String> exScrHistory = new ArrayList<>();
    /**
     * The Reader.
     */

    /**
     * The Invoker.
     */


    /**
     * @param o название файла
     * @return
     */

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws FileNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}