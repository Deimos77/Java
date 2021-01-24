package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс-утилита, отвечает за считывания коллекции из файла с помощью утилиты Scanner.
 *
 * @author Deimos
 * @version 1.00
 */
public class FileToStringScanner {
    private static final String getEnv = System.getenv("Movies");

    /**
     * Метод обрабатывает значение переменной среды и возвращает его в виде строки.
     *
     * @return значение переменной среды в строковом виде
     */
    public static String getEnv() {
        return getEnv;
    }




    /**
     * Метод построчно сканирует содержимое файла и возвращает содержимое в строчном виде.
     *
     * @param fileName имя файла, из которого происходит считывание
     * @return содержимое файла в строковом виде
     */
    public static String convert(String fileName) {
        String data = "";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                data += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (NullPointerException e) {
            data = "";
        }

        return data;
    }
}
