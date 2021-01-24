package Command;


import java.util.ArrayList;

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

    Invoker invoker = new Invoker();

    /**
     * Метод реализует выполнение команды. @see History
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) {
        ArrayList<String> history = invoker.getHistory();
        int numOfCommands = history.size();
        System.out.println("Последние выполненные команды:");
        try {
            for (int i = numOfCommands - 1; (i > numOfCommands - 9) && (i >= 0); i--)
                System.out.println(history.get(i));
        } catch (IndexOutOfBoundsException e) {
            for (String s : history) System.out.println(s);
        }


    }
}
