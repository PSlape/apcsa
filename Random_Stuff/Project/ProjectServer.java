package Random_Stuff.Project;

import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Integer;
import java.util.Timer;

public class ProjectServer {
    private ServerSocket server;
    private Socket client;
    private DataInputStream input;
    private DataOutputStream output;
    
    final int[] ports = {
        7777
    };
    
    public ProjectServer() {
        setupSocket();
        setupIO();
    }
    protected void setupSocket() {
        boolean connecting = true;
        int attempts = 0;
        int port = ports[0];
        
        while(connecting) {
            try {
                server = new ServerSocket(port, 10);
            } catch(BindException bindEx) {
                try {
                    port = ports[findIndex(port) + 1];
                } catch(IndexOutOfBoundsException ex) {
                    connecting = false;
                    port = ports[ports.length - 1];
                }
                
            } catch(IOException ex) {
                System.out.println("Connection #" + (++attempts) + " failed. Trying again...");
                System.out.println(ex);
            }
        }
        if(!connecting) { 
            System.out.println("Connection timed out");
            System.exit(1);
        }
    }
    protected void setupIO() {
        try {
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            
            HeartbeatMonitor hbm = new HeartbeatMonitor(input, output);
            hbm.start();
        } catch(IOException ex) {
            System.out.println("IO could not be established");
            setupIO(1);
        } catch(Exception ex) {
            System.out.println("An unexpected error occured");
            System.exit(1);
        }
    }
    protected void setupIO(int counter) {
        try {
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            
            HeartbeatMonitor hbm = new HeartbeatMonitor(input, output);
            hbm.start();
            
        } catch(IOException ex) {
            System.out.println("IO could not be established");
            
            if(counter < 3) setupIO(++counter);
        } catch(Exception ex) {
            System.out.println("An unexpected error occured");
            System.exit(1);
        }
    }
    private int findIndex(int port) {
        for(int i = 0; i < ports.length; i++) {
            if(ports[i] == port) return i;
        }
        return -1;
    }
}


