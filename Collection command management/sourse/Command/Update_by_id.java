package Command;

import Movie.Movie;
import Movie.MovieCollection;
import Utilities.MovieCreator;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Класс-команда, обновляет элемент коллекции со значением id, указанном в параметре.
 * @version 1.00
 * @author Deimos
 */
public class Update_by_id implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Update_by_id() {
        Invoker.regist("update_by_id", this);
    }

    MovieCollection movies = new MovieCollection();
    MovieCreator movieCreator = new MovieCreator();

    /**
     * Метод реализует выполнение команды. @see Update_by_id
     * @param arg id обновляемого элемента коллекции
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

            String result = ("Добавлен элемент с id " + id);
            Iterator<Movie> iterator = movies.getMovies().iterator();
            while (iterator.hasNext()) {
                Movie movie = iterator.next();
                int movieId = movie.getId();
                if (movieId == id) {
                    iterator.remove();
                    result = ("Обновлён элемент с id " + id);
                    System.out.println("Удалён элемент с id " + movieId);
                    break;
                }


            }
            movies.addToCollection(movieCreator.create(id));
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