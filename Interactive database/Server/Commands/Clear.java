package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;
import Utility.SQLConnection;

import java.net.Socket;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * The type Clear.
 */
public class Clear implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "clear";
    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.ConnectionToDB();
        sqlConnection.loadAllMovies();

        if (collection.getSize() == 0) return ("Коллекция итак пустая.");
        else {

                collection.clear();
                sqlConnection.uploadAllMovies();
                return "Ваши фильмы удалены.";
            }
        }


    @Override
    public String getName() {
        return name;
    }
}
