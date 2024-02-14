package Gridworld;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/*
 * Name: Peyton Slape
 * Date: 1/26/24
 * Lab: Gridworld
 * Description: The world of grids.
 * Purpose: To practice using subclasses and premade libraries.
 */
public class ZBug extends BetterBug {
    private final int length;
    private int steps, stage;
    
    public ZBug() {
        this(4);
    }
    public ZBug(int len) {
        length = len;
        
        steps = 0;
        stage = 1;
        setDirection(90);
    }
    
    public void act() {
        if(steps < length && canMove()) {
            move();
            steps++;
        } else if(steps == length) {
            if(stage == 1) {
                turnRight(135);
                stage = 2;
                steps = 0;
            } else if(stage == 2) {
                turnLeft(135);
                stage = 3;
                steps = 0;
            }
        }
    }
}
