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

    MovieCollection movies = new MovieCollection();
    static boolean flag2 = true;

    /**
     * Метод реализует выполнение команды. @see Remove_any_by_oscars_count
     *
     * @param arg заданное значение для сравнения с полем oscarsCount
     */
    @Override
    public void execute(String arg) {
        boolean flag = true; int count = 0;
        if (arg != null) {
            long oscarsCount = 0;
            try {
                oscarsCount = Long.parseLong(arg);
            } catch (NumberFormatException e) {
                System.out.print("$ ");
                Scanner sc = new Scanner(System.in);
                String trueArg = sc.nextLine();
                this.execute(trueArg);
            }
            Iterator<Movie> iterator = movies.getMovies().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                long movieOscarsCount = movie.getOscarsCount();
                if (movieOscarsCount == oscarsCount) {
                    iterator.remove(); count++;
                    System.out.println("Удалён элемент с id " + movie.getId());
                }
            } if (count == 0 && flag2) {
                flag2 = false;
                System.out.println("Элементы с заданным значением поля отсутствуют");
            }
        } else {
            if (flag) System.out.println("Введите значение аргумента");
            System.out.print("$ ");
            Scanner scan = new Scanner(System.in);
            String n = scan.nextLine();
            this.execute(n);
        }

    }
}
