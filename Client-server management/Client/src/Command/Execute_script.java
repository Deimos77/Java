package Command;

import Client.Invoker;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Класс-команда, выполняющая команды из файла-скрипта.
 * @version 1.00
 * @author Deimos
 */
public class Execute_script implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Execute_script() {
        Invoker.regist("execute_script", this);
    }
    static ArrayList<String> exScrHistory = new ArrayList<>();
    /**
     * Метод реализует выполнение команды. @see Execute_script
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {

        return null;
    }
}

// execute_script C:\Users\wers0\Desktop\script.txt с переходом на script2