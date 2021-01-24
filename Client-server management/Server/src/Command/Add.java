package Command;

import Movie.Movie;
import Movie.MovieCollection;
import Server.ServerReceiver;
import Server.ServerSender;
import Utilities.Deserializer;
import Utilities.MovieCreator;

import java.io.IOException;

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


    /**
     * Метод реализует выполнение команды. @see Add
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        ServerSender.send(null, 3);
        try {
            new MovieCollection().addToCollection((Movie) Deserializer.toDeserialize(ServerReceiver.receive()));
        } catch (ClassNotFoundException | IOException e) {
            return "Не вышло добавить элемент в коллекцию";
        }
        return ("Элемент добавлен в коллекцию.");
    }
}
