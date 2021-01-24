package Command;


import java.util.Scanner;

/**
 * Класс-команда, выполняет выход из программы.
 * @version 1.00
 * @author Deimos
 */
public class Exit implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Exit() {
        Invoker.regist("exit", this);
    }

    /**
     * Метод реализует выполнение команды. @see Exit
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        System.out.println("Завершение работы сервера...");
        new Save().execute(null);
        System.exit(0);
        return ("Работа программы продолжается.");
    }
}
