package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Stuff.Movie;
import Stuff.MovieCollection;
import Utility.SQLConnection;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * The type Remove lower.
 */
public class Remove_lower implements Commandable {
    /**
     * The Name.
     */
    String name = "remove_lower";
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
        boolean isEmpty = true;
        int id;
        try {
            id = Integer.parseInt((String) o);
        } catch (NumberFormatException e) {
            return ("Введён неверный параметр команды, попробуйте ещё раз.");
        }

        Iterator<Movie> iterator = new MovieCollection().getCollection().iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            long movieId = movie.getId();
            if (movieId < id) {
                isEmpty = false;
                iterator.remove();
                result += "Удалён элемент с id " + movieId + "\n";
            }
        }sqlConnection.uploadAllMovies();
        if (isEmpty) return "В коллекции нет элементов с id меньше заданного значения."; else return  result;
    }


    @Override
    public String getName() {
        return name;
    }
}