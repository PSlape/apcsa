package Random_Stuff;

import java.io.*;
import java.net.*;
import java.lang.Integer;

public class KnockKnockClient {
    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        
        String hostName = args[0];
        int port = Integer.parseInt(args[1]);
        
        try (
           Socket kkSocket = new Socket(hostName, port);
           PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
           BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer, fromUser;
            
            while((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if(fromServer.equals("Bye.")) break;
                
                fromUser = stdIn.readLine();
                if(fromUser != null) {
                    System.out.println("Client " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch(UnknownHostException ex) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch(IOException ex) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}