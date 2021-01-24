import Stuff.*;
import Utility.*;
import Commands.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.awt.event.WindowFocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

/**
 * The type Main.
 */
public class Client {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws FileNotFoundException the file not found exception
     * @author Max
     */

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {
        Commands commands = new Commands();
        commands.regist(new Add(), new Add_if_min(), new Clear(), new ExecuteScript(), new Exit(), new Help(), new History(), new Info(), new Print_field_descending_person_height(), new Remove_any_by_oscars_count(), new Remove_by_id(), new Remove_lower(), new Show(), new Sum_of_total_box_office(), new Update_by_id());
        ClientSender.tryToConnect();
        System.out.println(ClientReceiver.receive());
        while (true) {
            System.out.println("Введите команду,для справки введите help.");
            String commandName = Console.read();
            if (!commandName.equals("")) {
                if (commands.getCommand(commandName.split(" ")[0])!=null) {
                    try {
                        Map<Commandable,String> map= commands.executeCommand(commandName);
                        if (map!=null) {
                            ClientSender.send(map);
                            if (Commands.timeTostop){
                                System.out.println("Завершаю работу по вашей команде."); System.exit(0);}
                            System.out.println(ClientReceiver.receive());
                        }

                    }
                    catch (SocketTimeoutException | SQLException e){
                        System.out.println("Возможно сервер занят другим пользователем,подождите пожалуйста и попробуйте снова.");
                    } catch (SocketException e){
                        System.out.println("Сервер отключился,попробую подсоединиться заново.");
                        ClientSender.tryToConnect();
                        ClientReceiver.receive();
                    }
                }
            }
        }
    }
}
