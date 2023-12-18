package Lesson_18;

import java.util.*;
import java.util.function.*;

/*
 * Name: Peyton Slape
 * 
 */
public class Rolling {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rolls = new ArrayList<ArrayList<Integer>>();
        
        // Lambda function which returns an ArrayList of the dice rolls
        IntFunction<ArrayList<Integer>> randRoll = (rollNum) -> {
            ArrayList<Integer> rolla = new ArrayList<Integer>();
            for(int i = 0; i < rollNum; i++) 
                rolla.add((int) (Math.random() * 6.0) + 1);
            return rolla;
        };
        
        int count = 1;
        while(true) {
            ArrayList<Integer> currentRoll = randRoll.apply(3);
            System.out.println("Trial " + count + ": " + currentRoll);
            if(!(currentRoll.get(0) == currentRoll.get(1) || currentRoll.get(0) == currentRoll.get(2) || currentRoll.get(1) == currentRoll.get(2))) {
                System.out.println("Took " + count + " rolls.");
                System.exit(0);
            }
            count++;
        }
    }
}
