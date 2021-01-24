package Client;

import Command.*;

import java.io.*;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.util.Map;


public class MainClient {
    public static void main(String[] args) throws IOException {

            Invoker.regist("add", new Add());
            Invoker.regist("add_if_min", new Add_if_min());
            Invoker.regist("clear", new Clear());
            Invoker.regist("execute_script", new Execute_script());
            Invoker.regist("exit", new Exit());
            Invoker.regist("help", new Help());
            Invoker.regist("history", new History());
            Invoker.regist("info", new Info());
            Invoker.regist("print_field_descending_person_height", new Print_field_descending_person_height());
            Invoker.regist("remove_any_by_oscars_count", new Remove_any_by_oscars_count());
            Invoker.regist("remove_by_id", new Remove_by_id());
            Invoker.regist("remove_lower", new Remove_lower());
            Invoker.regist("show", new Show());
            Invoker.regist("sum_of_total_box_office", new Sum_of_total_box_office());
            Invoker.regist("update_by_id", new Update_by_id());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket ds = new DatagramSocket();
        ClientReceiver.sock = ds ;
        ClientReceiver.clientport = ds.getLocalPort();
        while (true) {
            System.out.println("Введите команду для отправки на сервер: ");
            System.out.print("$ ");
            String s = reader.readLine();
            Map<Command,String> commandParamMap = Invoker.execute(s);
            if (commandParamMap!=null) {
            if (commandParamMap.containsKey(new Exit())) {
                ClientSender.send(commandParamMap);
                System.out.println("Завершение программы...");
                System.exit(0);
            }
                if (commandParamMap.containsKey(new Execute_script())) {
                    ClientSender.send(commandParamMap);
                    int i = 0;
                    while (true) {
                        try {
                            i = ClientReceiver.receive();
                            if (i == 1) break;
                        }catch (SocketTimeoutException e){
                            System.out.println("Сервер не отвечает,попробуйте ввести команду снова.");
                        }
                    }
                } else {
                    ClientSender.send(commandParamMap);
                    try {
                        ClientReceiver.receive();
                    } catch (SocketTimeoutException e) {
                        System.out.println("Сервер не отвечает,попробуйте ввести команду снова.");
                    }
                }
            }

        }
    }

}
