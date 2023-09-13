package Lesson_6;

import java.lang.Math;
import chn.util.ConsoleIO;

public class GPACalculator {
    public static void gpa() {
        ConsoleIO cons = new ConsoleIO();

        System.out.println("Welcome to our GPA Calculator");
        System.out.println("First we need a few details!");
        
        System.out.println("Enter Name: ");
        String name = cons.readLine();
        
        System.out.println("Enter ID");
        int id = cons.readInt();
        System.out.println(" ");
        

        Student stud = new Student(name, id);
        
        System.out.println("Initial GPA: " + stud.getGPA());
        
        System.out.println("Enter grade 1");
        stud.addGrade(cons.readInt());
        System.out.println(stud.getGPA());
        System.out.println(" ");

        System.out.println("Enter grade 2");
        stud.addGrade(cons.readInt());
        System.out.println(stud.getGPA());
        System.out.println(" ");

        System.out.println("Enter grade 3");
        stud.addGrade(cons.readInt());
        System.out.println(stud.getGPA());
        System.out.println(" ");

        System.out.println("Final GPA: " + stud.getGPA());
    }
}

class Student {
    String name;
    int id;
    int pointSum, classCount;
    double gpa;

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
        this.pointSum += grade;
        this.classCount += 1;
        this.gpa = pointSum / classCount;
        System.out.println(this.gpa);
    }
    double getGPA_raw() {
        return this.gpa;
    }
    double getGPA() {
        return (double) Math.round(this.gpa * 100) / 100;
    }
}