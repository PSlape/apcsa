package Gridworld;

import java.awt.Color;

import info.gridworld.grid.Location;
import info.gridworld.actor.*;
/*
 * Name: Peyton Slape
 * Date: 2/7/24
 * Lab: Gridworld
 * Description: Creates a world for a critter to live in
 * Purpose: To practice using subclasses and premade libraries.
 */
public class ChameleonKidRunner
{
    public static void run() {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(2, 8), new Rock(Color.BLUE));
        world.add(new Location(5, 5), new Rock(Color.PINK));
        world.add(new Location(1, 5), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(4, 4), new ChameleonKid());
        world.add(new Location(5, 8), new ChameleonKid());
        world.show();
    }
}
