import java.io.*;
import java.net.*;
import java.util.*;

public class Client{

    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message for Server : ");
        String msg = sc.nextLine();
        InetAddress ip = InetAddress.getByName("224.0.0.1");
        int port = 8888;
        DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        ds.send(dp);
        System.out.println("Message has been sent to Server...");
        ds.close();
    }

}