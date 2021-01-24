package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Print_field_descending_person_height implements CommandWithoutArg {
    String name = "print_field_descending_person_height";


    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException, FileNotFoundException {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
