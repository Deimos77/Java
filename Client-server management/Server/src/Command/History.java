package Command;


import java.util.ArrayList;

/**
 * Класс-команда, выводит историю последних 8 выполняемых команд.
 */
public class History implements Command {

    /**
     * Регистрирует выполнение команды.
     *
     * @version 1.00
     * @author Deimos
     */
    public History() {
        Invoker.regist("history", this);
    }

    /**
     * Метод реализует выполнение команды. @see History
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        ArrayList<String> history = new Invoker().getHistory();
        int numOfCommands = history.size();
        System.out.println(history);
        String result = "Последние выполненные команды:\n";
        try {
            for (int i = numOfCommands - 1; (i > numOfCommands - 9) && (i >= 0); i--)
                result += history.get(i) + "\n";
        } catch (IndexOutOfBoundsException e) {
            return "История в данный момент недоступна.";
        }
        return result;
    }
}