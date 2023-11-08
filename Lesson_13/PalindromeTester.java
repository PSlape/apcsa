package Lesson_13;

import chn.util.ConsoleIO;

/**
 * Write a description of class PalindromeTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PalindromeTester
{
    public static void main(String[] args) {
        
        ConsoleIO cons = new ConsoleIO();
        
        while(true) {
            System.out.print("Enter a string, or 0 to exit: ");
            String in = cons.readLine();
            if(in.equals("0")) break;
            System.out.println(
                "The output of the palindrome test is: "
                + PalindromeMethods.checkPalindrome(in) + "\n"
            );
        }
    }
}
