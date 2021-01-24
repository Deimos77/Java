package Server;

import Command.*;
import Movie.MovieCollection;
import Utilities.Deserializer;

import java.io.*;
import java.util.Map;


public class MainServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MovieCollection collection = new MovieCollection(System.getenv("Movies"));
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
        ServerReceiver.create();
        System.out.println("Сервер активен.");
        while (true) {
            Map<Command, String> commandStringMap;
            try {
                System.out.println("Ожидаю команду.");
                Object o = Deserializer.toDeserialize(ServerReceiver.receive());
                System.out.println(o);
                commandStringMap = (Map<Command, String>) o;
                ServerReceiver.serverIsAvailable =false;
                Command command = commandStringMap.entrySet().iterator().next().getKey();
                System.out.println("Выполняю команду: " + command.getClass().getName());
                if (commandStringMap.entrySet().iterator().next().getValue() != null) System.out.println("Аргумент команды: " + commandStringMap.entrySet().iterator().next().getValue());
                ServerSender.send(command.execute(commandStringMap.entrySet().iterator().next().getValue()),0);
                ServerReceiver.serverIsAvailable =true;
                Invoker.addToHistory(commandStringMap.entrySet().iterator().next().getKey().getClass().getName());
                if (!commandStringMap.entrySet().iterator().next().getKey().getClass().getName().equals("Command.Exit"))
                    System.out.println("Отсылаю ответ клиенту с портом " + ServerReceiver.currentClientPort + ".");
            }
            catch (ClassCastException | IOException e){
                ServerSender.send("Ошибка с маслом.\"\n",0);
            }
            catch (NullPointerException e){
                System.out.println("kek");
            }

        }
    }
}
