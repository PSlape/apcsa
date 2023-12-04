package Random_Stuff.USACO;

import java.util.*;
import chn.util.ConsoleIO;

/**
 * Write a description of class CowCollege here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CowCollege {
    private static final ArrayList<Integer> inputs = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        ConsoleIO input = new ConsoleIO();
        
        int numInputs = input.readInt();
        int lowest = 0;
        for(int i = 1; i <= numInputs; i++) {
            int current = input.readInt();
            if(current < lowest) lowest = current;
            inputs.add(current);
        }
        
        long lastTotal = 0;
        long currentTotal = 0;
        
        int price = lowest;
        while(true) {
            currentTotal = calculateTotal(price);
            if(currentTotal < lastTotal) {
                break;
            }
            lastTotal = currentTotal;
            price++;
        }
        
        System.out.println(lastTotal + " " + (price-1));
    }
    
    static long calculateTotal(int price) {
        long total = 0;
        for(int budget : inputs) {
            if(price <= budget) {
                total += price;
            }
        }
        return total;
    }
}
