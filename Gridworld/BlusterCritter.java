package Gridworld;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.*;
import info.gridworld.actor.*;
/**
 * Write a description of class BlusterCritter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlusterCritter extends Critter {
    int radius, courage;
    
    public BlusterCritter(int rad) {
        super();
        radius = rad;
        courage = 0;
    }
    
    @Override
    public ArrayList<Actor> getActors() {
        Grid<Actor> grid = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for(int dir = 0; dir < 360; dir += 45) {
            Location temp;
            for(int i = 0; i < radius; i++) {
                temp = getLocation().getAdjacentLocation(dir);
                if(grid.isValid(temp) && grid.get(temp) != null) actors.add(grid.get(temp));
            }
        }
        return actors;
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors) {
        courage = (int) (((double) actors.size() / 25.0) * 100.0);
        int scaled = (courage / 100) * 255;
        setColor(new Color(255, scaled, scaled));
    }
}
