package Gridworld;

import java.net.Socket;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.util.Optional;

/**
 * Write a description of class GridWorldClient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridWorldClient {
    private Socket socket;
    private ActorWorld world;
    
    private GridWorldProtocol.GridWorldClientConnection connection;
    
    public GridWorldClient(ActorWorld world) {
        connection = new GridWorldProtocol.GridWorldClientConnection();
        
        world = new ActorWorld();
        world.show();
    }
    
    public void add(Actor... actors) {
        for(Actor actor : actors) {
            world.add(actor);
        }
    }
    
    public Optional<Actor> remove(Location location) {
        return Optional.ofNullable(world.remove(location));
    }
    
    public void periodic() { 
        if(connection.hasData()) {
            Optional<Object> op = connection.readData();
            if(op.isPresent()) {
                add((Actor) op.get());
            }
        }
    }
}
