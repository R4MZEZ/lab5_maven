package Server;

import java.io.IOException;
import java.net.*;

public class ServerStart {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] buffer = new byte[1024];
        int PORT = 1213;

        while(true) {
            DatagramSocket datagramSocket = new DatagramSocket(PORT++);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("Ожидание подключения...");
            datagramSocket.receive(packet);
            System.out.println("Подключение установлено...");
            datagramSocket.close();
            new Thread(new Connector(packet.getAddress(), packet.getPort(), buffer)).start();
        }
    }
}
