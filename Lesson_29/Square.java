package Lesson_29;


/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Shape {
    private double sideLength;
    
    public Square(String name, double length) {
        super(name);
        sideLength = length;
    }
    
    @Override
    public void calcPerimeter() {
        perimeter = sideLength * 4;
    }
    
    @Override
    public void calcArea() {
        area = Math.pow(sideLength, 2);
    }
}
