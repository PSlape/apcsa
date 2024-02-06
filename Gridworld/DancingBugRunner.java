package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.util.ArrayList;


/**
 * Write a description of class DancingBugRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DancingBugRunner {
    public static void main() {
        ActorWorld world = new ActorWorld();
        
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        for(int i = 0; i < 10; i++) {
            array.add((int) (Math.random() * 9 + 1));
        }
        
        world.add(new Location(4, 4), new DancingBug(array));
        world.show();
    }
}
