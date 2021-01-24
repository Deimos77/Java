package Command;


import Client.Invoker;

/**
 * Класс-команда, выводит историю последних 8 выполняемых команд.
 */
public class History implements Command {

    /**
     * Регистрирует выполнение команды.
     * @version 1.00
     * @author Deimos
     */
    public History() {
        Invoker.regist("history", this);
    }


    @Override
    public String execute(String arg) {
        return null;
    }
}
