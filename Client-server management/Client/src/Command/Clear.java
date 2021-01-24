package Command;

import Client.Invoker;

/**
 * Класс-команда, удаляет все элементы из коллекции.
 *
 * @author Deimos
 * @version 1.00
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

        return null;
    }
}
