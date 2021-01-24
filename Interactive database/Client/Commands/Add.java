package Commands;

import Stuff.CommandWithoutArg;


import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.InputMismatchException;

/**
 * The type Add.
 */
public class Add implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "add";






    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
       return null;

    }

    @Override
    public String getName() {
        return name;
    }
}
