package Command;

import Movie.Movie;
import Movie.MovieCollection;
import Server.ServerReceiver;
import Server.ServerSender;
import Utilities.Deserializer;
import java.io.IOException;

/**
 * Класс-команда, добавляет элемент в коллекцию, если его значение id меньше
 * заданного значения.
 * @version 1.00
 * @author Deimos
 */
public class Add_if_min implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Add_if_min() {
        Invoker.regist("add_if_min", this);
    }


    /**
     * Метод реализует выполнение команды. @see Add_if_min
     *
     * @param arg id желаемого для добавления в коллекцию элемента
     */
    @Override
    public String execute(String arg) {
        MovieCollection movies = new MovieCollection();
        if (arg != null) {
            int id;
            try {
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return ("Введён неверный параметр команды.");
            }
            if (id < movies.getMinId()) {
                ServerSender.send(null, 3);
                try {
                    new MovieCollection().addToCollection((Movie) Deserializer.toDeserialize(ServerReceiver.receive()));
                    return "Элемент добавлен в коллекцию.";
                } catch (ClassNotFoundException | IOException e) {
                    return "Не вышло добавить элемент в коллекцию";
                }
            } else return ("Извините, но ваш id слишком большой :)");
        } else {
            return ("Необходимо ввести значение аргумента");
        }
    }
}