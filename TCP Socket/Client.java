import java.io.*;
import java.net.*;

public class Client{

    public static void main(String[] args)throws IOException{
        Socket s = new Socket("localhost", 5505); 
        /* Destination IP and Port number has been binded with the Server and thr request has been sent... */

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg1 = "";
        String msg2 = "";

        while(true){
            System.out.print("Enter your message for Server : ");
            msg1 = br.readLine();
            dout.writeUTF(msg1);

            msg2 = din.readUTF();
            System.out.println("Message from Server is : " + msg2);
            
            if(msg1.equals("bye") || msg2.equals("bye")){
                break;
            }
        }
        System.out.println("Connection broke...");
        s.close();
        dout.close();
        din.close();
        br.close();
    }

}