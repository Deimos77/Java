package Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSender {
    ExecutorService executorService = Executors.newCachedThreadPool();
    public void send(Socket client, String message, Integer needAnswer) {
        executorService.execute(new Sender(client, message, needAnswer));

        System.out.println("Отправляю данные этому человечку: " + client.getLocalAddress() + client.getPort());
    }

    public class Sender implements Runnable {
        private Socket client;
        private String message;
        private Integer needAnswer;

        public Sender(Socket client, String message, Integer needAnswer) {
            this.client = client;
            this.message = message;
            this.needAnswer = needAnswer;

        }

        @Override
        public void run() {
            Map<String, Integer> answer = new HashMap<>();
            answer.put(message, needAnswer);
            Object o = answer;
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
                objectOutputStream.writeObject(o);
                answer.clear();

            } catch (IOException e) {
            }
        }
    }
}