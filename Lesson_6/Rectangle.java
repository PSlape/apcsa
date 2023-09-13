package Lesson_6;


import apcslib.*;

/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * Lab: L.A.6.2
 */
public class Rectangle {
    private static DrawingTool dw = new DrawingTool(new SketchPad(500,500));
    
    private double x, y, width, height, direction;
    
    public Rectangle() {
     this(0,0,0,0);   
    }
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Rectangle(double x, double y, double width, double height, double offset) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = offset;
    }
    public Rectangle(Rectangle r) {
        this.x = r.x;
        this.y = r.y;
        this.width = r.width;
        this.height = r.height;
        this.direction = r.direction;
    }
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }
    public double getArea() {
        return width * height;
    }
    public void draw() {
        dw.up(); // disables drawing mode
        dw.move(x-width, y-height); // moves to the bottom left corner of the shape // gets the direction the drawing tool is facing
        dw.setDirection(direction); // sets the direction to 90
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
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setHeight(double h) {
        height = h;
    }
    public void setWidth(double w) {
        width = w;
    }
    public void setDirection(double dir) {
        direction = dir;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
    public double getDirection() {
        return direction;
    }
    public void drawString(String str, double x, double y) {
        dw.up();
        dw.move(x, y);
        dw.down();
        dw.setDirection(0);
        dw.drawString(str);
    }
}
