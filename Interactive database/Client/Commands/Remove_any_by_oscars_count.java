package Commands;

import Stuff.Commandable;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Remove_any_by_oscars_count implements Commandable {
    String name = "remove_any_by_oscars_count";


    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException, FileNotFoundException {
        return null;

    }

    @Override
    public String getName() {
        return name;
    }
}
