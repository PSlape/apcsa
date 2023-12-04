package Lesson_14;


/**
 * Write a description of class Teacher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teacher extends Person {
    protected String subject;
    protected double salary;
    
    public Teacher(String name, int age, String gender, String subject, double salary) {
        super(name, age, gender);
        this.subject = subject;
        this.salary = salary;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return name + ", " + age + ", " + gender + ", " + subject + ", " + salary;
    }
}
