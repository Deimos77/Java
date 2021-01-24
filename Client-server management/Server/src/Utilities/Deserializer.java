package Utilities;

import Server.ServerReceiver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class Deserializer {

    public static Object toDeserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Map<Integer, Object> map = (Map<Integer, Object>) objectInputStream.readObject();
            if (ServerReceiver.serverIsAvailable) {
                ServerReceiver.currentClientPort = map.entrySet().iterator().next().getKey();
                obj = map.entrySet().iterator().next().getValue();
            } else if (ServerReceiver.currentClientPort == map.entrySet().iterator().next().getKey()) {
                obj = map.entrySet().iterator().next().getValue();
            } else{
                return Deserializer.toDeserialize(ServerReceiver.receive());
            }
            byteArrayInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

}