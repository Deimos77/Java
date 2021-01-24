package Commands;

import Stuff.CommandWithoutArg;
import Stuff.MovieCollection;


import java.net.Socket;

/**
 * The type Exit.
 */
public class Exit implements CommandWithoutArg {
    /**
     * The Name.
     */
    String name = "exit";

    MovieCollection movieCollection = new MovieCollection();

    @Override
    public String execute(Object o, Socket clientSocket, String user) {
        System.out.println("Клиент с адресом "+clientSocket.getLocalAddress()+clientSocket.getPort()+"  приказал завершить работу.");
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}