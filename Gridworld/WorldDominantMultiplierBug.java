package Gridworld;

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Write a description of class WorldDominantMultiplierBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldDominantMultiplierBug extends Bug {
    
    public WorldDominantMultiplierBug(Color color) {
        super();
        setColor(color);
    }
    
    public void act() {
        if(getGrid() == null) return;
        
        Location oldLocation = getLocation();
        Location newLocation = selectMoveLocation();
        Actor act = getGrid().get(newLocation);
        if(act != null && !(act instanceof WorldDominantMultiplierBug)) {
            startProcess(act, oldLocation);
            moveTo(newLocation);
            endProcess(act, oldLocation);
        } else {
            moveTo(newLocation);
            setDirection(oldLocation.getDirectionToward(newLocation));
        }
    }
    
    public void startProcess(Actor act, Location oldLocation) {
        if(act.getGrid() != null) act.removeSelfFromGrid();
        act.setColor(getColor());
    }
    
    public void endProcess(Actor act, Location oldLocation) {
        getGrid().put(oldLocation, act);
    }
    
    public Location selectMoveLocation() {
        var locations = getGrid().getValidAdjacentLocations(getLocation());
        return locations.get((int) (Math.random() * locations.size()));
    }
}
