package Lesson_15;

import chn.util.ConsoleIO;

/**
 * Write a description of class RevRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
                System.out.println(ReverseMethods.recursive(in) + "\n\n");
            }
        }
    }
}
