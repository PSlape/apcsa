package Gridworld;
import java.util.ArrayList;


/**
 * Write a description of class DancingBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DancingBug extends BetterBug {
    private int[] turns;
    private int iteration;    
    public DancingBug(int... turns) {
        super();
        this.turns = turns;
        iteration = 0;
    }
    
    public DancingBug(ArrayList<Integer> array) {
        super();
        array.trimToSize();
        turns = new int[array.size()];
        for(int i = 0; i < turns.length && i < array.size(); i++) {
            turns[i] = array.get(i);
        }
    }
    
    public void act() {
        for(int i = 0; i < turns[iteration]; i++) {
            turn();
        }
        iteration++;
        if(iteration == turns.length) iteration = 0;
        
        if(canMove()) move();
    }
}
