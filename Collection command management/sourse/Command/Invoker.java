package Command;

import java.io.IOException;


import java.util.ArrayList;
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
    public static void execute(String s) throws IOException {

        String[] name = s.split(" ");
        Command command = commands.get(name[0]);
        if (s.equals("")) {
            System.out.print("$ ");
        } else if (command == null || name.length > 2) {
            System.out.println("Такой команды не существует,попробуйте другую. Для справки введите \"help\"\n------------------------------------------------------------------------- ");
        } else if (name.length == 1) {
            command.execute(null);
            Invoker.addToHistory(name[0]);
        } else {
            command.execute(name[1]);
            Invoker.addToHistory(name[0]);
        }
    }
}
