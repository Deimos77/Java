package Command;

import Client.Invoker;

/**
 * Класс-команда, удаляет элемент с заданным id.
 *
 * @author Deimos
 * @version 1.00
 */
public class Remove_by_id implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Remove_by_id() {
        Invoker.regist("remove_by_id", this);
    }


    @Override
    public String execute(String arg) {

        return null;
    }
}
