package Daily;


/**
 * Write a description of class PreTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import chn.util.ConsoleIO;

public class PreTest
{
    public static void main(String[] args) {
        System.out.print("Input a word: ");
        String in = new ConsoleIO().readToken();
        System.out.println("Your ASCII value is: " + (int) in.charAt(0));
    }
}
