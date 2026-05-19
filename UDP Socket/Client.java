import java.io.*;
import java.util.*;
import java.net.*;

public class Client{

    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message for Server : ");
        String msg = sc.nextLine();
        InetAddress ip = InetAddress.getByName("localhost");
        int port = 5555;
        DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, port);
        ds.send(dp);
        System.out.println("Data packets sent to Server...");
        ds.close();
    }

}