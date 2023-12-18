package Lesson_15;

import apcslib.*;

/**
 * Write a description of class KochCurve here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KochCurve extends DrawingTool {
    public KochCurve() {
        super(new SketchPad(1000, 1000));
    }
    
    public KochCurve(SketchPad sp) {
        super(sp);
    }
    
    public void drawKochCurve(int level, double length) {
        if(level < 1) {
            move(length);
        } else {
            drawKochCurve(level-1, length / 3);
            turnLeft(60);
            drawKochCurve(level-1, length / 3);
            turnRight(120);
            drawKochCurve(level-1, length / 3);
            turnLeft(60);
            drawKochCurve(level-1, length / 3);
        }
    }
    
    public void drawKochTriangle(int level, double length) {
        for(int side = 0; side < 3; side++) {
            drawKochCurve(level, length);
            turnRight(120);
        }
    }
}
