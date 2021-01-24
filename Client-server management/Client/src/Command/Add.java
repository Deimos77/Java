package Command;

import Client.Invoker;

/**
 * Класс-команда, добавляет элемент в коллекцию.
 *
 * @author Deimos
 * @version 1.00
 */
public class Add implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Add() {
        Invoker.regist("add", this);
    }


    /**
     * Метод реализует выполнение команды. @see Add
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {

        return null;
    }
}
