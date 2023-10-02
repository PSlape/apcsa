package Lesson_7;
import java.lang.Double;

public class RectangleTest {
    public static void main(String[] args) {
        
        Rectangle r1 = new Rectangle(-200, 200, 180, 50);
        
        r1.draw();
        
            // Draws the width below the shape
        r1.drawString("Width = " + r1.getWidth(), r1.getX(), 
            r1.getY() - 15
        );
        
            // Draws the height to the right of the shape
        r1.drawString("Height = " + r1.getHeight(), 
            r1.getX() + r1.getWidth() + 5, 
            r1.getY() + (r1.getHeight() / 2)
        );
            // Draws the area in the center of the shape
        r1.drawString("Area = " + r1.getArea(), r1.getX() + 1, 
            r1.getY() + (r1.getHeight() / 2)
        );
            // Draws the perimeter above the shape
        r1.drawString("Perimeter = " + r1.getPerimeter(), r1.getX(),
            r1.getY() + r1.getHeight() + 5
        );
        
            // Creates the second rectangle using the copy constructor
        Rectangle rect = new Rectangle(r1);
        rect.setPos(0,0);
        
            // Sets the values for the rectangle to change each iteration of the loop
        double width = rect.getWidth();
        double turnInc = 36; 
        double widthInc = width / 15.0;
        
            // Creates a new lambda function for forLoop()
        Function myFunction = () -> {
            rect.draw();
            rect.setDirection(rect.getDirection() - turnInc);
            rect.setWidth(rect.getWidth() - widthInc);
        };
        
            // Calls the custom for loop
        forLoop(9, 0, myFunction);
    }
    public static void forLoop(int endCount, int counter, Function function) {
        function.runFunction(); // Runs the function inside of the 
        if(counter < endCount) forLoop(endCount, counter + 1, function);
    }
    
    public interface Function {
        void runFunction();
    }
}

