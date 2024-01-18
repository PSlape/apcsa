package Lesson_21;

import chn.util.FileInput;
import java.util.ArrayList;
import java.awt.Point;
import chn.util.ConsoleIO;
/**
 * Write a description of class LifeRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LifeRunner {
    public static void main(String[] args) {
        FileInput input = new FileInput("C:\\Users\\Mudzg\\Downloads\\life100.txt");
        ConsoleIO cons = new ConsoleIO();
        
        int end = input.readInt();
        ArrayList<Point> points = new ArrayList<Point>(end);
        for(int i = 0; i < end; i++) {
            points.add(new Point(input.readInt()-1, input.readInt()-1));
        }
        
        System.out.print("How many iterations: ");
        int iterations = cons.readInt();
        
        Life life = new Life(points);
        
        int current = 0;
        while(current < iterations) {
            life.step();
            current++;
        }
        
        System.out.println(life);
    }
}
