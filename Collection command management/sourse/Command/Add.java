package Command;

import Movie.MovieCollection;
import Utilities.MovieCreator;

/**
 * Класс-команда, добавляет элемент в коллекцию.
 * @version 1.00
 * @author Deimos
 */
public class Add implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Add() {
        Invoker.regist("add", this);
    }

    MovieCollection movies = new MovieCollection();
    MovieCreator movieCreator = new MovieCreator();

    /**
     * Метод реализует выполнение команды. @see Add
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) {
        movies.addToCollection(movieCreator.create());
    }
}
