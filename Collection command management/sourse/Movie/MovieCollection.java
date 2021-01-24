package Movie;

import Utilities.DecodeCSV;

import java.util.*;

/**
 * Класс, представляющий собой описание коллекции элементов. Описывает поведение
 * и поля, необходимые для работы с коллекцией.
 *
 * @version 1.00
 * @author Deimos
 */
public class MovieCollection {

    protected static LinkedHashSet<Movie> movies;
    private final Date dateCreation;

    /**
     * Конструктор, необходимый для инициализации даты создания коллекции.
     */
    public MovieCollection() {
        this.dateCreation = new Date();
    }

    /**
     * Метод, возвращающий значение даты создания коллекции.
     * @return дата создания коллекции
     */
    public Date getDateCreation() {
        return dateCreation;
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
    public LinkedHashSet<Movie> getMovies() {
        return movies;
    }

    /**
     * Метод, возвращающий строковое представление коллекции.
     * @return строковое представление коллекции
     */
    public String getStrMovies() {
        String strMovies = "";
        for (Movie movie : this.getMovies()) {
            strMovies += movie.getStrMovie()+"\n";
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
    public int getMinId() {
        int minId = 0;
        boolean flag = true;
        for (Movie movie : this.getMovies()) {
            if (flag) {
                minId = movie.getId();
                flag = false;
            } else if (minId < movie.getId()) return minId;
        }
        if (flag) return 0;
        return minId;
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
    public MovieCollection(String fileName) {
        this.dateCreation = new Date();
        movies = new LinkedHashSet<Movie>();
        DecodeCSV.decodeFromCSV(fileName);
        System.out.println("Коллекция успешно создана");
    }
}
