package Utility;

import Stuff.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Класс-утилита, отвечающий за создание нового элемента коллекции.
 *
 * @author Deimos
 * @version 1.00
 */
public class MovieCreator implements Serializable {
    Movie movie = new Movie();
    public static boolean isFromScript;
    public Movie create() {
        setName(movie);
        Movie.Coordinates coords = movie.new Coordinates();
        setCoordinateXForCoordinates(coords);
        setCoordinateYForCoordinates(coords);
        movie.setCoordinates(coords);
        setOscarsCount(movie);
        setTotalBoxOffice(movie);
        setLength(movie);
        setMovieGenre(movie);
        Movie.Person person = movie.new Person();
        setNameForPerson(person);
        setHeightForPerson(person);
        setEyeColorForPerson(person);
        setHairColorForPerson(person);
        setNationalityForPerson(person);
        movie.setPerson(person);
        return movie;
    }

    public Movie create(int id) {
        this.create();
        movie.setId(id);
        return movie;
    }

    /**
     * Выполняет считывание с консоли поля для заполнения в элемент коллекции.
     *
     * @param movie заполняемый элемент коллекции
     */
    public void setName(Movie movie) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма");
        String name;
        do {
            System.out.print("$ ");
            name = scanner.nextLine();
        } while (name.equals(""));
        movie.setName(name);
    }

    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param coords заполняемое составное поле элемента коллекции
     */
    public void setCoordinateXForCoordinates(Movie.Coordinates coords) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату x");
        String x = "";
        do {
            System.out.print("$ ");
            x = scanner.nextLine();
        } while (x.equals(""));
        try {
            coords.setX(Integer.parseInt(x));
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"int\". Введите значение заново");
            this.setCoordinateXForCoordinates(coords);
        }

    }

    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param coords заполняемое составное поле элемента коллекции
     */
    public void setCoordinateYForCoordinates(Movie.Coordinates coords) {

        Scanner scanner = new Scanner(System.in);
        String y;
        System.out.println("Введите координату y");
        try {
            do {
                System.out.print("$ ");
                y = scanner.nextLine();
                if (!y.equals("") && Double.parseDouble(y) > 610) System.out.println("Значение должно быть меньше 610. Введите значение заново");
            } while (y.equals("") || Double.parseDouble(y) > 610);

            coords.setY(Float.parseFloat(y));
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"double\". Введите значение заново");

            this.setCoordinateYForCoordinates(coords);
        }
    }

    /**
     * Выполняет считывание с консоли поля для заполнения в элемент коллекции.
     *
     * @param movie заполняемый элемент коллекции
     */
    public void setOscarsCount(Movie movie) {
        Scanner scanner = new Scanner(System.in);
        String oscarsCount;
        System.out.println("Введите количество наград Оскар");
        try {
            do {
                System.out.print("$ ");
                oscarsCount = scanner.nextLine();
                if (!oscarsCount.equals(""))if (Long.parseLong(oscarsCount) <= 0) System.out.println("Значение должно быть больше 0. Введите значение заново");
            } while (oscarsCount.equals("") || (Long.parseLong(oscarsCount) <= 0));
            movie.setOscarsCount(Long.parseLong(oscarsCount));
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            this.setOscarsCount(movie);
        }
    }

    boolean flag5 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения в элемент коллекции.
     *
     * @param movie заполняемый элемент коллекции
     */
    public void setTotalBoxOffice(Movie movie) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (flag5) System.out.println("Введите количество офисных работников");
            System.out.print("$ ");
            String totalBoxOffice = scanner.nextLine();
            if (totalBoxOffice.equals("")) {
                flag5 = false;
                movie.setTotalBoxOffice(null);
                System.out.println("Установлено значение null");
            } else {
                if (Long.parseLong(totalBoxOffice) <= 0) {
                    System.out.println("Значение должно быть больше 0. Введите значение заново");
                    flag5 = false;
                    this.setTotalBoxOffice(movie);
                }
                movie.setTotalBoxOffice(Long.parseLong(totalBoxOffice));
            }
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            flag5 = false;
            this.setTotalBoxOffice(movie);
        }
    }

    boolean flag6 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения в элемент коллекции.
     *
     * @param movie заполняемый элемент коллекции
     */
    public void setLength(Movie movie) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (flag6) System.out.println("Введите длину фильма (в минутах)");
            System.out.print("$ ");
            String length = scanner.nextLine();
            if (length.equals("")) {
                flag6 = false;
                this.setLength(movie);
            } else
            if (Long.parseLong(length) <= 0) {
                System.out.println("Значение должно быть больше 0. Введите значение заново");
                flag6 = false;
                this.setLength(movie);
            }
            movie.setLength(Long.parseLong(length));
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\". Введите значение заново");
            flag6 = false;
            this.setLength(movie);
        }
    }

    boolean flag7 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения в элемент коллекции.
     *
     * @param movie заполняемый элемент коллекции
     */
    public void setMovieGenre(Movie movie) {
        Scanner scanner = new Scanner(System.in);
        if (flag7) System.out.println("Введите жанр фильма (ACTION, ADVENTURE, THRILLER)");
        System.out.print("$ ");
        String movieGenre = scanner.nextLine();
        if (movieGenre.equals("ACTION") || movieGenre.equals("ADVENTURE") || movieGenre.equals("THRILLER"))
            movie.setGenre(Movie.MovieGenre.valueOf(movieGenre));
        else if (!movieGenre.equals("")) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
            flag7 = false;
            this.setMovieGenre(movie);
        } else {
            movie.setGenre(null);
            System.out.println("Установлено значение null");
        }

    }

    boolean flag8 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param person заполняемое составное поле элемента коллекции
     */
    public void setNameForPerson(Movie.Person person) {
        Scanner scanner = new Scanner(System.in);
        if (flag8) System.out.println("Введите имя режиссёра");
        System.out.print("$ ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            flag8 = false;
            this.setNameForPerson(person);
        } else
            person.setName(name);
    }



    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param person заполняемое составное поле элемента коллекции
     */
    public void setHeightForPerson(Movie.Person person) {
        try {
            String height;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите рост режиссёра");
            do {
                System.out.print("$ ");
                height = scanner.nextLine();
                if (!height.equals("")) if (Integer.parseInt(height) <= 0 ) System.out.println("Значение должно быть больше 0.  Введите значение заново");
            } while (height.equals("") || Integer.parseInt(height) <= 0);
            person.setHeight(Integer.parseInt(height));
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"int\". Введите значение заново");
            this.setHeightForPerson(person);
        }
    }

    boolean flag10 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param person заполняемое составное поле элемента коллекции
     */
    public void setEyeColorForPerson(Movie.Person person) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (flag10) System.out.println("Введите цвет глаз режиссёра (GREEN, BLUE, ORANGE, WHITE, BROWN).");
            System.out.print("$ ");
            String color = scanner.nextLine();
            if (color.equals("GREEN") || color.equals("BLUE") || color.equals("ORANGE") || color.equals("WHITE") || color.equals("BROWN"))
                person.setEyeColor(Movie.Color.valueOf(color));
            else if (color.equals("")) {
                this.setEyeColorForPerson(person);
                flag10 = false;
            } else {
                System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
                flag10 = false;
                this.setEyeColorForPerson(person);
            }

        } catch (InputMismatchException e) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
            this.setEyeColorForPerson(person);
        }
    }

    boolean flag11 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param person заполняемое составное поле элемента коллекции
     */
    public void setHairColorForPerson(Movie.Person person) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (flag11) System.out.println("Введите цвет волос режиссёра (GREEN, BLUE, ORANGE, WHITE, BROWN).");
            System.out.print("$ ");
            String color = scanner.nextLine();
            if (color.equals("GREEN") || color.equals("BLUE") || color.equals("ORANGE") || color.equals("WHITE") || color.equals("BROWN"))
                person.setHairColor(Movie.Color.valueOf(color));
            else if (color.equals("")) this.setHairColorForPerson(person);
            else {
                System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
                flag11 = false;
                this.setHairColorForPerson(person);
            }

        } catch (InputMismatchException e) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
            flag11 = false;
            this.setHairColorForPerson(person);
        }
    }

    boolean flag12 = true;

    /**
     * Выполняет считывание с консоли поля для заполнения составного поля элемента
     * коллекции.
     *
     * @param person заполняемое составное поле элемента коллекции
     */
    public void setNationalityForPerson(Movie.Person person) {
        Scanner scanner = new Scanner(System.in);
        if (flag12) System.out.println("Введите национальность режиссёра (NORTH_KOREA, GERMANY, UNITED_KINGDOM).");
        System.out.print("$ ");
        String nationality = scanner.nextLine();
        if (nationality.equals("GREEN") || nationality.equals("NORTH_KOREA") || nationality.equals("GERMANY") || nationality.equals("UNITED_KINGDOM"))
            person.setNationality(Movie.Country.valueOf(nationality));
        else if (nationality.equals("")) {
            System.out.println("Установлено значение null");
            person.setNationality(null);
        }
        else {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение заново");
            flag12 = false;
            this.setNationalityForPerson(person);
        }
    }
}
