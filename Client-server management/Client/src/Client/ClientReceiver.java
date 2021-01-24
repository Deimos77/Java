package Client;

import Client.ClientSender;
import Movie.Movie;
import Utilities.MovieCreator;

import java.io.*;
import java.net.*;
import java.util.Map;

public class ClientReceiver {
    public  static DatagramSocket sock;
    public static int clientport;
    public static int receive() throws SocketTimeoutException {
        byte[] buffer = new byte[100000];
        try {
            DatagramPacket reply = new DatagramPacket(buffer,buffer.length);
            sock.setSoTimeout(2500);
            sock.receive(reply);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(reply.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object obj = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            Map<String,Integer> answer = (Map<String, Integer>) obj;
            if (answer.entrySet().iterator().next().getValue()==0) {
                System.out.println("Ответ с сервера:\n"+answer.entrySet().iterator().next().getKey());
                if (answer.entrySet().iterator().next().getKey().equals("Выполнение скрипта завершено.")) {
                    System.out.println("Выполнение скрипта завершено");return 1;
                }
            }
            else if (answer.entrySet().iterator().next().getValue() == 1){
                System.out.println("Необходим ответ от вас: "+answer.entrySet().iterator().next().getKey());
                System.out.print("$ ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String s = reader.readLine();
                ClientSender.send(s);
                ClientReceiver.receive();
            }
            else if (answer.entrySet().iterator().next().getValue() == 2){
                System.out.println("Мэм: "+answer.entrySet().iterator().next().getKey());
                ClientReceiver.receive();
            } else if (answer.entrySet().iterator().next().getValue() == 3) {
                MovieCreator ct=new MovieCreator();
                Movie movie;
                if (answer.entrySet().iterator().next().getKey() == null) movie = ct.create();
                else movie = ct.create(Integer.parseInt(answer.entrySet().iterator().next().getKey()));
                ClientSender.send(movie);
                ClientReceiver.receive();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e){
            System.out.println("Сервер не отвечает,попробуйте ввести команду снова.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    return 0;}
}
