package Lesson_29;


/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Shape {
    private double radius;
    
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    @Override
    public void calcPerimeter() {
        perimeter = 2 * radius * Math.PI;
    }
    
    @Override
    public void calcArea() {
        area = Math.pow(radius, 2) * Math.PI;
    }
}
