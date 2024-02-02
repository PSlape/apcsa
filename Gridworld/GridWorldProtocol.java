package Gridworld;

import info.gridworld.actor.*;
import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.util.Optional;

/**
 * Write a description of class GridWorldProtocol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridWorldProtocol {
    public static final int PORT = 7778;
    public static final String HOST_NAME = "127.0.0.1";
    public static final InetSocketAddress socketAddress = new InetSocketAddress(HOST_NAME, PORT);
    
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
        private ObjectInputStream reader;
        
        public GridWorldConnection(ServerSocket server) throws IOException {
            super();
            serverSocket = server;
            socket = server.accept();
            
            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new ObjectInputStream(socket.getInputStream());
        }
        
        public void sendData(Object obj) throws IOException {
            writer.writeObject(obj);
        }
        
        public Optional<Object> readData(Object obj) {
            Object out = null;
            try {
                out = reader.readObject();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            } catch(java.io.IOException ioe) {
                ioe.printStackTrace();
            }
            return Optional.ofNullable(out);
        }
    }
    
    public static class GridWorldClientConnection {
        public Socket socket;
        
        private ObjectOutputStream writer;
        private ObjectInputStream reader;
        
        public GridWorldClientConnection() {
            socket = new Socket();
            try
            {
                socket.bind(socketAddress);
                socket.connect(socketAddress);
                
                writer = new ObjectOutputStream(socket.getOutputStream());
                reader = new ObjectInputStream(socket.getInputStream());
            }
            catch (IOException ioe)
            {
                System.out.println("I/O to server failed.");
                ioe.printStackTrace();
            }
        }
        
        public boolean sendData(Object obj) {
            try
            {
                writer.writeObject(obj);
                return true;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            return false;
        }
        
        public Optional<Object> readData() {
            Object out = null;
            try {
                out = reader.readObject();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            } catch(java.io.IOException ioe) {
                ioe.printStackTrace();
            }
            return Optional.ofNullable(out);
        }
        
        public boolean hasData() {
            try
            {
                return reader.available() > 0;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            return false;
        }
    }
}
