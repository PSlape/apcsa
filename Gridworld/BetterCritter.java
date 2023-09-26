package Gridworld;


import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class BetterCritter extends Critter {
    Location selectMoveLocation(Location... locs) {
        return locs[(int) (Math.random() * locs.length)];
    }
}