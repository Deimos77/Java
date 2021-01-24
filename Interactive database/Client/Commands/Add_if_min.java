package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Stuff.Movie;


import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Add_if_min  implements Commandable {
    /**
     * The Name.
     */
    String name = "add_if_min";






    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
