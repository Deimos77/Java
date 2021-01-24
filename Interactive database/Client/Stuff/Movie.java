package Stuff;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * The type movie.
 */
public class Movie implements Comparable, Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Timestamp creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Long totalBoxOffice; //Поле может быть null, Значение поля должно быть больше 0
    private long length; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private Person person; //Поле не может быть null
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public class Coordinates implements Serializable {
        private float x;
        private Double y; //Максимальное значение поля: 289, Поле не может быть null

        /**
         * Gets x.
         *
         * @return the x
         */
        public float getX() {
            return x;
        }

        /**
         * Sets x.
         *
         * @param x the x
         */
        public void setX(float x) {
            this.x = x;
        }

        /**
         * Gets y.
         *
         * @return the y
         */
        public Double getY() {
            return y;
        }

        /**
         * Sets y.
         *
         * @param y the y
         */
        public void setY(Double y) {
            this.y = y;
        }
    }
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Timestamp creationDate) {
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
     * Gets person.
     *
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets person.
     *
     * @param person the person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public class Person implements Serializable {
        private String name; //Поле не может быть null, Строка не может быть пустой
        private int height; //Значение поля должно быть больше 0
        private Color eyeColor; //Поле может быть null
        private Color hairColor; //Поле не может быть null
        private Country nationality; //Поле не может быть null



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
         * Gets eye color.
         *
         * @return the eye color
         */
        public Color getEyeColor() {
            return eyeColor;
        }

        /**
         * Sets eye color.
         *
         * @param eyeColor the eye color
         */
        public void setEyeColor(Color eyeColor) {
            this.eyeColor = eyeColor;
        }

        /**
         * Gets hair color.
         *
         * @return the hair color
         */
        public Color getHairColor() {
            return hairColor;
        }

        /**
         * Sets hair color.
         *
         * @param hairColor the hair color
         */
        public void setHairColor(Color hairColor) {
            this.hairColor = hairColor;
        }

        /**
         * Gets nationality.
         *
         * @return the nationality
         */
        public Country getNationality() {
            return nationality;
        }

        /**
         * Sets nationality.
         *
         * @param nationality the nationality
         */
        public void setNationality(Country nationality) {
            this.nationality = nationality;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(height, person.height) &&
                    eyeColor == person.eyeColor &&
                    hairColor == person.hairColor &&
                    nationality == person.nationality;
        }



        @Override
        public int hashCode() {
            return Objects.hash(name, height, eyeColor, hairColor, nationality);
        }
    }

    public String getInfo() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        return "Фильм [id:" + id + "]:\n\t" + "Имя: " + name + "\n\tКоординаты:\n\t\tx: " + coordinates.getX() +
                "\n\t\ty: " + coordinates.getY() + "\n\tДата cоздания: " + creationDate + "\n\tНаграды оскар: " + oscarsCount +
                "\n\tОфисные работники: " + totalBoxOffice + "\n\tДлина: " + length + "\n\tЖанр: " + genre +
                "\n\tОписание режиссёра:\n\t\tИмя: " + person.getName() + "\n\t\tВысота: " + person.getHeight()  + "\n\t\tЦвет волос: " + person.getHairColor() + "\n\t\tЦвет глаз: " +
                person.getEyeColor() + "\n\t\tНациональность: " + person.getNationality() + "\n\tВладелец: " + user;
    }
    public enum MovieGenre implements Serializable {
        ACTION,
        ADVENTURE,
        THRILLER
    }

    public enum Country implements Serializable {
        /**
         * Usa country.
         */
        USA,
        /**
         * France country.
         */
        FRANCE,
        /**
         * Vatican country.
         */
        VATICAN,
        /**
         * Russia country.
         */
        RUSSIA,
        /**
         * Thailand country.
         */
        THAILAND;
    }

    public enum Color implements Serializable {
        /**
         * Green color.
         */
        GREEN,
        /**
         * Yellow color.
         */
        YELLOW,
        /**
         * Black color.
         */
        BLACK,
        /**
         * Orange color.
         */
        ORANGE,
        /**
         * White color.
         */
        WHITE,
        /**
         * Brown color.
         */
        BROWN;
    }

    @Override
    public int compareTo(Object movie) {
        return this.getInfo().length() - ((Movie) movie).getInfo().length();
    }

    /**
     * Get csv movie string.
     *
     * @return the string
     */
    public String getCsvMovie() {
        return (this.getId() + "," + this.getName() + "," + this.getCoordinates().getX() + "," + this.getCoordinates().getY() + "," + this.getCreationDate() + "," + this.getOscarsCount() + "," + this.getTotalBoxOffice() + "," + this.getLength() + "," + this.getGenre() + "," + this.getPerson().getName() + "," + this.getPerson().getHeight() + "," + this.getPerson().getEyeColor() + "," + this.getPerson().getHairColor() + "," + this.getPerson().getNationality());
    }
}


