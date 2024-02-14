package Gridworld;
import info.gridworld.actor.Bug;

/*
 * Name: Peyton Slape
 * Date: 1/26/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class SpiralBug extends BetterBug {
    private int steps, sideLength;
    
    public SpiralBug() {
        this(1);
    }
    public SpiralBug(int initialLength) {
        setColor(java.awt.Color.blue);
        steps = 0;
        sideLength = initialLength;
    }
    
    public void act() {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else if(steps >= sideLength) {
            turn();
            turn();
            steps = 0;
            sideLength++;
        } else {
            turn();
            turn();
            steps = 0;
        }
    }
}
