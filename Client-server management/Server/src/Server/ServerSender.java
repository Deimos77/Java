package Server;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class ServerSender {
    public static void send(String message,Integer needAnswer) {
        try {
            //Переменная needAnswer имеет четыре ключа:
            //0 - Ответ от клиента не нужен, готов к след команде.
            //1 - Необходим ответ от клиента, не готов принимать след команду.
            //2 - Ответ от клиента не нужен, но и принимать команду не готов.      (юзать, когда нужно дослать ещё какую-то инфу.)
            //3 - Необходимо получение Movie от клиента.

            Map<String,Integer> answer = new HashMap<>();
            answer.put(message,needAnswer);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(answer);
            answer.clear();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            byte[] buff = byteArrayOutputStream.toByteArray();

            DatagramSocket datagramSocket = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(buff,buff.length, InetAddress.getLocalHost(),ServerReceiver.currentClientPort);
            datagramSocket.send(dp);
            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}