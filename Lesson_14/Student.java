package Lesson_14;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person {
    protected final String studentID;
    protected double gpa;
    
    public Student(String name, int age, String gender, String studentID) {
        super(name, age, gender);
        this.studentID = studentID;
        
        gpa = 0.0;
    }
    
    @AvoidUse
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
    
    public void setGPA(int... grades) {
        int total = 0;
        int gradeCount = 0;
        for(int grade : grades) {
            total += grade;
            gradeCount++;
        }
        gpa = total / gradeCount;
    }
}
