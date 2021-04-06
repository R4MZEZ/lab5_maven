package Client;


import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;


public class Connector implements Runnable {
    private final int PORT = 1213;
    InetSocketAddress serverAddress = new InetSocketAddress("localhost", PORT);
    DatagramChannel client;

    ByteArrayOutputStream b1 = new ByteArrayOutputStream(1024);
    ObjectOutputStream outputStream;
    ObjectInput input;
    protected static boolean isExit = false;

    ByteBuffer byteBuffer;
    byte[] buffer = new byte[1024];

    public Connector() {
        try {
            client = DatagramChannel.open();
            client.bind(null);
            outputStream = new ObjectOutputStream(b1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void send(Object data) {
        try {
            b1 = new ByteArrayOutputStream(1024);
            outputStream = new ObjectOutputStream(b1);
            outputStream.writeObject(data);

            byteBuffer = ByteBuffer.wrap(b1.toByteArray());
            client.send(byteBuffer, serverAddress);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        try {
            buffer = new byte[2048];
            client.receive(ByteBuffer.wrap(buffer));
            input = new ObjectInputStream(new ByteArrayInputStream(buffer));
            return (String) input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return "Ошибка";
        }

    }

    @Override
    public void run() {
        while (!isExit) {
            System.out.println(receive());
        }
    }
}


