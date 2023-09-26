package gridworld;
import info.gridworld.actor.Bug;

public class CircleBug extends BetterBug {
    private int steps, sideLength;
    
    public CircleBug() {
        this(1);
    }
    public CircleBug(int initialLength) {
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
            steps = 0;
        } else {
            turn();
            steps = 0;
        }
    }
}