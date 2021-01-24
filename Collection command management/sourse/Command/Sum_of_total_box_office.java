package Command;

import Movie.Movie;
import Movie.MovieCollection;

/**
 * Класс-команда, выводит сумму всех полей sum_of_total_box_office из элементов коллекции.
 * @version 1.00
 * @author Deimos
 */
public class Sum_of_total_box_office implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Sum_of_total_box_office() {
        Invoker.regist("sum_of_total_box_office", this);
    }

    MovieCollection movies = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Sum_of_total_box_office
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) {
        long sumOfTotalBoxOffice = 0;
        for (Movie movie : movies.getMovies()) {

            if (movie.getTotalBoxOffice() != null) sumOfTotalBoxOffice += movie.getTotalBoxOffice();
        }
        System.out.println("Сумма значений поля totalBoxOffice для всех элементов равна " + sumOfTotalBoxOffice);
    }
}
