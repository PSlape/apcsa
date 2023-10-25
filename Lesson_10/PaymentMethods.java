package Lesson_10;

import chn.util.ConsoleIO;

/**
 * Provides functionality to the Payments class for Lab 10.2
 *
 * @author Peyton Slape
 * @version 10/19/23
 */
public class PaymentMethods
{
    private static ConsoleIO cons = new ConsoleIO();
    
    /**
     * Prints out a rounded number to a certain space
     * 
     * @param num       The number to round
     * @param spaces    The number of spaces to round to
     * 
     * @return The rounded number
     */
    public static double roundTo(double num, int spaces) {
        int numRound = (int) (num *  Math.pow(10, spaces));
        return (double) numRound / Math.pow(10, spaces);
    }
    
    /**
     * Prints out a statement then recieves input
     * 
     * @param in    The line to print out. 
     * 
     * @return      The input using ConsoleIO
     */
    public static double getInput(String in) {
        System.out.print(in);
        return cons.readDouble();
    }
}
