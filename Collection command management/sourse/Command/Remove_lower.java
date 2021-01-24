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

    MovieCollection movies = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Remove_lower
     *
     * @param arg заданное значение для сравнения
     */
    @Override
    public void execute(String arg) {
        if (arg != null) {
            int id = 0;
            try {
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.out.println("Введён неверный параметр команды, попробуйте ещё раз\n$ ");
                Scanner sc = new Scanner(System.in);
                String trueArg = sc.nextLine();
                this.execute(trueArg);
            }

            Iterator<Movie> iterator = movies.getMovies().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                int movieId = movie.getId();
                if (movieId < id) {
                    iterator.remove();
                    System.out.println("Удалён элемент с id " + movieId);
                }
            }
        } else {
            System.out.println("Введите значение аргумента");
            System.out.print("$ ");
            Scanner scan = new Scanner(System.in);
            String n = scan.nextLine();
            this.execute(n);
        }


    }

}
