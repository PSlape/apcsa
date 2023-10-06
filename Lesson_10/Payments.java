package Lesson_10;

import chn.util.ConsoleIO;

/**
 * Write a description of class Payments here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payments {
    private static double principal, annualRate, payment;
    private static ConsoleIO cons = new ConsoleIO();
    public static void main(String[] args) {
        principal = getInput("Enter your amount borrowed: ");
    }
    private static double getInput(String in) {
        System.out.print(in);
        return cons.readDouble();
    }
}
