package Lesson_9;
import chn.util.ConsoleIO;
import apcslib.Format;

/**
 * Name: Peyton Slape
 * Lab: 9.2
 * Description: 
 */
public class FunLoop {
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        
        
        System.out.println("MAGIC SQUARES \n Enter the number of perfect squares you want to see: ");
        int n = cons.readInt();
        int count = 0;
        for(int num = 1; count < n; num++) {
            if(checkIfPerf(num)) {
                System.out.println("Result " + (count + 1) + ": " + Math.pow(num, 2));
                count++;
            }
        }
        
        String revInt = "";
        while(!revInt.equalsIgnoreCase("next")) {
            System.out.print("\nREVERSING THE INTEGER \n Enter an integer: ");
            revInt = cons.readToken();
            System.out.println("Result: " + reverse(revInt));
        }
        
        System.out.print("\nLEAST COMMONEnter two numbers, seperated by a space: ");
        System.out.println("Result: " + returnLCM(cons.readInt(), cons.readInt()));
    }
    private static boolean checkIfPerf(int base) {
        int power = (int) Math.pow(base, 2);
        int sum = 0;
        for(int i = 0; sum < power; i++) {
            sum += i;
        }
        if(sum == power) {
            return true;
        } else {
            return false;
        }
    }
    private static String reverse(String str) {
        String out = "";
        for(int i = str.length()-1; i >= 0; i--) {
            out += str.charAt(i);
        }
        return out;
    }
    private static int returnLCM(int a, int b) {
        if((a % b) != 0 && (b % a) != 0) {
            return a * b;
        } else if(b % a == 0) {
            return b;
        } else {
            return a;
        }
    }
}
