package Lesson_6;

import chn.util.ConsoleIO;
import apcslib.Format;

public class GPACalculator {
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();

        System.out.println("Welcome to my GPA Calculator");
        System.out.println("First we need a few details!");
        
        System.out.println("Enter Name: ");
        String name = cons.readLine();
        
        System.out.println("Enter ID");
        int id = cons.readInt();
        System.out.println(" ");
        
        Student stud = new Student(name, id);
        
        System.out.println("Initial GPA: " + Format.right(stud.getGPA(), 5, 2));
        
        System.out.print("\nEnter grade 1: ");
        stud.addGrade(cons.readInt());
        System.out.println("GPA: " + Format.right(stud.getGPA(), 5, 2));
        System.out.println(" ");

        System.out.print("\nEnter grade 2: ");
        stud.addGrade(cons.readInt());
        System.out.println("GPA : " + Format.right(stud.getGPA(), 5, 2));
        System.out.println(" ");

        System.out.print("\nEnter grade 3: ");
        stud.addGrade(cons.readInt());
        System.out.println("GPA: " + Format.right(stud.getGPA(), 5, 2));
        System.out.println(" ");

        System.out.println("\nFinal GPA: " + Format.right(stud.getGPA(), 5, 2));
    }
}

class Student {
    private String name;
    private int id;
    private int pointSum, classCount;
    private double gpa;

    public Student() {
        this("test", 123456);
    }
    public Student(String name, int id) {
        this(name, id, 0, 0);
    }
    public Student(String name, int id, int pointSum, int classCount) {
        this.name = name;
        this.id = id;
        this.pointSum = pointSum;
        this.classCount = classCount;
    }
    void addGrade(int grade) {
        pointSum += grade;
        classCount++;
        gpa = pointSum / classCount;
    }
    double getGPA_raw() {
        return gpa;
    }
    double getGPA() {
        return gpa;
    }
}