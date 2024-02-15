package Lesson_29;


/*
 * Name: Peyton Slape
 * Lab: 29.1
 * Date: 2/15/24
 * Purpose: Practice using interfaces and abstract methods
 * Description: A Chicken
 */
public class Chick implements Animal {
    protected String myType, mySound1, mySound2;
    
    public Chick(String type, String sound1, String sound2) {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }
    
    public String getSound() {
        return (Math.random() >= 0.5) ? mySound1 : mySound2;
    }
    
    public String getType() {
        return myType;
    }
}
