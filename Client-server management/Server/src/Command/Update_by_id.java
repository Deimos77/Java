package Command;

import Movie.Movie;
import Movie.MovieCollection;
import Server.ServerReceiver;
import Server.ServerSender;
import Utilities.Deserializer;
import Utilities.MovieCreator;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Класс-команда, обновляет элемент коллекции со значением id, указанном в параметре.
 * @version 1.00
 * @author Deimos
 */
public class Update_by_id implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Update_by_id() {
        Invoker.regist("update_by_id", this);
    }


    /**
     * Метод реализует выполнение команды. @see Update_by_id
     * @param arg id обновляемого элемента коллекции
     */
    @Override
    public String execute(String arg) {
        if (arg != null) {
            int id = 0;
            try {
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return ("Введён неверный параметр команды.");
            }
            String result = ("Добавлен элемент с id " + id);
            Iterator<Movie> iterator = new MovieCollection().getMovies().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                int movieId = movie.getId();
                if (movieId == id) {
                    iterator.remove();
                    result = ("Обновлён элемент с id " + id);
                    break;
                }
            }
            ServerSender.send(null, 3);
            try {
                new MovieCollection().addToCollection((Movie) Deserializer.toDeserialize(ServerReceiver.receive()));
            } catch (ClassNotFoundException | IOException e) {
                return "Не вышло добавить элемент в коллекцию";
            }
            return result;
        } else {
            return ("Данной команде необходим аргумент.");
        }
    }
}