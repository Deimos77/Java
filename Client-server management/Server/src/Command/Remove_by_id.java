package Command;

import Movie.Movie;
import Movie.MovieCollection;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Класс-команда, удаляет элемент с заданным id.
 * @version 1.00
 * @author Deimos
 */
public class Remove_by_id implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Remove_by_id() {
        Invoker.regist("remove_by_id", this);
    }

    /**
     * Метод реализует выполнение команды. @see Remove_by_id
     *
     * @param arg id удаляемого элемента
     */
    @Override
    public String execute(String arg) {
            int id = 0;

            try {
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return "Введён неверный параметр команды.";
            }

            String result = "Элемент с таким id не существует";
            Iterator<Movie> iterator = new MovieCollection().getMovies().iterator();

            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                int movieId = movie.getId();
                if (movieId == id) {
                    iterator.remove();
                    result = "Удалён элемент с id " + movieId;
                }
            }
            return result;
    }
}
