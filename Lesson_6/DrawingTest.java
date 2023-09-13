package Lesson_6;

// L.A.6.2 and L.A.7.3
import java.lang.Double;

public class DrawingTest {
    public static void main_lab6() {
        Rectangle r1 = new Rectangle(-60,60,60,60);
        Rectangle r2 = new Rectangle(0,60,60,60);
        Rectangle r3 = new Rectangle(60,60,60,60);
        Rectangle r4 = new Rectangle(-60,0,60,60);
        Rectangle r5 = new Rectangle(0,0,60,60);
        Rectangle r6 = new Rectangle(60,0,60,60);
        Rectangle r7 = new Rectangle(-60,-60,60,60);
        Rectangle r8 = new Rectangle(0,-60,60,60);
        Rectangle r9 = new Rectangle(60,-60,60,60);
        
        r1.draw();
        r2.draw();
        r3.draw();
        r4.draw();
        r5.draw();
        r6.draw();
        r7.draw();
        r8.draw();
        r9.draw();
    }
    public static void main_lab7() {
        Rectangle rect = new Rectangle(0, 0, 10, 20);
        for(int i = 0; i < 5; i++) {
            rect.setDirection(rect.getDirection() + 36);
            rect.setHeight(rect.getHeight() + 5);
            rect.draw();
        }
        
        Rectangle r1 = new Rectangle(rect);
        
        r1.setX(-200);
        r1.setY(200);
        
        r1.draw();
        r1.drawString("Width = " + r1.getWidth(), -200, 150);
        r1.drawString("Height = " + r1.getHeight(), -200, 130);
        r1.drawString("Area = " + r1.getArea(), -200, 110);
        r1.drawString("Perimeter = " + r1.getPerimeter(), -200, 90);
    }
}