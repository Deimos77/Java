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
import java.util.InputMismatchException;

public class Add_if_min  implements Commandable {
    /**
     * The Name.
     */
    String name = "add_if_min";






    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException {
        MovieCollection movies = new MovieCollection();
        if (o != null) {
            try {
                int id = Integer.parseInt((String)o);
                if (id < movies.getMinId()) {
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
            return ("Элемент добавлен в коллекцию!");} else return ("Извините, но ваш id слишком большой :)");
            } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
            }

        } else {return ("Необходимо ввести значение аргумента");}
    }

    @Override
    public String getName() {
        return name;
    }
}
