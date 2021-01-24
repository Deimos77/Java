package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Movie;
import Stuff.MovieCollection;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Print_field_descending_person_height implements CommandWithoutArg {
    String name = "print_field_descending_person_height";


    @Override
    public String execute(Object o, Socket clientSocket, String user) throws SQLException, FileNotFoundException {
        ArrayList<Integer> heights = new ArrayList<Integer>();
        for (Movie movie : new MovieCollection().getCollection()) {
            heights.add(movie.getPerson().getHeight());
        }
        Collections.sort(heights);
        return (heights.toString());
    }

    @Override
    public String getName() {
        return name;
    }
}
