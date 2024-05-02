package Random_Stuff.Project;

import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Integer;
import java.util.Timer;

public class ProjectServer {
    private ServerSocket server;
    private Socket player1, player2;
    private DataInputStream input;
    private DataOutputStream output;
    
    final int[] ports = {
        7777
    };
    
    public ProjectServer() {
        setupSocket();
        setupIO(player1);
        setupIO(player2);
    }
    protected void setupSocket() {
        boolean connecting = true;
        boolean connected = false;
        int attempts = 0;
        int port = ports[0];
        
        while(connecting) {
            try {
                server = new ServerSocket(port, 10);
                connecting = false;
                connected = true;
            } catch(BindException bindEx) {
                
            } catch(IOException ex) {
                System.out.println("Connection #" + (++attempts) + " failed. Trying again...");
                System.out.println(ex);
            }
        }
        if(!connecting && !connected) { 
            System.out.println("Connection timed out");
            System.exit(1);
        }
        
        try
        {
            player1 = server.accept();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    protected void setupIO(Socket client) {
        try {
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            
            // HeartbeatMonitor hbm = new HeartbeatMonitor(input, output);
            // hbm.start();
        } catch(IOException io) {
            System.out.println("IO could not be established");
        } catch(Exception ex) {
            System.out.println("An unexpected error occured");
            ex.printStackTrace();
            System.exit(1);
        }
    }
    private int findIndex(int port) {
        for(int i = 0; i < ports.length; i++) {
            if(ports[i] == port) return i;
        }
        return -1;
    }
    
    private void periodic() {
        
    }
}


