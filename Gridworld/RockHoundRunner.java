package Gridworld;

import info.gridworld.actor.*;

/*
 * Name: Peyton Slape
 * Date: 2/7/24
 * Lab: Gridworld
 * Description: Creates a world for a critter to live in
 * Purpose: To practice using subclasses and premade libraries.
 */
public class RockHoundRunner
{
    public static void run() {
        ActorWorld world = new ActorWorld();
        world.addOccupantClass("QuickCrab");
        world.add(new RockHound());
        for(int i = 0; i < 16; i++) {
            //world.add(new DancingBug());
            //world.add(new SpiralBug());
            world.add(new Rock());
        }
        world.show();
    }
}
