package Commands;

import Stuff.CommandWithoutArg;
import Stuff.MovieCollection;

import java.net.Socket;

/**
 * The type Help.
 */
public class Help implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "help";
    /**
     * The Movie collection.
     */
    MovieCollection movieCollection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) {
        return("help: вывести справку по доступным командам"
                +"\ninfo: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д."
                +"\nshow: вывести в стандартный поток вывода все элементы коллекции в строковом представлении"
                +"\nadd : добавить новый элемент в коллекцию"
                +"\nupdate_by_id {id}: обновить значение элемента коллекции, id которого равен заданному"
                +"\nremove_by_id {id}: удалить элемент из коллекции по его id"
                +"\nclear: очистить коллекцию"
                +"\nsave: сохранить коллекцию в файл"
                +"\nexecute_script file_name: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме"
                +"\nexit: завершить программу (без сохранения в файл)"
                +"\nadd_if_min {id} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции"
                +"\nremove_lower {id}: удалить из коллекции все элементы, меньшие, чем заданный"
                +"\nhistory: вывести последние 5 команд (без их аргументов)"
                +"\nremove_any_by_oscars_count {oscarsCount} : удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному"
                +"\nsum_of_total_box_office : вывести сумму значений поля totalBoxOffice для всех элементов коллекции");
    }

    @Override
    public String getName() {
        return name;
    }
}