package Gridworld;

import info.gridworld.actor.*;
import java.net.*;
import java.io.*;
import java.io.BufferedReader;

/**
 * Write a description of class GridWorldProtocol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridWorldProtocol {
    public static class GridWorldTransferData {
        public ActorWorld original, target;
        public Actor actor;
        
        public GridWorldTransferData(ActorWorld og, ActorWorld tar, Actor act) {
            original = og;
            target = tar;
            actor = act;
        }
    }
    
    public static class GridWorldConnection extends Thread {
        public ServerSocket serverSocket;
        public Socket socket;

        private ObjectOutputStream writer;
        private BufferedReader reader;
        
        public GridWorldConnection(ServerSocket server) throws IOException {
            super();
            serverSocket = server;
            socket = server.accept();
            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        
        public void sendData(Object obj) throws IOException {
            writer.writeObject(obj);
        }
    }
}
