package Command;


import Client.Invoker;

/**
 * Класс-команда, выводит информацию о коллекции.
 */
public class Info implements Command {

    /**
     * Регистрирует выполнение команды.
     *
     * @version 1.00
     * @author Deimos
     */
    public Info() {
        Invoker.regist("info", this);
    }


    @Override
    public String execute(String arg) {
        return null;
    }
}
