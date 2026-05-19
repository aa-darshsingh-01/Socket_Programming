import java.io.*;
import java.net.*;

public class Server{

    public static void main(String[] args)throws IOException{
        ServerSocket ss = new ServerSocket(5505); 
        /* Port number has been binded with the Server... */ 
        System.out.println("Server is waiting for the requests...");
        Socket s = ss.accept(); 
        /* A new Socket object has been instantiated to pull the request from the ServerSocket to Socket so that Server remains free to accept other requests also... */
        System.out.println("Connection established succesfully...");
        /* Through three-way handshake mechanism of TCP */

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg1 = "";
        String msg2 = "";

        while(true){
            msg1 = din.readUTF();
            System.out.println("Message from Client is : " + msg1);
            
            System.out.print("Enter your message for Client : ");
            msg2 = br.readLine();
            dout.writeUTF(msg2);

            if(msg1.equals("bye") || msg2.equals("bye")){
                break;
            }
        }
        System.out.println("Connection broke...");
        ss.close();
        s.close();
        dout.close();
        din.close();
        br.close();
    }

}