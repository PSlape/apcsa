package Lesson_29;


/*
 * Name: Peyton Slape
 * Lab: 29.1
 * Date: 2/15/24
 * Purpose: Practice using interfaces and abstract methods
 * Description: A Cow with a Name
 */
public class NamedCow extends Cow {
    protected String myName;
    
    public NamedCow(String type, String name, String sound) {
        super(type, sound);
        myName = name;
    }
    
    public String getSound() {
        return mySound;
    }
    
    public String getType() {
        return myType;
    }
    
    public String getName() {
        return myName;
    }
}
