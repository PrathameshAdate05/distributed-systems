import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        DataInputStream ip = null;
        DataOutputStream op = null;
        Scanner sc = null;

        try{
                server = new ServerSocket(8081);
                Socket s =server.accept();
                ip = new DataInputStream(s.getInputStream());
                op = new DataOutputStream(s.getOutputStream());
                sc = new Scanner(System.in);

                String msg = (String) ip.readUTF();

                System.out.println("Client -> "+msg);

                System.out.println("Enter message -> ");
                String input = sc.nextLine();

                op.writeUTF(input);

                server.close();
                s.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
