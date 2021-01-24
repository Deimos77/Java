package Command;

import Movie.Movie;

import java.util.Iterator;
import java.util.Scanner;

import Movie.MovieCollection;

/**
 * Класс-команда, удаляет элементы со значением поля oscarsCount равным
 * заданному значению.
 * @version 1.00
 * @author Deimos
 */
public class Remove_any_by_oscars_count implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Remove_any_by_oscars_count() {
        Invoker.regist("remove_any_by_oscars_count", this);
    }


    /**
     * Метод реализует выполнение команды. @see Remove_any_by_oscars_count
     *
     * @param arg заданное значение для сравнения с полем oscarsCount
     */
    @Override
    public String execute(String arg) {
            long oscarsCount = 0;
            try {
                oscarsCount = Long.parseLong(arg);
            } catch (NumberFormatException e) {
                return ("Неверный формат аргумента, необходимо ввести значение типа long.");
            }
            Iterator<Movie> iterator = new MovieCollection().getMovies().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                long movieOscarsCount = movie.getOscarsCount();
                if (movieOscarsCount == oscarsCount) {
                    iterator.remove();
                    return "Удалён элемент с id " + movie.getId();
                }
                return "Элементы с заданным значением поля отсутствуют";
            }
            return "Коллекция пустая.";
    }
}
