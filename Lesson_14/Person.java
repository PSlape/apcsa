package Lesson_14;
/*
 * Name: Peyton Slape
 * Lab: 14.1
 * Description: A class which represents a person
 * Purpose: Practice inheritance
 */

/**
 * Person
 *
 * @author Peyton Slape
 * @version 11/27/23
 */
public class Person
{
    protected String name;
    protected int age;
    protected String gender;
    
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public String toString() {
        return name + ", " + age + ", " + gender;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
}
