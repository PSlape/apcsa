package Gridworld;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;

/**
 * Write a description of class WDMBugRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WDMBugRunner {
    private static final Color[] COLORS = {Color.red, Color.blue, Color.green, Color.yellow};
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(new BoundedGrid(10, 10));
        
        for(int i = 0; i < 4; i++) {
            world.add(new WorldDominantMultiplierBug(COLORS[i % COLORS.length]));
        }
        
        for(int i = 0; i < 10; i++) {
            world.add(new DancingBug());
        }
        world.show();
    }
}
