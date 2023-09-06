
import apcslib.*;

/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * Lab: L.A.6.2
 */
public class Rectangle {
    private static DrawingTool dw = new DrawingTool(new SketchPad(500,500));
    
    private double perim, area, x, y, width, height;
    
    public Rectangle()
    {
     this(0,0,0,0);   
    }
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public double getPerimeter() {
        return perim;
    }
    public double getArea() {
        return area;
    }
    public void draw() {
        dw.up(); // disables drawing mode
        dw.move(x-width, y-height); // moves to the bottom left corner of the shape // gets the direction the drawing tool is facing
        dw.setDirection(90); // sets the direction to 90
        dw.down();
        
        int sideCounter = 0;
        while(sideCounter < 4) {
            if(sideCounter % 2 == 0) {
                dw.move(width);
            } else {
                dw.move(height);
            }
            dw.turnRight(90);
            sideCounter++;
        }
    }
}
