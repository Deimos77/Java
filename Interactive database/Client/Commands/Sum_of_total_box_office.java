package Commands;

import Stuff.CommandWithoutArg;
import Stuff.MovieCollection;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;

public class Sum_of_total_box_office implements CommandWithoutArg {
    String name = "sum_of_total_box_office";

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException, FileNotFoundException {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
