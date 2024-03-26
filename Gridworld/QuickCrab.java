package Gridworld;

import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/*
 * Name: Peyton Slape
 * Date: 2/7/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class QuickCrab extends CrabCritter {
    
    public QuickCrab() {
        super();
        setColor(java.awt.Color.pink);
    }
    
    @Override
    public ArrayList<Location> getMoveLocations() {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
            
        for(int i = 0; i < dirs.length; i++) {
            Location loc1 = getLocation().getAdjacentLocation(dirs[i]);
            Location loc2 = loc1.getAdjacentLocation(dirs[i]);
            if(getGrid().isValid(loc2) && isEmpty(loc2) && isEmpty(loc1)) {
                locs.add(loc2);
            } else if(getGrid().isValid(loc1) && isEmpty(loc1)) {
                locs.add(loc1);
            }
        }
        return locs;
    }
    
    private boolean isEmpty(Location loc) {
        return getGrid().get(loc) == null || getGrid().get(loc) instanceof Flower;
    }
}
