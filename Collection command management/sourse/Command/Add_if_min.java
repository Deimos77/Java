package Command;

import Movie.MovieCollection;
import Utilities.MovieCreator;

import java.util.Scanner;

/**
 * Класс-команда, добавляет элемент в коллекцию, если его значение id меньше
 * заданного значения.
 * @version 1.00
 * @author Deimos
 */
public class Add_if_min implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Add_if_min() {
        Invoker.regist("add_if_min", this);
    }

    MovieCreator movieCreator = new MovieCreator();
    MovieCollection movies = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Add_if_min
     *
     * @param arg id желаемого для добавления в коллекцию элемента
     */
    @Override
    public void execute(String arg) {
        if (arg != null) {

            int id = 0;
            try {
                id = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.out.println("Введён неверный параметр команды, попробуйте ещё раз\n$ ");
                Scanner sc = new Scanner(System.in);
                String trueArg = sc.nextLine();
                this.execute(trueArg);
            }

            if (id < movies.getMinId()) {
                System.out.println("Попытка создать элемент с id " + id);
                movies.addToCollection(movieCreator.create());
            } else System.out.println("Извините, но ваш id слишком большой :)");


        } else {
            System.out.println("Введите значение аргумента");
            System.out.print("$ ");
            Scanner scan = new Scanner(System.in);
            String n = scan.nextLine();
            this.execute(n);
        }
    }
}