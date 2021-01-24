package Command;

import Movie.Movie;
import Movie.MovieCollection;

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

    @Override
    public String execute(String arg) {
        String result = "";
        for (Movie movie : new MovieCollection().getMovies()) {
            result += movie.getStrBeautyMovie() + "\n";
        }
        if (!result.equals("")) return result; else return "Коллекция пустая.";
    }

}
