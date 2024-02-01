package Gridworld;

import java.util.ArrayList;
import javax.net.ServerSocketFactory;
import java.net.*;
import java.io.*;

/**
 * Write a description of class GridWorldServer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridWorldServer {
    public static final int PORT = 7778;
    
    private final ServerSocketFactory serverSocketFactory;
    private final ArrayList<GridWorldProtocol.GridWorldConnection> serverSockets;
    
    public GridWorldServer() throws IOException {
        serverSocketFactory = ServerSocketFactory.getDefault();
        serverSockets = new ArrayList<GridWorldProtocol.GridWorldConnection>();
    }
    
    
    public void periodic() {
        
    }
}
