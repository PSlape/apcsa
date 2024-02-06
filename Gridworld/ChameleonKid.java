package Gridworld;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.ArrayList;
/**
 * Write a description of class ChameleonKid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChameleonKid extends ChameleonCritter {
    @Override
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> toReturn = new ArrayList<Actor>();
        
        Location next = getLocation().getAdjacentLocation(getDirection());
        if(getGrid().isValid(next)) {
            if(getGrid().get(next) != null) {
                toReturn.add(getGrid().get(next));
            }
        }
        next = getLocation().getAdjacentLocation(getDirection() + 180);
        if(getGrid().isValid(next)) {
            if(getGrid().get(next) != null) {
                toReturn.add(getGrid().get(next));
            }
        }
        
        return toReturn;
    }
}
