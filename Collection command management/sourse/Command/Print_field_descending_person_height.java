package Command;

import Movie.Movie;
import Movie.MovieCollection;

import java.util.ArrayList;
import java.util.Collections;

public class Print_field_descending_person_height implements Command {

    /**
     * Регистрирует выполнение команды.
     */
    public Print_field_descending_person_height() {
        Invoker.regist("print_field_descending_person_height", this);
    }

    MovieCollection movies = new MovieCollection();

    @Override
    public void execute(String arg) {
        ArrayList<Integer> heights = new ArrayList<Integer>();
        for (Movie movie : movies.getMovies()) {
            heights.add(movie.getPerson().getHeight());
        }
        Collections.sort(heights);
        System.out.println(heights);
    }
}
