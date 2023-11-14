package Lesson_13;

import chn.util.ConsoleIO;
import java.util.StringTokenizer;

/**
 * Write a description of class PigLatinTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PigLatinTester
{
    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        String inLine = new ConsoleIO().readLine();
        StringTokenizer token = new StringTokenizer(inLine);
        
        System.out.print("Output: ");
        while(token.hasMoreTokens()) {
            System.out.print(PigLatinMethods.toPigLatin(token.nextToken()) + " ");
        }
    }
}
