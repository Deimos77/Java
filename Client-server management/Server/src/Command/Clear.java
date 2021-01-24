package Command;

import Movie.MovieCollection;

/**
 * Класс-команда, удаляет все элементы из коллекции.
 * @version 1.00
 * @author Deimos
 */
public class Clear implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Clear() {
        Invoker.regist("clear", this);
    }



    /**
     * Метод реализует выполнение команды. @see Clear
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        new MovieCollection().clear();
        return ("Коллекция пустая");
    }
}
