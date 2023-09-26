package Lesson_7;

//L.A.7.3
import java.lang.Double;

public class RectangleTest {
    public static void main(String[] args) {
        
        Rectangle r1 = new Rectangle(0, 0, 30, 10);
        
        r1.setX(-200);
        r1.setY(200);
        
        r1.draw();
        r1.drawString("Width = " + r1.getWidth(), -200, 150);
        r1.drawString("Height = " + r1.getHeight(), -200, 130);
        r1.drawString("Area = " + r1.getArea(), -200, 110);
        r1.drawString("Perimeter = " + r1.getPerimeter(), -200, 90);
        
        
        Rectangle rect = new Rectangle(r1);
        rect.setPos(0,0);
        
        double width = rect.getWidth();
        for(int i = 0; i < 5; i++) {
            rect.draw();
            rect.setDirection(rect.getDirection() - 36);
            rect.setWidth(rect.getWidth() - (width / 15));

        }
        
        
    }
}