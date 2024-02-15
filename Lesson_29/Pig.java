package Lesson_29;


/*
 * Name: Peyton Slape
 * Lab: 29.1
 * Date: 2/15/24
 * Purpose: Practice using interfaces and abstract methods
 * Description: A pig
 */
public class Pig implements Animal {
    protected String myType, mySound;
    
    public Pig(String type, String sound) {
        myType = type;
        mySound = sound;
    }
    
    public String getSound() {
        return mySound;
    }
    
    public String getType() {
        return myType;
    }
}
