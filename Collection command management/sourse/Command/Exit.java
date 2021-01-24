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
    public void execute(String arg) {
        System.out.println("Вы точно хотите выйти из программы, ничего не сохранив?(yes/no)");
        System.out.print("$ ");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if (ans.equals("yes")) System.exit(0);

    }
}
