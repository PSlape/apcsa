package Lesson_15;

import chn.util.ConsoleIO;

/*
 * Name: Peyton Slape
 * Date: 11/25/23
 * Lab: 15.2
 * Purpose: Recursion practice
 * Description: Reverse String Recursively
 */
public class RevRunner {
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        System.out.println("Enter a string to reverse or enter quit to stop.\n\n");
        while(true) {
            String in = cons.readToken();
            if(in.toLowerCase().charAt(0) == 'q') {
                break;
            } else {
                System.out.println("Output: " + ReverseMethods.recursive(in) + "\n\n");
            }
        }
    }
}
