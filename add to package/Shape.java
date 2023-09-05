import apcslib.*;
import java.lang.Math;

public abstract class Shape {
    /* 
    The Shape class is created in order to solve several labs found in the AP Computer Science A course.
    It is specfically created for the following labs, but can be used wherever applicable.
        L.A.6.2 - Rectangle
        L.A.7.2 - Polygon
        L.A.7.3 - Rectangle Methods

    The following variables are intitiallized for use in subclass constructors and other methods within this class. 
    
    xLoc: The location in which the center of the shape will be on the x-axis once drawn.
    yLoc: The location in which the center of the shape will be on the y-axis once drawn.
    rad: The radius of the shape, or the distance from the center of the shape to one of the corners of the shape.
    apo: The apothem of the shape, or the distance from the center of the shape to the center of one of the sides.
    width: The width of the shape. To only be used for rectangles or squares. This variable is set to null within this class in order to be used for logic inside of the getArea() method.
    length: The length of the shape. To only be used for rectangles or squares. This variable is set to null within this class in order to be used for logic inside of the getArea() method.
    sideLength: The length of one side of the shape. To only be used for regular polygons. This variable is set to null within this class in order to be used for logic inside of the getArea() method.
    sideCount: The number of sides on a shape. To only be used for regular polygons.
    
    Any of these variables can be used or not used. 
    Certain methods may not function correctly without certain variables defined.
        
    */
    private double xLoc, yLoc, rad, apo;

        // used to see whether width / height is used or if side lengths are used.
    private double width = null; 
    private double height = null; 
    private double sideLength = null;

    private int sideCount;

    protected static DrawingTool dw = new DrawingTool(new SketchPad(500,500));

        // Abstract methods are given contents by their subclasses
    public abstract void draw(); 
    public abstract double getPerimeter();

    public double getArea() {
        if(this.sideLength != null) { // if sideLength is being used, it uses the formula provided by L.A.7.2 - Polygon
            return (this.sideLength * Math.pow(rad, 2) * Math.sin((2 * Math.PI) / this.sideCount)) / 2;
        } else if(width != null && height != null) { // Uses standard quadrilateral area formula if sideLength is not being used.
            return width * height;
        } else { // returns null if neither side length or width/height are used.
            return null;
        }
    }

    protected void calcRad() {
        // This method calculates the radius from the center of the shape to the corner of the outer shape.
        return (1 / Math.sin(Math.PI / this.sideCount)) / 2; 
    }

    protected void calcApo() {
        // This method calculates the distance from the center of the shape to the middle of one of the sides.
        return (1 / Math.cot(Math.PI / this.sideCount)) / 2;
    }

    public double vertexAngle() {
        // This method calculates the size of the internal angles of a regular polygon
        return ((this.sideCount - 2) / this.sideCount) * 180;
    }

    public double getSideCount() {
        /* Returns the private sideCount variable from the object it is called from. 
            This variable represents the number of sides in the polygon. */
        return this.sideCount;
    }
    
    public double getSideLength() {
        /* Returns the private variable sideLength from the object the method is called from. 
            This variable represents the length of one side of the polygon. */
        return this.sideLength;
    }

    public double getRad() {
        /* Returns the private variable rad from the object the method is called from. 
            This variable represents the distance from the center of the polygon to one of the corners of the polygon. */
        return this.rad;
    }

    public double getApothem() {
        /* Returns the private variable apo from the object the method is called from. 
            This variable represents the apothem, the distance from the center of the polygon to the center of one of the sides.. */
        return this.apo;
    }


}