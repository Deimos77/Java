package Utilities;


import java.util.Scanner;

/**
 * Класс-утилита, отвечает за считывание команд из консоли для последующего их выполнения.
 *
 * @version 1.00
 * @author Deimos
 */
public class ConsoleReader {

    public static String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
