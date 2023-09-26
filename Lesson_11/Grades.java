package Lesson_11;

import chn.util.ConsoleIO;
import java.util.ArrayList;


/*
 * Name: Peyton Slape
 * Lab: 11.1
 * Description: Sees if a student is eligible for extracurriculars.
 * Purpose: Practice using switch statements.
 */

public class Grades {
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        
        String rawInput = "";
        int inGrade;
        int i = 0;
        ArrayList<Integer> grades = new ArrayList<Integer>();
        
        System.out.println("Enter letter grades, enter non-grade to stop");
        
        
        while(true) {
            System.out.print("Grade " + (++i) + ": ");
            rawInput = cons.readToken().toLowerCase();
            inGrade = toNumber(
                cons.readToken().toLowerCase().charAt(0)
            );
            
            if(inGrade == -1) break;
            
            grades.add(inGrade);
        }
        
        Status canPartake = isEligible(grades);
        System.out.println(canPartake.reason);
    }
    
    private static int toNumber(char letter) {
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
    
    private static Status isEligible(ArrayList<Integer> grades) {
        double gpa = getGPA(grades);
        
        if(grades.size() < 4) return new Status(false, "Ineligible, taking less than 4 classes.");
        
        if(grades.contains(0)) {
            if(gpa >= 2.0) return new Status(false, "Ineligible, gpa above 2.0 but has F grade");
            if(gpa < 2.0) return new Status(false, "Ineligible, gpa below 2.0 and has F grade");
        } 
        else return new Status(true, "Eligible");
        
        return new Status(false, "Error found");
    }
    
    private static double getGPA(ArrayList<Integer> grades) {
        double total = 0;
        for(int grade : grades) {
            total += grade;
        }
        return total / (double) grades.size();
    }
}

class Status {
    boolean isEligible;
    String reason;
    
    public Status(boolean isEligible) {
        this.isEligible = isEligible;
        reason = "No reason provided.";
    }
    public Status(boolean isEligible, String reason) {
        this.isEligible = isEligible;
        this.reason = reason;
    }
}