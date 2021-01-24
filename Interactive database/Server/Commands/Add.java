package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;
import Utility.SQLConnection;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.InputMismatchException;

/**
 * The type Add.
 */
public class Add implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "add";






    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        try {

            SQLConnection sqlConnection = new SQLConnection();

            sqlConnection.ConnectionToDB();

            sqlConnection.loadAllMovies();

            ServerSender serverSender = new ServerSender();

            serverSender.send(clientSocket, "передачка", 1);
            ServerReceiver serverReceiver = new ServerReceiver();

            Movie movie = (Movie) serverReceiver.receive(clientSocket);
            new MovieCollection().addToCollection(movie);


            movie.setUser(user);



            sqlConnection.uploadAllMovies();
            return ("Элемент добавлен в коллекцию!");
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
        }

    }

    @Override
    public String getName() {
        return name;
    }
}
