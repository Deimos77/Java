package Utility;

import Stuff.*;

import java.sql.*;
import java.util.LinkedHashSet;


public class SQLConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "korolev";
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement preparedStatement;
    private static ResultSet rs;

    public static Boolean ConnectionToDB() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            throw e;

        }
    }
    public static Boolean addNewUser(String user, String password) {
        try {
            preparedStatement = connection.prepareStatement("insert into userdb values (?,?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {

            return false;
        }
    }

    public static Boolean userExist(String user, String password) {

        try {
            preparedStatement = connection.prepareStatement("select * from userdb d where exists( select * from userdb where d.login = ? and d.password= ?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {

        }
        return false;
    }
    public static Boolean moviesExist(Long id) {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from movies d where exists( select * from users where d.id =" + id + ")");
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {

        }
        return false;
    }

    public static void uploadAllMovies() {
        try {
            stmt = connection.createStatement();
            stmt.execute("TRUNCATE movies");
            LinkedHashSet<Movie> movies = MovieCollection.getCollection();
            movies.stream().forEach(x -> {
                try {
                    preparedStatement = connection.prepareStatement("INSERT into movies values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setLong(1, x.getId());;
                    preparedStatement.setString(2, x.getName());
                    preparedStatement.setFloat(3, x.getCoordinates().getX());
                    preparedStatement.setFloat(4, x.getCoordinates().getY());
                    preparedStatement.setTimestamp(5, (Timestamp) x.getCreationDate());
                    preparedStatement.setLong(6, x.getOscarsCount());
                    preparedStatement.setLong(7, x.getTotalBoxOffice());
                    preparedStatement.setLong(8, x.getLength());
                    preparedStatement.setString(9, x.getGenre().toString());

                    try {
                        preparedStatement.setString(10, x.getPerson().getName());
                    } catch (NullPointerException e) {
                        preparedStatement.setString(10, null);
                    }
                    try {
                        preparedStatement.setDouble(11, x.getPerson().getHeight());
                    } catch (NullPointerException e) {
                        preparedStatement.setObject(11, null);
                    }
                    try {
                        preparedStatement.setString(12, x.getPerson().getEyeColor().toString());
                    } catch (NullPointerException e) {
                        preparedStatement.setString(12, null);
                    }
                    try {
                        preparedStatement.setString(13, x.getPerson().getHairColor().toString());
                    } catch (NullPointerException e) {
                        preparedStatement.setString(13, null);
                    }
                    try {
                        preparedStatement.setString(14, x.getPerson().getNationality().toString());
                    } catch (NullPointerException e) {
                        preparedStatement.setString(14, null);
                    }
                    preparedStatement.setString(14, x.getUser());
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadAllMovies() {
        try {
            try {
                MovieCollection.getCollection().clear();
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from movies");
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt(1));
                movie.setName(rs.getString(2));
                Movie.Coordinates coordinates = movie.new Coordinates();
                coordinates.setX(rs.getLong(3));
                coordinates.setY(rs.getFloat(4));
                movie.setCoordinates(coordinates);
                movie.setCreationDate(rs.getTimestamp(5));
                movie.setOscarsCount( rs.getLong(6));
                movie.setTotalBoxOffice( rs.getLong(7));
                movie.setLength( rs.getLong(8));
                movie.setGenre(Movie.MovieGenre.valueOf(rs.getString(9)));

                Movie.Person person = movie.new Person();
                try {
                    person.setName(rs.getString(10));
                } catch (NullPointerException e) {
                    person.setName(null);
                }
                try {
                    person.setHeight(rs.getInt(11));
                } catch (NullPointerException e) {
                    person.setName(null);
                }
                try {
                    person.setEyeColor(Movie.Color.valueOf(rs.getString(12)));
                } catch (NullPointerException e) {
                    person.setName(null);
                }
                try {
                    person.setHairColor(Movie.Color.valueOf(rs.getString(13)));
                } catch (NullPointerException e) {
                    person.setName(null);
                }
                try {
                    person.setNationality(Movie.Country.valueOf(rs.getString(14)));
                } catch (NullPointerException e) {
                    person.setName(null);
                }


                movie.setUser(rs.getString(15));
                movie.setPerson(person);
                MovieCollection.getCollection().add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}