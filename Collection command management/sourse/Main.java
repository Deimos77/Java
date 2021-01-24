import Command.*;
import Movie.MovieCollection;
import Utilities.ConsoleReader;
import Utilities.FileToStringScanner;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Это главный класс. Здесь создаются экземпляры комманд и запускаются процессы, связанные
 * со взамиожействием с консолью и командами.
 *
 * @author Deimos
 * @version 1.00
 */
public class Main {

    /**
     * Метод, обеспечивающий выполнение программы.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileName = FileToStringScanner.getEnv();
        if (fileName == null) {
            System.out.println("Передаваемое значение не найдено, введите полное имя файла");
            do {
                System.out.print("$ ");
                Scanner sc = new Scanner(System.in);
                fileName = sc.nextLine();
            } while (fileName.equals(""));
        }
        System.out.println("Имя файла: " + fileName);

        /**
         * Создание экземпляров классов, которые будут использоваться при цикле while далее.
         * С помощью них будет происходить выполнение комманд.
         */
        Invoker invoker = new Invoker();
        MovieCollection movies = new MovieCollection(fileName);
        Info info = new Info();
        Show show = new Show();
        Remove_by_id remove_by_id = new Remove_by_id();
        Help help = new Help();
        Clear clear = new Clear();
        Add add = new Add();
        Update_by_id update_by_id = new Update_by_id();
        Save save = new Save();
        Exit exit = new Exit();
        Add_if_min add_if_min = new Add_if_min();
        Remove_lower remove_lower = new Remove_lower();
        History history = new History();
        Remove_any_by_oscars_count remove_any_by_oscars_count = new Remove_any_by_oscars_count();
        Sum_of_total_box_office sum_of_total_box_office = new Sum_of_total_box_office();
        Execute_script execute_script = new Execute_script();
        Print_field_descending_person_height print_field_descending_person_height = new Print_field_descending_person_height();


        boolean enter = false;


        /**
         * Цикл, отвечающий за выполнение комманд с параметрами из консоли.
         */
        while (true) {    // (1==1)
            try {

                if (enter) {
                    System.out.print("$ ");
                } else {
                    System.out.print("Введите команду \n$ ");
                }
                String commandName = ConsoleReader.readCommand();
                if (commandName.equals("")) enter = true;
                else Invoker.execute(commandName);
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        }


    }
}
