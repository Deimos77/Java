package Commands;

import Stuff.Commandable;
import Stuff.Movie;
import Stuff.MovieCollection;
import Utility.SQLConnection;

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
        long oscarsCount = 0;
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.ConnectionToDB();
        sqlConnection.loadAllMovies();
        try {
            oscarsCount = Long.parseLong((String) o);
        } catch (NumberFormatException e) {
            return ("Неверный формат аргумента, необходимо ввести значение типа long.");
        }
        Iterator<Movie> iterator = new MovieCollection().getCollection().iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            long movieOscarsCount = movie.getOscarsCount();
            if (movieOscarsCount == oscarsCount) {
                iterator.remove();
                sqlConnection.uploadAllMovies();
                return "Удалён элемент с id " + movie.getId();
            }
            return "Элементы с заданным значением поля отсутствуют";
        }
        return "Коллекция пустая.";

    }

    @Override
    public String getName() {
        return name;
    }
}
