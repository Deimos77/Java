package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;
import Utility.SQLConnection;

import java.net.Socket;
import java.sql.SQLException;
import java.util.Map;

/**
 * The type Show.
 */
public class Show implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "show";
    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.ConnectionToDB();
        sqlConnection.loadAllMovies();
        String result = "";
        for (Movie movie : collection.getCollection()) {
            result += movie.getStrBeautyMovie() + "\n";
        }
        if (!result.equals("")) return result; else return "Коллекция пустая.";
            }


    @Override
    public String getName() {
        return name;
    }
}