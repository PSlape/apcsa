package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


/**
 * Write a description of class DancingBugRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DancingBugRunner {
    public static void main() {
        ActorWorld world = new ActorWorld();
        
        world.add(new Location(4, 4), new DancingBug(5, 3, 2, 1));
        world.show();
    }
}
