package Random_Stuff.Project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Integer;
import java.util.Timer;

public class ProjectServer {
    private ServerSocket server;
    private Socket client;
    private DataInputStream input;
    private DataOutputStream output;
    
    public ProjectServer(int port) {
        setupSocket(port);
        setupIO();
    }
    protected void setupSocket(int port) {
        boolean connecting = true;
        int attempts = 0;
        while(connecting) {
            try {
                server = new ServerSocket(port, 10);
            } catch(IOException ex) {
                System.out.println("Connection #" + (++attempts) + " failed. Trying again...");
            } finally {
                connecting = attempts <= 3;
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
}


