package Command;

import Movie.MovieCollection;
import Utilities.FileToStringScanner;

import java.io.*;
import java.util.Scanner;

/**
 * Класс-команда, сохраняет коллекцию в файл.
 * @version 1.00
 * @author Deimos
 */
public class Save implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Save() {
        Invoker.regist("save", this);
    }

    MovieCollection movies = new MovieCollection();

    /**
     * Метод реализует выполнение команды. @see Save
     *
     * @param arg не используется
     */
    @Override
    public void execute(String arg) throws IOException {

        System.out.print("Хотите создать новый файл для сохранения коллекции?(yes) Или использовать существующий?(no)\n$ ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        OutputStream outputStream;
        if (answer.toUpperCase().equals("YES")) {
            System.out.println("Введите имя файла.");
            System.out.print("$ ");
            answer = scanner.nextLine();
            outputStream = new FileOutputStream(new File(answer));
            byte[] dataToBytes = movies.getStrMovies().getBytes();
            outputStream.write(dataToBytes);
            System.out.println("Коллекция сохранена");
            outputStream.flush();
            outputStream.close();
        } else if (answer.toUpperCase().equals("NO")) {

            if (FileToStringScanner.getEnv() == null) {
                System.out.println("Изначально не было файла с коллекцией.");
            } else {
                try {
                    outputStream = new FileOutputStream(new File(FileToStringScanner.getEnv()));
                    byte[] dataToBytes = movies.getStrMovies().getBytes();
                    outputStream.write(dataToBytes);
                    outputStream.flush();
                    outputStream.close();
                    System.out.println("Коллекция сохранена в изначальный файл");
                } catch (FileNotFoundException e) {
                    System.out.println("Доступ к файлу запрещён");
                }
            }
            System.out.print("$ ");

        }
    }
}
