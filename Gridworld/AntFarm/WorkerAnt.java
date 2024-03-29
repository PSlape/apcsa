package Gridworld.AntFarm;

/**
 * WorkerAnt.java  05/10/07
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>WorkerAnt</code> is a critter who's mission is
 * to take food from <code>Cake and Cookie</code> objects and to
 * deliver it to a <code>QueenAnt</code> object.
 * Initially it looks for food.  After it finds food, it looks for
 * a queen.
 * Worker ants share the location of food and the queen
 * with other ants they encounter.
 * Worker ants with food are red.  If they don't have food,
 * they are black.
 */
public class WorkerAnt extends Critter implements Processable
{
    /** Current amount of food being carried */
    private int foodQuantity;

    /** Location of a <code>Food</code> object */
    private Location foodLocation;

    /** Location of a <code>QueenAnt</code> object */
    private Location queenLocation;

    private static int[] DIRECTIONS = {Location.AHEAD, Location.HALF_RIGHT, -Location.HALF_RIGHT};
    
    /**
     * Constructs a <code>WorkerAnt</code> critter.
     * It is originally black (no food) and
     * its direction is chosen randomly from the
     * eight normal cardinal directions.
     */
    public WorkerAnt()
    {
        super();
        setColor(Color.black);
        setDirection((int) (Math.random() * Location.FULL_CIRCLE));
    }

    /**
     * Gives current food and queen locations to <code>ant</code>.
     * @param ant the calling <code>WorkerAnt</code>
     */
    public void process(WorkerAnt ant)
    {
        if(foodLocation != null) ant.shareFoodLocation(foodLocation);
        if(queenLocation != null) ant.shareQueenLocation(queenLocation);
    }

    /**
     * Takes <code>fQty</code> amount of food from the
     * calling <code>Food</code>.
     * @param fQty the amount of food to take.
     */
    public void takeFood(int fQty) {
        foodQuantity += fQty;
    }

    /**
     * Gives food to the calling <code>QueenAnt</code>.
     * @return the amound of food to give.
     */
    public int giveFood()
    {
        int temp = foodQuantity;
        foodQuantity = 0;
        return temp;
    }

    /**
     * Receives the <code>fLoc</code> food location from a
     * <code>Food</code> object.  Saves this location if
     * it doesn't already have one.
     * @param fLoc the location of the food.
     */
    public void shareFoodLocation(Location fLoc) {
        if(foodLocation == null) foodLocation = fLoc;
    }

    /**
     * Receives the <code>qLoc</code> queen location from a
     * <code>QueenAnt</code> object.  Saves this location if
     * it doesn't already have one.
     * @param qLoc the location of the queen.
     */
    public void shareQueenLocation(Location qLoc) {
        if(queenLocation == null) queenLocation = qLoc;
    }

    /**
     * Processes each of the neighboring Ant Farm actors.
     * Implemented to get food from <code>Cake and Cookie</code> actors,
     * give food to <code>QueenAnt</code> actors, and to share locations
     * with other <code>WorkerAnt</code> actors.<br />
     * Precondition: All objects in <code>actors</code>
     * are contained in the same grid as this critter.
     * @param actors the actors to be processed
     */
    @Override
    public void processActors(ArrayList<Actor> actors) {
        for(Actor actor : actors) {
            if(actor instanceof Processable) {
                ((Processable) actor).process(this);
            }
        }
    }

    /**
     * Gets the possible locations for the next move.
     * Implemented to return the empty neighboring locations
     * that are roughly in the direction of the current goal
     * (food or queen).  Calls getDesiredDirection to get the
     * direction to the goal.  Then it considers locations which
     * are in that direction or +- Location.HALF_RIGHT degrees.<br />
     * Postcondition: The locations must be valid in the grid
     * of this critter.
     * @return a list of possible locations for the next move
     */
    @Override
    public ArrayList<Location> getMoveLocations() {
        var locations = new ArrayList<Location>();
        
        for(int dir : DIRECTIONS) {
            Location next = getLocation().getAdjacentLocation(getDesiredDirection() + dir);
            
            if(getGrid().isValid(next)) {
                locations.add(next);
            }
        }
        
        return locations;
    }

    /**
     * Moves this critter to the given location, sets its direction,
     * and sets its color (red = has food, black = does not have food).
     * Implemented to call moveTo.<br />
     * Precondition: <code>loc</code> is valid in the grid of this critter
     * @param loc the location to move to (must be valid)
     */
    @Override
    public void makeMove(Location loc) {
        if(loc == getLocation() || !getGrid().isValid(loc) || getGrid().get(loc) != null) {
            setDirection((Math.random() > 0.4) ? DIRECTIONS[1] : DIRECTIONS[2]);
        } else {
            int dir = getLocation().getDirectionToward(loc);
            moveTo(loc);
            setDirection(dir);
        }
        
        if(foodQuantity > 0) {
            setColor(Color.red);
        } else {
            setColor(Color.black);
        }
    }

    /**
     * Returns the direction that the ant wants to go.
     * @return the direction to the queen (if there is food
     * and a queen's location is known); the direction to the
     * food (if there is no food and a food's location is known);
     * the current ant's direction otherwise.
     */
    private int getDesiredDirection()
    {
        if(queenLocation != null && foodQuantity > 0) {
            return getLocation().getDirectionToward(queenLocation);
        } else if(foodLocation != null && foodQuantity == 0) {
            return getLocation().getDirectionToward(foodLocation);
        } else {
            return getDirection();
        }
    }

    /**
     * Creates a string that describes this actor.
     * @return a string with the <code>Actor</code> information
     * plus the current amount of food and any known
     * <code>Food</code> and <code>QueenAnt</code> locations.
     */
    @Override
    public String toString()
    {
        return super.toString() + ", fdQty=" + foodQuantity + ", foodLoc=" + foodLocation + ", queenLoc=" + queenLocation;
    }
    
    
    @Override
    public void removeSelfFromGrid() {
        System.out.println("Removing self from grid: " + toString());
        super.removeSelfFromGrid();
    }
}
