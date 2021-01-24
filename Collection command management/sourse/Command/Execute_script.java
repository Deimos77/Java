package Command;

import Utilities.Executer;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

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

    /**
     * Метод реализует выполнение команды. @see Execute_script
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) {
        try {
            if (arg != null) Executer.executeFile(arg); else {
                System.out.println("Введите полное имя файла");
                Scanner sc = new Scanner(System.in);
                this.execute(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Введено неверное ПОЛНОЕ ИМЯ файла, попробуйте ещё раз\n$ ");
            Scanner sc = new Scanner(System.in);
            String trueArg = sc.nextLine();
            this.execute(trueArg);
        }
    }
}

// execute_script C:\Users\wers0\Desktop\script.txt с переходом на script2