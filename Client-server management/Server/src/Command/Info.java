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


    /**
     * Метод реализует выполнение команды. @see Info
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        return (new MovieCollection().getInfo());
    }
}
