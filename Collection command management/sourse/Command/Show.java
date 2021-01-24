package Command;

import Movie.Movie;
import Movie.MovieCollection;

import java.util.LinkedHashSet;


/**
 * Класс-команда, выводит все элементы коллекции в каскадном виде.
 * @version 1.00
 * @author Deimos
 */
public class Show implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Show() {
        Invoker.regist("show", this);
    }

    MovieCollection collection = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Show
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) {
        boolean notExist = true;
        LinkedHashSet<Movie> movies = collection.getMovies();
        for (Movie movie : movies) {
            notExist = false;
            System.out.println(movie.getStrBeautyMovie());
        }

        if (notExist) {
            System.out.println("Коллекция пустая");
        }

    }


}
