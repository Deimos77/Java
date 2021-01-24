package Commands;

import Stuff.CommandWithoutArg;
import Stuff.MovieCollection;
import Utility.SQLConnection;

import java.net.Socket;
import java.sql.SQLException;

/**
 * The type Info.
 */
public class Info implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "info";
    /**
     * The movie collection.
     */
    MovieCollection collection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.ConnectionToDB();
        sqlConnection.loadAllMovies();
        return (collection.getInfo());
    }

    @Override
    public String getName() {
        return name;
    }
}