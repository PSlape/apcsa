package Gridworld;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.*;
import info.gridworld.actor.*;
/*
 * Name: Peyton Slape
 * Date: 2/7/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
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
        courage = (int) (actors.size() / (2 * radius));
        int scaled = courage * 255;
        scaled = clamp(scaled, 0, 255);
        setColor(new Color(255, scaled, scaled));
    }
    
    private int clamp(int num, int min, int max) {
        return Math.max(min, Math.min(num, max));
    }
}
