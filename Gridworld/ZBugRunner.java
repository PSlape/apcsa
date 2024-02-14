package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

/*
 * Name: Peyton Slape
 * Date: 1/26/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class ZBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Location(0,0), new ZBug());
        world.show();
    }
}
