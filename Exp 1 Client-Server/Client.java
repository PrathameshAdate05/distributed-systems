import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
    public static void main(String[] args) {
        try{
            Socket client = new Socket(args[0], 8081);
            DataInputStream ip = new DataInputStream(client.getInputStream());
            DataOutputStream op = new DataOutputStream(client.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.println("Client -> ");
            String msg = sc.nextLine();
            
            op.writeUTF(msg);
            System.out.println("Server -> "+ (String)ip.readUTF());

            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}