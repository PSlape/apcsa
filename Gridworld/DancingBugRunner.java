package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.util.ArrayList;


/*
 * Name: Peyton Slape
 * Date: 1/26/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
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
