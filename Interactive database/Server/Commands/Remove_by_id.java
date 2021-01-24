package Commands;

import Stuff.Commandable;
import Stuff.Movie;
import Stuff.MovieCollection;
import Utility.SQLConnection;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * The type Remove id.
 */
public class Remove_by_id implements Commandable {
    /**
     * The Name.
     */
    String name = "remove_by_id";
    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws FileNotFoundException, SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.ConnectionToDB();
        sqlConnection.loadAllMovies();
        int id = 0;

        try {
            id = Integer.parseInt((String) o);
        } catch (NumberFormatException e) {
            return "Введён неверный параметр команды.";
        }

        String result = "Элемент с таким id не существует";
        Iterator<Movie> iterator = new MovieCollection().getCollection().iterator();

        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            long movieId = movie.getId();
            if (movieId == id) {
                iterator.remove();
                result = "Удалён элемент с id " + movieId;
            }
        }
        sqlConnection.uploadAllMovies();
        return result;
    }

    @Override
    public String getName() {
        return name;
    }
}
