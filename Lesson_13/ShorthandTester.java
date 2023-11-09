package Lesson_13;

import chn.util.ConsoleIO;

/**
 * Write a description of class ShorthandTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShorthandTester {
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        System.out.println("Welcome to the Shorthand Message Generator!\n");
        
        while(true) {
            System.out.print("Enter a message: ");
            String in = cons.readLine();
            if(in.equalsIgnoreCase("q")) break;
            System.out.println(ShorthandMethods.convertToShort(in) + "\n");
        }
        
    }
}
