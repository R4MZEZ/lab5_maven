package Client;


import java.io.*;
import java.net.*;


public class Connector implements Runnable{
        private final int PORT = 1212;
        private InetAddress ADDRESS;
        ByteArrayOutputStream b1 = new ByteArrayOutputStream(1024);
        ObjectOutputStream outputStream;
        ObjectInput input;
        protected static boolean isExit = false;


        byte[] buffer = new byte[1024];

        DatagramSocket datagramSocket;
        DatagramPacket packet;

        public Connector(){
            try {
                ADDRESS = InetAddress.getByName("localhost");
                outputStream = new ObjectOutputStream(b1);
                datagramSocket = new DatagramSocket();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void send(Object data){
            try {
                b1 = new ByteArrayOutputStream(1024);
                outputStream = new ObjectOutputStream(b1);
                outputStream.writeObject(data);
                packet = new DatagramPacket(b1.toByteArray(),b1.toByteArray().length, ADDRESS, PORT);
                datagramSocket.send(packet);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public String receive(){
            try {
                buffer = new byte[2048];
                packet = new DatagramPacket(buffer,buffer.length, ADDRESS, PORT);
                datagramSocket.receive(packet);
                input = new ObjectInputStream(new ByteArrayInputStream(buffer));
                return (String)input.readObject();

            }catch (IOException | ClassNotFoundException e){
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


