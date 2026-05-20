import java.io.*;
import java.net.*;

public class Server{

    public static void main(String[] args) throws IOException{
        MulticastSocket ms = new MulticastSocket(8888);
        System.out.println("Server is waiting for data packets...");
        InetAddress ip = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(ip);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        ms.receive(dp);
        String msg = new String(data, 0, data.length).trim();
        System.out.println("Message from Client is : " + msg);
        ms.close();
    }

}