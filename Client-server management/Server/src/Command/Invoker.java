package Command;

import Movie.Movie;
import Movie.MovieCollection;
import Utilities.MovieCreator;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс, вызывающий объект (invoker). Знает, как выполнить команду и
 * делает учёт и запись выполненных команд.
 * @version 1.00
 * @author Deimos
 */
public class Invoker {
    private static final Map<String, Command> commands = new TreeMap<>();

    /**
     * Регистрирует выполнение команды. Кладёт команду в коллекцию TreeMap.
     *
     * @param name    имя команды
     * @param command класс-команда
     */
    public static void regist(String name, Command command) {
        commands.put(name, command);
    }


    private static final ArrayList<String> history = new ArrayList<>();

    /**
     * Возвращает историю выполнения команд.
     *
     * @return коллекцию со значениями команд
     */
    public ArrayList<String> getHistory() {
        return history;
    }

    /**
     * Добавляет в историю выполняемую команду.
     *
     * @param commandName выполняемая команда
     */
    public static void addToHistory(String commandName) {
        history.add(commandName);
    }

    /**
     * Метод организует выполнение последней добавленной в TreeMap коллекцию каманды.
     *
     * @param s аргумент для команды
     */
    public static String execute(String s) throws IOException {

MovieCreator creator = new MovieCreator();
        String[] name = s.split(" ");
        Command command = commands.get(name[0]);
        if (command != null) {
            System.out.println("\nВыполняется команда " + name[0]);
            if (name[0].equals("add")) {
                Invoker.addToHistory(name[0]);
                new MovieCollection().addToCollection(creator.createFromScript(name));
                return ("Элемент добавлен в коллекцию");
            } else if (name[0].equals("add_if_min")) {
                Invoker.addToHistory(name[0]);
                if (Integer.parseInt(name[1]) < new MovieCollection().getMinId()) {
                    for (int i = 1; i < name.length; i++) {
                        name[i - 1] = name[i];
                    }
                    new MovieCollection().addToCollection(creator.createFromScript(name));
                    return ("Элемент добавлен в коллекцию");
                } else return ("id элемента слишком большой.");
            } else if (name[0].equals("update_by_id")) {
                Invoker.addToHistory(name[0]);
                String result = ("Добавлен элемент с id ");
                Iterator<Movie> iterator = new MovieCollection().getMovies().iterator();
                while (iterator.hasNext()) {
                    Movie movie = iterator.next();
                    int movieId = movie.getId();
                    if (movieId == Integer.parseInt(name[1])) {
                        iterator.remove();
                        result = ("Элемент обновлён");
                        break;
                    }
                }
                for (int i = 1; i < name.length; i++) {
                    name[i - 1] = name[i];
                }
                new MovieCollection().addToCollection(creator.createFromScript(name));
                return result;
            } else if (name.length == 1) {
                Invoker.addToHistory(name[0]);
                return command.execute(null);
            } else {
                Invoker.addToHistory(name[0]);
                return command.execute(name[1]);
            }
        }
    return "";
    }
}
