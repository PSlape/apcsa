package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

/*
 * Name: Peyton Slape
 * Date: 2/7/24
 * Lab: Gridworld
 * Description: Creates a world for a critter to live in
 * Purpose: To practice using subclasses and premade libraries.
 */
public class BlusterCritterRunner {
    private static Color[] colors = {
        Color.red,
        Color.blue,
        Color.green,
        Color.magenta,
        Color.cyan,
        Color.black,
        Color.white
    };
    
    public static void run() {
        ActorWorld world = new ActorWorld();
        for(int i = 0; i < 16; i++) {
            world.add(new Rock(randomColor()));
        }
        world.add(new Location(4, 4), new BlusterCritter(3));
        world.add(new Location(5, 8), new BlusterCritter(2));
        world.show();
    }
    
    
    public static Color randomColor() {
        return colors[(int) (Math.random() * (colors.length-1))];
    }
}
