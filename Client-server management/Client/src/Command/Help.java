package Command;

import Client.Invoker;

/**
 * Класс-команда, выводит список доступных пользователю команд.
 */
public class Help implements Command {

    /**
     * Регистрирует выполнение команды.
     * @version 1.00
     * @author Deimos
     */
    public Help() {
        Invoker.regist("help", this);
    }

    /**
     * Метод реализует выполнение команды. @see Help
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg) {
        System.out.println("help: вывести справку по доступным командам");
        System.out.println("info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.");
        System.out.println("show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add : добавить новый элемент в коллекцию");
        System.out.println("update_by_id {id}: обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id {id}: удалить элемент из коллекции по его id");
        System.out.println("clear: очистить коллекцию");
        System.out.println("save: сохранить коллекцию в файл");
        System.out.println("execute_script file_name: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        System.out.println("exit: завершить программу (без сохранения в файл)");
        System.out.println("add_if_min {id} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("remove_lower {id}: удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("history: вывести последние 5 команд (без их аргументов)");
        System.out.println("remove_any_by_oscars_count {oscarsCount} : удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному");
        System.out.println("sum_of_total_box_office : вывести сумму значений поля totalBoxOffice для всех элементов коллекции");
        return null;
    }
}
