package Gridworld;

import info.gridworld.actor.ActorWorld;

/**
 * Write a description of class TeleBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TeleBug extends BetterBug {
    private ActorWorld[] worlds;
    private int currentWorld;
    private int iterations;
    
    public TeleBug(ActorWorld... worlds) {
        super();
        this.worlds = worlds;
        currentWorld = 0;
        iterations = 0;
    }
    
    public void act() {
        if(iterations % 2 == 0) {
            if(canMove()) {
                GridController.transpose(worlds[currentWorld % worlds.length], this, getLocation());
                move();
                currentWorld++;
            } else {
                for(double i = 0.0; i < Math.random(); i += 0.1) {
                    turn();
                }
                
            }
        }
        iterations++;
    }
}
