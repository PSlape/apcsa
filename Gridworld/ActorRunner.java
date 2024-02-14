package Gridworld;

import info.gridworld.actor.*;

/*
 * Name: Peyton Slape
 * Date: 1/26/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class ActorRunner {
    public static void main() {
        ActorWorld world = new ActorWorld();
        Actor act = new Actor();
        world.add(act);
        act.removeSelfFromGrid();
        world.add(act);
        world.show();
    }
}
