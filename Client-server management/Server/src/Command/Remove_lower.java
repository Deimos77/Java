package Command;

import Movie.Movie;
import Movie.MovieCollection;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Класс-команда, удаляет элементы со значением id меньше
 * заданного значения.
 * @version 1.00
 * @author Deimos
 */
public class Remove_lower implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Remove_lower() {
        Invoker.regist("remove_lower", this);
    }


    /**
     * Метод реализует выполнение команды. @see Remove_lower
     *
     * @param arg заданное значение для сравнения
     */
    @Override
    public String execute(String arg) {
        String result = "";
        boolean isEmpty = true;
            int id;
            try {
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return ("Введён неверный параметр команды, попробуйте ещё раз.");
            }

            Iterator<Movie> iterator = new MovieCollection().getMovies().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                int movieId = movie.getId();
                if (movieId < id) {
                    isEmpty = false;
                    iterator.remove();
                    result += "Удалён элемент с id " + movieId + "\n";
                }
            }
        if (isEmpty) return "В коллекции нет элементов с id меньше заданного значения."; else return  result;
    }

}
