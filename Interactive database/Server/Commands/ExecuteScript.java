package Commands;

import Stuff.Commandable;
import Stuff.Commands;
import Stuff.MovieCollection;
import Utility.MovieCreator;
import Utility.ReaderFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Execute script.
 */
public class ExecuteScript implements Commandable {
    /**
     * The Name.
     */
    String name = "execute_script";
    /**
     * The Collection.
     */
    MovieCollection collection = new MovieCollection();
    static ArrayList<String> exScrHistory = new ArrayList<>();
    /**
     * The Reader.
     */

    /**
     * The Invoker.
     */


    /**
     * @param arg название файла
     * @return
     */

    @Override
    public String execute(Object o, Socket clientSocket, String user) throws FileNotFoundException, SQLException {


        try {
            File file = new File((String) o);
            Scanner in = new Scanner(file);
            Commands commands = new Commands();
            String result = "";
            String exFileName= "";
            while (in.hasNextLine()) {
                String command=in.nextLine();
                String[] exArg = command.split(" ");
                if(exArg.length == 2) {
                    exFileName = exArg[1];
                }
                if (!(command.equals(""))) {
                    if (!(command.equals("execute_script " + exFileName))) {
                        result+=("Команда \"" + command + "\":"+"\n");
                        result+=commands.executeCommand(command);
                    }
                    else {
                        if (exScrHistory.contains("execute_script " + exFileName)) {
                            result+=("\nКоманда \"" + command + "\": невыполнима во избежание бесконечной рекурсии.\n");
                        }
                        else {
                            exScrHistory.add("execute_script " + exFileName);
                            result+=("Команда \"" + command + "\":"+"\n");
                            result+="\n" + commands.executeCommand(command) + "\n";
                        }
                    }
                }
            }
            exScrHistory.clear();
            return result;
        } catch (NullPointerException | FileNotFoundException e) {
            return ("Указанный файл не найден.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}