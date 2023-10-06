package Lesson_6;

import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.*;
import java.util.ArrayList;
import CSAClasses.OutOfBoundsException;

public class TicTacToe {
    static ArrayList<GridElement> grid;
    
    public static void main(String[] args) {
        initGrid();
    }
    
    private static void initGrid() {
        grid = new ArrayList<GridElement>(9);
        for(int i = 0; i < grid.size(); i++) {
            grid.add(new GridElement(i+1));
            grid.get(i).draw();
        }
    }
    private static GridElement getGridElement(Point point) {
        Point2D.Double[] positions = GridElement.getPositions();
        for(int i = 0; i < positions.length; i++) {
            if(positions[i].x == point.x && positions[i].y == point.y) {
                return grid.get(i);
            }
        }
        return null;
    }
}
class PointerThread extends Thread {
    PointerInfo mouseDevice;
    Point mousePoint;
    public PointerThread() {
        mouseDevice = MouseInfo.getPointerInfo();
    }
    public void run() {
        mousePoint = mouseDevice.getLocation();
    }
}

class GridElement extends Rectangle {
    private int pos;
    private Hitbox hitbox;
    private static final Point2D.Double[] positions = {
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
        width = 20;
        height = 20;
        setPos(inPos);
    }
    private void setPos(int num) throws OutOfBoundsException{
        if(num > 9 || num < 1) {
            throw new OutOfBoundsException("Value must be between 1 and 9");
        } else {
            setPos(positions[num-1]);
        }
    }
    public int getPos() {
        return pos;
    }
    public static Point2D.Double[] getPositions() {
        return positions;
    }
    private Hitbox setHitbox() {
        double xLim = positions[pos-1].x + width;
        double yLim = positions[pos-1].y + height;
        return new Hitbox(xLim, yLim);
    }
}
record Hitbox(double xLim, double yLim) {
    Hitbox(int xLim, int yLim) {
        this((double) xLim, (double) yLim);
    }
    Hitbox(float xLim, int yLim) {
        this((double) xLim, (double) yLim);
    }
}