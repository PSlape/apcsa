package Gridworld;

import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
/**
 * Write a description of class JumperBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JumperBug extends BetterBug {
    
    public JumperBug() {
        super();
        setColor(java.awt.Color.yellow);
    }
    
    @Override
    public void act() {
        if(canMove()) {
            move();
        } else {
            Location next = getLocation().getAdjacentLocation(getDirection());
            Location next2 = next.getAdjacentLocation(getDirection());
            var grid = getGrid();
            
            if(grid.isValid(next2)) {
                if(grid.get(next2) == null || grid.get(next2) instanceof Flower) {
                    moveTo(next2);
                } else {
                    turn();
                }
            } else {
                turn();
            }
        }
    }
}
