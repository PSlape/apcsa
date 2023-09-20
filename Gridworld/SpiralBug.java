package Gridworld;
import info.gridworld.actor.Bug;

public class SpiralBug extends BetterBug {
    private int steps, sideLength;
    
    public SpiralBug() {
        this(1);
    }
    public SpiralBug(int initialLength) {
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
