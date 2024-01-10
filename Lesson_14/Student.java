package Lesson_14;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person
{
    protected final String id;
    protected double gpa;
    
    public Student(String name, int age, String gender, String id, double gpa) {
        super(name, age, gender);
        this.id = id;
        this.gpa = gpa;
    }
    
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
    
    public void setGPA(int... grades) {
        int total = 0;
        for(int grade : grades) {
            total += grade;
        }
        gpa = total / grades.length;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    @Override
    public String toString() {
        return name + ", age: " + age + ", gender: " + gender + 
        ", Student ID: " + id + ", GPA: " + gpa;
    }
}
