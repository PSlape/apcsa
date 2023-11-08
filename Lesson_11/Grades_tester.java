package Lesson_11;


/**
 * Write a description of class Greades_tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import chn.util.ConsoleIO;
import java.util.ArrayList;

public class Grades_tester
{
     public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();       
        String rawInput = "";
        int inGrade;
        int i = 0;
        ArrayList<Integer> grades = new ArrayList<Integer>();
        
        System.out.println("Enter letter grades, enter done to end grade input.");
        
        
        while(true) {
            System.out.print("Grade " + (++i) + ": ");
            rawInput = cons.readToken().toLowerCase();
            
            if(rawInput.equalsIgnoreCase("done")) break;
            
            inGrade = Grades.toNumber(
                rawInput.charAt(0)
            );
            
            if(inGrade == -1) {
                System.out.println("Input error, please input a valid letter grade.");
                continue;
            }
            grades.add(inGrade);
        }
        
        Status canPartake = Grades.isEligible(grades);
        System.out.println(canPartake.reason);
    }
}
