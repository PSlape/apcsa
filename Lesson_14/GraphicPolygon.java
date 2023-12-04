package Lesson_14;

import Lesson_7.RegularPolygon;
import apcslib.DrawingTool;
import apcslib.SketchPad;

/**
 * Write a description of class GraphicPolygon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphicPolygon extends RegularPolygon {
    private DrawingTool dw = new DrawingTool(new SketchPad(400, 400));
    private double x, y;
    
    /**
     * Initializes a polygon
     * 
     * @param numSides The number of sides
     * @param sideLength The length of each side
     */
    public GraphicPolygon(int numSides, double sideLength) {
        super(numSides, sideLength);
        x = 0;
        y = 0;
    }
    
    public GraphicPolygon(int numSides, double sideLength, double x, double y) {
        super(numSides, sideLength);
        this.x = x;
        this.y = y;
    }
    
    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw() {
        dw.up();
        dw.move(x, y + getApothem());
        dw.down();
        for(int i = 0; i < sideCount; i++) {
            System.out.println("Turning " + getVertexAngle() + " degrees");
            dw.turnRight(180-getVertexAngle());
            dw.forward(sideLength);
        }
    }
}
