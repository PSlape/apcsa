<<<<<<< HEAD
package gridworld;
=======
package Gridworld;
>>>>>>> 180e969e251da89f8b8c44d0a6af5c81bb7ffdf3

import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class BetterCritter extends Critter {
    Location selectMoveLocation(Location... locs) {
        return locs[(int) (Math.random() * locs.length)];
    }
}