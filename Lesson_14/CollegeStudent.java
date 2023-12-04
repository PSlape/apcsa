package Lesson_14;


/**
 * Write a description of class CollegeStudnet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CollegeStudent extends Student{
    protected String major;
    protected int year;
    
    public CollegeStudent(String name, int age, String gender, String studentID, double gpa, String major, int year) {
        super(name, age, gender, studentID, gpa);
        this.major = major;
        this.year = year;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getMajor() {
        return major;
    }
    
    public int getYear() {
        return year;
    }
    
    @Override
    public String toString() {
        return name + ", " + age + ", " + gender + ", " + studentID + ", " + major + ", " + year;
    }
}
