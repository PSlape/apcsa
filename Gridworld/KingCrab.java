package Gridworld;
import java.util.ArrayList;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/*
 * Name: Peyton Slape
 * Date: 2/6/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class KingCrab extends CrabCritter {
    
    public KingCrab() {
        super();
        setColor(java.awt.Color.orange);
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors) {
        for(Actor act : actors) {
            if(getGrid().isValid(act.getLocation().getAdjacentLocation(getDirection()))) {
                act.moveTo(act.getLocation().getAdjacentLocation(getDirection()));
            } else {
                act.removeSelfFromGrid();
            }
        }
    }
}
