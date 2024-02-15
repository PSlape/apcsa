package Lesson_29;


/*
 * Name: Peyton Slape
 * Lab: 29.2
 * Date: 2/15/24
 * Description: Provides methods for shapes to inherit
 * Purpose: Practice using abstract classes
 */
public abstract class Shape {
    protected String name;
    protected double perimeter, area;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPerimeter() {
        calcPerimeter();
        return perimeter;
    }
    
    public double getArea() {
        calcArea();
        return area;
    }
    
    public abstract void calcPerimeter();
    public abstract void calcArea();
}
