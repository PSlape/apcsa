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
    
    public Student(String name, int age, String gender, String studentID, double gpa) {
        super(name, age, gender);
        this.studentID = studentID;
        this.gpa = gpa;
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
    
    @Override
    public String toString() {
        return name + ", " + age + ", " + gender + ", " + studentID;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public String getStudentID() {
        return studentID;
    }
}
