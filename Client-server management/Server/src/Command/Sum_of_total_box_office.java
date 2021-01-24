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

    /**
     * Метод реализует выполнение команды. @see Sum_of_total_box_office
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        long sumOfTotalBoxOffice = 0;
        sumOfTotalBoxOffice = new MovieCollection().getMovies().stream().mapToLong(x -> x.getTotalBoxOffice()).sum();
        return "Сумма значений поля totalBoxOffice для всех элементов равна " + sumOfTotalBoxOffice;
    }
}
