package Gridworld;
import java.util.ArrayList;

import java.awt.Color;

/**
 * Write a description of class DancingBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DancingBug extends BetterBug {
    private static final int[] DEF_TURNS = {2, 5, 3, 1, 3};
    private int[] turns;
    private int iteration;    
    public DancingBug(int... turns) {
        super();
        setColor(Color.magenta);
        this.turns = turns;
        iteration = 0;
    }
    
    public DancingBug(ArrayList<Integer> array) {
        super();
        setColor(Color.magenta);
        array.trimToSize();
        turns = new int[array.size()];
        for(int i = 0; i < turns.length && i < array.size(); i++) {
            turns[i] = array.get(i);
        }
    }
    
    public DancingBug() {
        super();
        setColor(Color.magenta);
        turns = DEF_TURNS;
        iteration = 0;
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
