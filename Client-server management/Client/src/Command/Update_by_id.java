package Command;

import Client.Invoker;

/**
 * Класс-команда, обновляет элемент коллекции со значением id, указанном в параметре.
 *
 * @author Deimos
 * @version 1.00
 */
public class Update_by_id implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Update_by_id() {
        Invoker.regist("update_by_id", this);
    }

    @Override
    public String execute(String arg) {
        return null;
    }
}