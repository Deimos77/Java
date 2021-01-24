package Command;

import Client.Invoker;

/**
 * Класс-команда, добавляет элемент в коллекцию, если его значение id меньше
 * заданного значения.
 *
 * @author Deimos
 * @version 1.00
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

        return null;
    }
}