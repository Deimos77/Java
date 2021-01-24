package Command;

import Client.Invoker;

/**
 * Класс-команда, выводит сумму всех полей sum_of_total_box_office из элементов коллекции.
 *
 * @author Deimos
 * @version 1.00
 */
public class Sum_of_total_box_office implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Sum_of_total_box_office() {
        Invoker.regist("sum_of_total_box_office", this);
    }


    /**
     * Метод реализует выполнение команды. @see Sum_of_total_box_office
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        return null;
    }
}
