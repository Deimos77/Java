package Commands;

import Stuff.*;

import Utility.SQLConnection;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The type Update id.
 */
public class Update_by_id implements Commandable {
    /**
     * The Name.
     */
    String name = "update_by_id";
    /**
     * The Create movie.
     */

    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();





    @Override
    public String execute(Object o, Socket clientSocket, String user) throws FileNotFoundException, SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.ConnectionToDB();
        sqlConnection.loadAllMovies();
        if (o != null) {
            int id = 0;
            try {
                id = Integer.parseInt((String) o);
            } catch (NumberFormatException e) {
                return ("Введён неверный параметр команды.");
            }
            String result = ("Добавлен элемент с id " + id);
            Iterator<Movie> iterator = new MovieCollection().getCollection().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                long movieId = movie.getId();
                if (movieId == id) {
                    iterator.remove();
                    result = ("Обновлён элемент с id " + id);
                    break;
                }
            }
            ServerSender serverSender = new ServerSender();
            serverSender.send(clientSocket, "передачка", 1);
            try {
                ServerReceiver serverReceiver = new ServerReceiver();
                new MovieCollection().addToCollection((Movie) serverReceiver.receive(clientSocket));
                sqlConnection.uploadAllMovies();
            } catch (Exception e) {
                return "Не вышло добавить элемент в коллекцию";
            }
            return result;
        } else {
            return ("Данной команде необходим аргумент.");
        }

    }

    @Override
    public String getName() {
        return name;
    }
}
