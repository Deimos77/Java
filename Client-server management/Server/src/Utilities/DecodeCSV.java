package Utilities;

import Movie.*;


import java.time.LocalDate;

import java.util.LinkedHashSet;

/**
 * Класс-утилита, описывает обработку CSV таблицы и заполнение коллекций соответствующими
 * значениями из этой таблицы.
 *
 * @author Deimos
 * @version 1.00
 */
public class DecodeCSV {

    /**
     * Метод обрабатывает строчное представление CSV таблицы и заполняет коллекцию
     * элементами, где значения полей - соответствующие значения из таблицы.
     *
     * @param fileName имя файла, из которого происходит считывание
     */
    public static void decodeFromCSV(String fileName) {
        String[] line;
        String[] elements;
        String data;
        LinkedHashSet<Movie> movies = new LinkedHashSet<Movie>();

        FileToStringScanner fileToString = new FileToStringScanner();
        data = fileToString.convert(fileName);
        line = data.split("\r\n|\n");
        try {
            for (int i = 0; i < line.length; i++) {

                elements = line[i].split(";");
                Movie movie = new Movie();

                movie.setId(i + 1);

                if (elements[1] != null && !(elements[1].equals(""))) {
                    movie.setName(elements[1]);
                } else {
                    System.out.println("Неверный ввод названия в объекте " + i);
                }

                Movie.Coordinates coordinates = movie.new Coordinates();
                coordinates.setX(Integer.parseInt(elements[2]));
                coordinates.setY(Double.parseDouble(elements[3]));
                movie.setCoordinates(coordinates);
                // ДАТА СОЗДАНИЯ
                movie.setCreationDate(LocalDate.now());


                if ((Long.parseLong(elements[5]) > 0)) {
                    movie.setOscarsCount(Long.parseLong(elements[5]));
                } else {
                    System.out.println("Неверный ввод количества Оскар наград в объекте " + i);
                }
                if (elements[6].equals("") || elements[6].equals("null")) {movie.setTotalBoxOffice(null); } else {
                    if ((Long.parseLong(elements[6]) > 0)) {
                        movie.setTotalBoxOffice(Long.parseLong(elements[6]));
                    } else {
                        System.out.println("Неверный ввод количества офисных работников в объекте " + i);
                    }
                }
                if ((Long.parseLong(elements[7]) > 0)) {
                    movie.setLength(Long.parseLong(elements[7]));
                } else {
                    System.out.println("Неверный ввод длины фильма в объекте " + i);
                }

                if (elements[8].equals("") || elements[8].equals("null")) {movie.setGenre(null); } else {movie.setGenre(Movie.MovieGenre.valueOf(elements[8])); }

                Movie.Person person = movie.new Person();
                if (elements[9] != null && !(elements[9].equals(""))) {
                    person.setName(elements[9]);
                } else {
                    System.out.println("Неверный ввод имени директора в объекте " + i);
                }
                if ((Integer.parseInt(elements[10]) > 0)) {
                    person.setHeight(Integer.parseInt(elements[10]));
                } else {
                    System.out.println("Неверный ввод роста директора в объекте " + i);
                }
                if (elements[11] != null) {
                    person.setEyeColor(Movie.Color.valueOf(elements[11]));
                } else {
                    System.out.println("Неверный ввод цвета глаз директора в объекте " + i);
                }
                if (elements[12] != null) {
                    person.setHairColor(Movie.Color.valueOf(elements[12]));
                } else {
                    System.out.println("Неверный ввод цвета волос директора в объекте " + i);
                }

                try {
                    if (elements[13].equals("") || elements[13].equals("null")) {
                        person.setNationality(null);
                    } else {
                        person.setNationality(Movie.Country.valueOf(elements[13]));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {person.setNationality(null); }
                movie.setPerson(person);
                movies.add(movie);
            }
            MovieCollection collection = new MovieCollection();
            collection.setMovies(movies);
            System.out.println("Коллекция заполнена");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Ошибка формата ввода");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Коллекция не получила на ввод элементов");
        }
    }


}

