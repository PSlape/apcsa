package Lesson_11;

import chn.util.ConsoleIO;
import java.util.ArrayList;

/*
 * Name: Peyton Slape
 * Lab: 11.1
 * Description: Sees if a student is elig//ible for extracurriculars.
 * Purpose: Practice using switch statements.
 */

public class Grades {
    public static int toNumber(char letter) {
        if(Character.isUpperCase(letter)) 
            letter = Character.toLowerCase(letter);
        
        switch(letter) {
            case 'a':
                return 4;
            case 'b':
                return 3;
            case 'c':
                return 2;
            case 'd':
                return 1;
            case 'f':
                return 0;
            default:
                return -1;
        }
    }
    
    public static Status isEligible(ArrayList<Integer> grades) {
        double gpa = getGPA(grades);
        
        if(grades.size() < 4) return new Status(false, "Ineligible, taking less than 4 classes.");
        
        if(grades.contains(0)) {
            if(gpa >= 2.0) return new Status(false, "Ineligible, gpa above 2.0 but has F grade");
            if(gpa < 2.0) return new Status(false, "Ineligible, gpa below 2.0 and has F grade");
        } else return new Status(true, "Eligible");
        
        return new Status(false, "Error found");
    }
    
    public static double getGPA(ArrayList<Integer> grades) {
        double total = 0;
        for(int grade : grades) {
            total += grade;
        }
        return total / (double) grades.size();
    }
}

