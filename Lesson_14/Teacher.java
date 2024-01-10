package Lesson_14;


/**
 * Write a description of class Teacher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teacher extends Person {
    protected String subject;
    protected double yearlySalary;
    
    public Teacher(String name, int age, String gender, String subject, double yearlySalary) {
        super(name, age, gender);
        this.subject = subject;
        this.yearlySalary = yearlySalary;
    }
    
    
    
    @Override
    public String toString() {
        return name + ", age: " + age + ", gender: " + gender + ", Subject: " + subject + ", Salary: ";
    }
}
