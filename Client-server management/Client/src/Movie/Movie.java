package Movie;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Класс, представляющий собой описание элемента коллекции. Описывает поведение
 * и поля, необходимые для работы с элементом коллекции.
 *
 * @version 1.00
 * @author Deimos
 */
public class Movie implements Serializable {

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Long totalBoxOffice; //Поле может быть null, Значение поля должно быть больше 0
    private long length; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private Person director; //Поле не может быть null

    /**
     * Класс, экземпляры которого являются составным полем коллекции.
     * @version 1.00
     * @author Deimos
     */
    public class Coordinates implements Serializable{
        private Integer x; //Поле не может быть null
        private Double y; //Максимальное значение поля: 610, Поле не может быть null

        /**
         * Метод возвращает значение поля для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public Integer getX() {
            return x;
        }

        /**
         * Метод устанавливает значение поля для составного поля коллекции.
         * @param x значение поля элемента для составного поля коллекции
         */
        public void setX(Integer x) {
            this.x = x;
        }

        /**
         * Метод возвращает значение поля для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public Double getY() {
            return y;
        }

        /**
         * Метод устанавливает значение поля для составного поля коллекции.
         * @param y значение поля элемента для составного поля коллекции
         */
        public void setY(Double y) {
            this.y = y;
        }
    }

    /**
     * Класс, экземпляры которого являются составным полем коллекции.
     * @version 1.00
     * @author Deimos
     */
    public class Person implements Serializable{
        private String name; //Поле не может быть null, Строка не может быть пустой
        private int height; //Значение поля должно быть больше 0
        private Color eyeColor; //Поле не может быть null
        private Color hairColor; //Поле не может быть null
        private Country nationality; //Поле может быть null

        /**
         * Метод возвращает значение поля элемента для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public String getName() {
            return name;
        }

        /**
         * Метод устанавливает значение поля для  составного поля коллекции.
         * @param name значение поля элемента для составного поля коллекции
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Метод возвращает значение поля элемента для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public int getHeight() {
            return height;
        }

        /**
         * Метод устанавливает значение поля для составного поля коллекции.
         * @param height значение поля элемента для составного поля коллекции
         */
        public void setHeight(int height) {
            this.height = height;
        }

        /**
         * Метод возвращает значение поля элемента для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public Color getEyeColor() {
            return eyeColor;
        }

        /**
         * Метод устанавливает значение поля для составного поля коллекции.
         * @param eyeColor значение поля элемента для составного поля коллекции
         */
        public void setEyeColor(Color eyeColor) {
            this.eyeColor = eyeColor;
        }

        /**
         * Метод возвращает значение поля элемента для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public Color getHairColor() {
            return hairColor;
        }

        /**
         * Метод устанавливает значение поля для составного поля коллекции.
         * @param hairColor значение поля элемента для составного поля коллекции
         */
        public void setHairColor(Color hairColor) {
            this.hairColor = hairColor;
        }

        /**
         * Метод возвращает значение поля элемента для составного поля коллекции.
         * @return значение поля элемента для составного поля коллекции
         */
        public Country getNationality() {
            return nationality;
        }

        /**
         * Метод устанавливает значение поля для составного поля коллекции.
         * @param nationality значение поля элемента для составного поля коллекции
         */
        public void setNationality(Country nationality) {
            if (nationality == null) this.nationality = null;
            else this.nationality = nationality;
        }
    }

    /**
     * Enum-класс, содержит варианты для некоторых полей коллекции.
     */
    public enum MovieGenre {
        ACTION,
        ADVENTURE,
        THRILLER
    }

    /**
     * Enum-класс, содержит варианты для некоторых полей коллекции.
     */
    public enum Color {
        GREEN,
        BLUE,
        ORANGE,
        WHITE,
        BROWN
    }

    /**
     * Enum-класс, содержит варианты для некоторых полей коллекции.
     */
    public enum Country {
        UNITED_KINGDOM,
        GERMANY,
        NORTH_KOREA;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public int getId() {
        return id;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param id значение поля элемента для коллекции
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public String getName() {
        return name;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param name значение поля элемента для коллекции
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает значение составного поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Метод устанавливает значение составного поля для коллекции.
     * @param coordinates значение составного поля элемента для коллекции
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param creationDate значение поля элемента для коллекции
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public Long getOscarsCount() {
        return oscarsCount;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param oscarsCount значение поля элемента для коллекции
     */
    public void setOscarsCount(Long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public Long getTotalBoxOffice() {
        return totalBoxOffice;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param totalBoxOffice значение поля элемента для коллекции
     */
    public void setTotalBoxOffice(Long totalBoxOffice) {
        if (totalBoxOffice == null) this.totalBoxOffice = null;
        else this.totalBoxOffice = totalBoxOffice;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public long getLength() {
        return length;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param length значение поля элемента для коллекции
     */
    public void setLength(long length) {
        this.length = length;
    }

    /**
     * Метод возвращает значение поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param genre значение поля элемента для коллекции
     */
    public void setGenre(MovieGenre genre) {
        if (genre == null) this.genre = null;
        else this.genre = genre;
    }

    /**
     * Метод возвращает значение составного поля элемента коллекции.
     * @return значение поля элемента коллекции
     */
    public Person getPerson() {
        return director;
    }

    /**
     * Метод устанавливает значение поля для коллекции.
     * @param director значение поля элемента для коллекции
     */
    public void setPerson(Person director) {
        this.director = director;
    }


    /**
     * Метод, возвращающий строковое каскадное представление элемента коллекции.
     * @return строковое каскадное представление элемента коллекции
     */
    public String getStrBeautyMovie() {
        String totalBoxOffice;
        if (this.getTotalBoxOffice() == null) totalBoxOffice = "отсутствует"; else totalBoxOffice = this.getTotalBoxOffice().toString();
        String genre;
        if (this.getGenre() == null) genre = "отсутствует"; else genre = this.getGenre().toString();
        String nationality;
        if (this.director.getNationality() == null) nationality = "отсутствует"; else nationality = this.director.getNationality().toString();
        return "Фильм[id: [" + this.getId() + "]]:" + "\n\t" +
                "Имя: " + this.getName() + ";\n\t" +
                "Создан: " + this.getCreationDate() + "; \n\t" +
                "Координаты:" + "\n\t\tx=" + this.coordinates.getX() +
                ";\n\t\ty=" + this.coordinates.getY() + "; \n\t" +
                "Количество Оскаров: " + this.getOscarsCount() + ";\n\t" +
                "Количество работающих офисов: " + totalBoxOffice + ";\n\t" +
                "Длина: " + this.getLength() + ";\n\t" +
                "Жанр: " + genre + ";\n\t" +
                "Режиссёр:" +
                "\n\t\tИмя режиссёра: " + this.director.getName() + ";\n\t\t" +
                "Рост: " + this.director.getHeight() + ";\n\t\t" +
                "Цвет глаз: "+ this.director.getEyeColor() + ";\n\t\t" +
                "Цвет волос: " + this.director.getHairColor()+ ";\n\t\t" +
                "Национальность: " + nationality +".";
    }

    /**
     * Метод, возвращающий строковое представление элемента коллекции.
     * @return строковое представление элемента коллекции
     */
    public String getStrMovie() {
        String totalBoxOffice;
        if (this.getTotalBoxOffice() == null) totalBoxOffice = "отсутствует"; else totalBoxOffice = this.getTotalBoxOffice().toString();
        String genre;
        if (this.getGenre() == null) genre = "отсутствует"; else genre = this.getGenre().toString();
        String nationality;
        if (this.director.getNationality() == null) nationality = "отсутствует"; else nationality = this.director.getNationality().toString();
        return this.getId() + ";" +this.getName() + ";" + this.coordinates.getX() + ";" + this.coordinates.getY() + ";" + this.getCreationDate() + ";" + this.getOscarsCount() +
                ";" + totalBoxOffice + ";" + this.getLength() + ";" + genre + ";" + this.director.getName() + ";" + this.director.getHeight() + ";" +
                this.director.getEyeColor() + ";" + this.director.getHairColor() + ";" + nationality;
    }
}