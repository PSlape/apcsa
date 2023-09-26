package Lesson_6;

import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.*;

public class TicTacToe {
    static GridElement[] grid;
    
    public static void main(String[] args) {
        while(true) {
            PointerInfo mouseDevice = MouseInfo.getPointerInfo();
            Point mousePoint = mouseDevice.getLocation();
        }
    }
    
    static void initGrid() {
        grid = new GridElement[9];
        
        for(int i = 0; i < grid.length; i++) {
            grid[i] = new GridElement(i+1);
        }
    }
}

// Nate says Hello!

class GridElement extends Rectangle {
    private int pos;
    
    private final Point2D.Double[] positions = {
        new Point2D.Double(-60, 60),
        new Point2D.Double(0, 60),
        new Point2D.Double(60, 60),
        new Point2D.Double(-60, 0),
        new Point2D.Double(0, 0),
        new Point2D.Double(60, 0),
        new Point2D.Double(-60, -60),
        new Point2D.Double(0, -60),
        new Point2D.Double(60, -60)
    };
    
    public GridElement(int inPos) {
        setPos(inPos);
    }
    void setPos(int num) throws OutOfBoundsException{
        if(num > 9 || num < 1) {
            throw new OutOfBoundsException("Value must be between 1 and 9");
        } else {
            setPos(positions[num-1]);
        }
    }
    public int getPos() {
        return pos;
    }
}