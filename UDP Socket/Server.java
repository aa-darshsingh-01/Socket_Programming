import java.io.*;
import java.net.*;

public class Server{

    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket(5555);
        System.out.println("Server is waiting for data packets..."); // does not require three-way handshake as TCP does
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        ds.receive(dp);
        System.out.println("Data packets have been arrived...");
        String msg = new String(data, 0, data.length).trim();
        System.out.println("Message from Client is : " + msg);
        ds.close();
    }

}