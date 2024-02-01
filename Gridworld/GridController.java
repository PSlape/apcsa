package Gridworld;

import info.gridworld.grid.*;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import java.util.ArrayList;

/**
 * Write a description of class RemoteGrid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridController {
    public static void test() {
        ActorWorld world1 = new ActorWorld();
        ActorWorld world2 = new ActorWorld();
        
        TeleBug tele = new TeleBug(world1, world2);
        world1.add(tele);
        
        world1.show();
        world2.show();
    }
    
    public static void transpose(ActorWorld target, Actor actor, Location newLocation) {
        actor.removeSelfFromGrid();
        target.add(newLocation, actor);
    }
}
