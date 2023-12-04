package Lesson_15;
import java.util.ArrayList;

/**
 * Write a description of class Fibonacci here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibonacciMethods {
    public static int getNumber(int pos) {
        if(pos < 0) return -1;
        else if(pos == 0) return 0;
        else if(pos == 1) return 1;
        
        return getNumber(pos-1) + getNumber(pos-2);
    }
    
    public static int getNumber_nonRec(int pos) {
        if(pos < 0) return -1;
        else if(pos == 0) return 0;
        else if(pos == 1) return 1;
        
        int n_1 = 0;
        int n_2 = 1;
        int n_pos = 0;
        
        for(int i = 2; i <= pos; i++) {
            n_pos = n_1 + n_2;
            n_1 = n_2;
            n_2 = n_pos;
        }
        return n_pos;
    }
    
    public static int mult(int a, int b) {
        if(a == 0 || b == 0) return 0;
        return a + mult(a, b-1);
    }
}