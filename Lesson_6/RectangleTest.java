package Lesson_6;

/*
 * Name: Peyton Slape
 * Lab: 6.2
 * Description: Creates a grid of rectangles
 * Purpose: Use classes to create objects.
 */
import java.lang.Double;

public class RectangleTest {
    public static void main() {
        Rectangle r1 = new Rectangle(-60,60,60,60);
        Rectangle r2 = new Rectangle(0,60,60,60); // 
        Rectangle r3 = new Rectangle(60,60,60,60);
       
        r1.draw();
        r2.draw();
        r3.draw();
        
        r1.setPos(-60, 0);
        r2.setPos(0,0);
        r3.setPos(60, 0);
        
        r1.draw();
        r2.draw();
        r3.draw();
        
        r1.setPos(-60, -60);
        r2.setPos(0, -60);
        r3.setPos(60,-60);
        
        r1.draw();
        r2.draw();
        r3.draw();
    }
}