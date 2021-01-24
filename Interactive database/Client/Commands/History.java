package Commands;

import Stuff.CommandWithoutArg;
import Stuff.*;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type History.
 */
public class History implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "history";



    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException, FileNotFoundException {
        return null;
        }

    @Override
    public String getName() {
        return name;
    }
}