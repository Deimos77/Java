package Command;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Execute_script implements Command {
    static ArrayList<String> exScrHistory = new ArrayList<>();
    /**
     * @param arg название файла
     * @return
     */

    @Override
    public String execute(String arg) throws IOException {


        try {
            File file = new File((String) arg);
            Scanner in = new Scanner(file);
            Invoker commands = new Invoker();
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
                        result+=commands.execute(command);
                    }
                    else {
                        if (exScrHistory.contains("execute_script " + exFileName)) {
                            result+=("\nКоманда \"" + command + "\": невыполнима во избежание бесконечной рекурсии.\n");
                        }
                        else {
                            exScrHistory.add("execute_script " + exFileName);
                            result+=("Команда \"" + command + "\":"+"\n");
                            result+="\n" + commands.execute(command) + "\n";
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

}
