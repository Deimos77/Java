package Command;

import Movie.MovieCollection;
import Utilities.FileToStringScanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    /**
     * Метод реализует выполнение команды. @see Save
     *
     * @param arg не используется
     */
    @Override
    public String execute(String arg)  {
        try {
            OutputStream outputStream = new FileOutputStream(new File(FileToStringScanner.getEnv()));
            byte[] dataToBytes = new MovieCollection().getStrMovies().getBytes();
            outputStream.write(dataToBytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            return "Коллекция не сохранена из-за непонятных ошибок.";
        }
        return "Коллекция сохранена в изначальный файл";
    }
}