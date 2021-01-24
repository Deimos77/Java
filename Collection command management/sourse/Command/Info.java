package Command;


import Movie.MovieCollection;

/**
 * Класс-команда, выводит информацию о коллекции.
 */
public class Info implements Command {

    /**
     * Регистрирует выполнение команды.
     * @version 1.00
     * @author Deimos
     */
    public Info() {
        Invoker.regist("info", this);
    }

    MovieCollection movies = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Info
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) {
        System.out.println(movies.getInfo());
    }
}
