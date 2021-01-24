package Command;

import Client.Invoker;

/**
 * Класс-команда, выводит все элементы коллекции в каскадном виде.
 *
 * @author Deimos
 * @version 1.00
 */
public class Show implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Show() {
        Invoker.regist("show", this);
    }

    @Override
    public String execute(String arg) {
        return null;
    }
}
