package Server;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Map;

public class ServerReceiver {

    public static boolean serverIsAvailable = true;
    public static int currentClientPort = 0;
    public static DatagramChannel datagramChannel;

    public static void create() throws IOException {
        SocketAddress it = new InetSocketAddress(InetAddress.getLocalHost(), 1500);

        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        try {
            dc.bind(it);
        } catch (BindException e){
            System.out.println("Порт занят,отключась.");
            System.exit(0);
        }
        datagramChannel = dc;
    }

    public static byte[] receive() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(10000);
            byte[] bytes;
            while(true) {
                InetSocketAddress socketAddress = (InetSocketAddress) datagramChannel.receive(byteBuffer);
                if (socketAddress!= null) {
                    byteBuffer.flip();
                    int limit = byteBuffer.limit();
                    bytes = new byte[limit];
                    byteBuffer.get(bytes,0,limit);
                    byteBuffer.clear();
                    return bytes;
                }
            }
        } catch (IOException ignored) { }
        return new byte[0];
    }
}

