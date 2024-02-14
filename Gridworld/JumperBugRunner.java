package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

/*
 * Name: Peyton Slape
 * Date: 2/1/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class JumperBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        
        world.addOccupantClass("JumperBug");
        world.addOccupantClass("Rock");
        
        world.add(new Location(4, 4), new JumperBug());
        for(int i = 0; i < 16; i++) {
            world.add(new Rock(BlusterCritterRunner.randomColor()));
        }
        world.show();
    }
}
