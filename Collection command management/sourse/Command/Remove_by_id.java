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

    MovieCollection movies = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Remove_by_id
     *
     * @param arg id удаляемого элемента
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

            String result = "Элемент с таким id не существует";
            Iterator<Movie> iterator = movies.getMovies().iterator();

            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                int movieId = movie.getId();
                if (movieId == id) {
                    iterator.remove();
                    result = "Удалён элемент с id " + movieId;
                }
            }
            System.out.println(result);


        } else {
            System.out.println("Введите значение аргумента");
            System.out.print("$ ");
            Scanner scan = new Scanner(System.in);
            String n = scan.nextLine();
            this.execute(n);
        }

    }
}
