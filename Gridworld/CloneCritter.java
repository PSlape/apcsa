package Gridworld;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/*
 * Name: Peyton Slape
 * Date: 2/7/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class CloneCritter extends Critter {
    
    public CloneCritter() {
        super();
        setColor(java.awt.Color.cyan);
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors) {
        for(Actor act : actors) {
            try {
                getGrid().put(getMoveLocations().get((int) (Math.random() * 360)), act.getClass().newInstance());
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
