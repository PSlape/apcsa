package Lesson_29;

import apcslib.Format;
/**
 * Write a description of class ShapeRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShapeRunner {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        
        shapes[0] = new Square("square", 3);
        shapes[1] = new Circle("circle", 3);
        shapes[2] = new Rectangle("rectangle", 3, 4);
        
        System.out.println(Format.left("Shape", 12) + Format.left("Perimeter", 12) + Format.left("Area", 12));
        for(Shape s : shapes) {
            System.out.println(
                Format.left(s.getName(), 12) + 
                Format.left(s.getPerimeter(), 11, 2) + " " + 
                Format.left(s.getArea(), 12, 2)
            );
        }
    }
}
