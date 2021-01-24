package Stuff;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс, представляющий собой описание коллекции элементов. Описывает поведение
 * и поля, необходимые для работы с коллекцией.
 *
 * @version 1.00
 * @author Deimos
 */
public class MovieCollection implements Serializable {



    protected static LinkedHashSet<Movie> movies;
    private static LocalDate dateCreation;


    /**
     * Метод, возвращающий значение даты создания коллекции.
     * @return дата создания коллекции
     */
    public static LocalDate getDateCreation() {
        return dateCreation;
    }
    public static void setDateCreation(LocalDate dateCreation) {
        MovieCollection.dateCreation = dateCreation;
    }

    /**
     * Метод, возвращающий значение размера коллекции.
     * @return размер коллекции
     */
    public int getSize() {
        return movies.size();
    }

    /**
     * Метод, возвращающий коллекцию в представлении LinkedHashSet.
     * @return коллекция LinkedHashSet
     */
    public static LinkedHashSet<Movie> getCollection() {
        return movies;
    }

    public static void setCollection(LinkedHashSet<Movie> movies) {
        MovieCollection.movies = movies;
    }


    /**
     * Метод, возвращающий строковое представление коллекции.
     * @return строковое представление коллекции
     */
    public String getStrMovies() {
        String strMovies = "";
        for (Movie movie : this.getCollection()) {
            strMovies += movie.getInfo()+"\n";
        }
        return strMovies;
    }

    /**
     * Метод устанавливает значение передаваемой коллекции в поле данного класса.
     * @param movies коллекция LinkedHashSet
     */
    public void setMovies(LinkedHashSet<Movie> movies) {
        MovieCollection.movies = movies;
    }

    /**
     * Метод производит очистку коллекции, делает её пустой.
     */
    public void clear() {
        movies.clear();
    }

    /**
     * Метод добавляет элемент в коллекцию
     * @param movie подходящий для коллекции элемент
     */
    public void addToCollection(Movie movie) {
        movies.add(movie);
    }

    /**
     * Метод вычисляет минимальное значение поля id в коллекции
     * @return минимальное значение поля id в коллекции
     */
    public long getMinId() {
        long minId = 0;
        boolean flag = true;
        for (Movie movie : this.getCollection()) {
            if (flag) {
                minId = movie.getId();
                flag = false;
            } else if (minId < movie.getId()) return minId;
        }
        if (flag) return 0;
        return minId;
    }

    public void setStream(Stream<Movie> stream){
        movies = (LinkedHashSet<Movie>) stream.collect(Collectors.toSet());
        stream.close();
    }

    /**
     * Метод возвращает информацию о коллекции.
     * @return информация о коллекции: тип, количество элементов, дата создания
     */
    public String getInfo() {
        return "Тип коллекции: LinkedHashSet;\nКоличество элементов коллекции: " + this.getSize() + ";\nДата создания коллекции: " + this.getDateCreation() + ".";
    }

    /**
     * Конструктор, создаёт новую коллекцию, используя данные из файла.
     * @param fileName имя файла, из которого происходит считывание
     */

}