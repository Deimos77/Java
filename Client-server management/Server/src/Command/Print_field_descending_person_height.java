package Command;

import Movie.Movie;
import Movie.MovieCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Print_field_descending_person_height implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Print_field_descending_person_height() {
        Invoker.regist("print_field_descending_person_height", this);
    }

//    @Override
//    public String execute(String arg) throws IOException {
//        MovieCollection movies = new MovieCollection();
//        Stream<Movie> stream = movies.getMovies().stream();
//        if (stream.count() != 0) {
//        } else return "Коллекция пустая.";
//        return null;
//    }

        @Override
    public String execute(String arg) {
        ArrayList<Integer> heights = new ArrayList<Integer>();
        for (Movie movie : new MovieCollection().getMovies()) {
            heights.add(movie.getPerson().getHeight());
        }
        Collections.sort(heights);
        return (heights.toString());
    }
}
