package Lesson_14;


/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person {
    protected final String name, gender;
    protected int age;
    
    public Person(String name, int age, String gender) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public String toString() {
        return name + ", age: " + age + ", gender: " + gender;
    }
    
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }
}
