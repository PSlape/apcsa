package Gridworld;

import info.gridworld.grid.Location;
import info.gridworld.actor.*;

import java.util.ArrayList;

/**
 * Write a description of class RockHound here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RockHound extends Critter {
    @Override
    public void processActors(ArrayList<Actor> actors) {
        for(Actor act : actors) {
            if(act instanceof Rock) {
                act.removeSelfFromGrid();
            }
        }
    }
}
