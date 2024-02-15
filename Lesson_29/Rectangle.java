package Lesson_29;


/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle extends Shape {
    private double length, width;
    
    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void calcPerimeter() {
        perimeter = 2 * (length + width);
    }
    
    @Override
    public void calcArea() {
        area = length * width;
    }
}
