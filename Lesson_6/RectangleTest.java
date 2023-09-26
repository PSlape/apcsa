package Lesson_6;

// L.A.6.2
import java.lang.Double;

public class RectangleTest {
    public static void main() {
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
}