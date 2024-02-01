package Gridworld;


/**
 * Write a description of class DancingBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DancingBug extends BetterBug {
    private int[] turns;
    
    public DancingBug(int... turns) {
        super();
        this.turns = turns;
    }
    
    public void act() {
        for(int i = 0; i < turns[(int) (Math.random() * (turns.length - 1.0))]; i++) {
            turn();
        }
        if(canMove()) move();
    }
}
