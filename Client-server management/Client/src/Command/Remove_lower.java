package Command;

import Client.Invoker;

/**
 * Класс-команда, удаляет элементы со значением id меньше
 * заданного значения.
 * @version 1.00
 * @author Deimos
 */
public class Remove_lower implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Remove_lower() {
        Invoker.regist("remove_lower", this);
    }
    @Override
    public String execute(String arg) {

        return null;
    }

}
