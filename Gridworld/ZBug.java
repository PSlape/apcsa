package Gridworld;

import info.gridworld.actor.Bug;

public class ZBug extends BetterBug{
    private int length, steps, loopCount;
    
    public ZBug() {
        this(4);
    }
    public ZBug(int len) {
        length = len;
        loopCount = 0;
        setDirection(90);
    }
    
    public void act() {
        if(steps < length && canMove() && loopCount < 3) {
            move();
            steps++;
        } else if(steps >= length && loopCount < 3) {
            steps = 0;
            loopCount++;
        } 
    }
}
