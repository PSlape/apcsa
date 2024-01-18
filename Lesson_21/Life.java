package Lesson_21;
import java.util.ArrayList;
import java.awt.Point;
import apcslib.Format;
/**
 * Write a description of class Life here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Life {    
    public final boolean[][] cellStates;
    
    public Life(boolean[][] initialCellState) {
        cellStates = initialCellState;
    }
    
    public Life(ArrayList<Point> bacteriaPoints) {
        cellStates = new boolean[20][20];
        for(Point point : bacteriaPoints) {
            cellStates[point.x][point.y] = true;
        }
    }
    
    public void setCell(int x, int y, boolean state) {
        cellStates[x][y] = state;
    }
    
    public boolean getCell(int x, int y) {
        return cellStates[x][y];
    }
    
    public boolean getCell(Point point) {
        return cellStates[point.x][point.y];
    }
    
    private boolean isWithinBoundaries(Point point) {
        return point.x > 0 && point.x < cellStates.length && point.y > 0 && point.y < cellStates[0].length;
    }
    
    public boolean nextCellState(int x, int y) {
        Point[] translations = {
          new Point(    x-1,    y-1     ),
          new Point(    x-1,    y       ),
          new Point(    x-1,    y+1     ),
          new Point(    x,      y+1     ),
          new Point(    x+1,    y+1     ),
          new Point(    x+1,    y       ),
          new Point(    x+1,    y-1     ),
          new Point(    x,      y-1     )
        };
        int neighborCount = 0;
        
        for(Point point : translations) {
            if(isWithinBoundaries(point) && getCell(point)) {
                neighborCount++;
            }
        }
        if(neighborCount == 3) {
            return true;
        } else if(neighborCount < 2) {
            return false;
        } else if(neighborCount > 3) {
            return false;
        } else {
            return cellStates[x][y];
        }
    }
    
    public void step() {
        boolean[][] nextCellStates = new boolean[20][20];
        for(int x = 0; x < cellStates.length; x++) {
             for(int y = 0; y < cellStates[0].length; y++) {
                 nextCellStates[x][y] = nextCellState(x, y);
             }
        }
        
        for(int x = 0; x < cellStates.length; x++) {
             for(int y = 0; y < cellStates[0].length; y++) {
                 cellStates[x][y] = nextCellStates[x][y];
             }
        }
    }
    
    public int aliveInRow(int row) {
        int count = 0;
        for(boolean state : cellStates[row-1]) {
            if(state) count++;
        }
        return count;
    }
    
    public int aliveInColumn(int col) {
        int count = 0;
        for(boolean[] row : cellStates) {
            if(row[col-1]) {
                count++;
            }
        }
        return count;
    }
    
    public int allAlive() {
        int count = 0;
        for(int i = 0; i < cellStates.length; i++) {
            count += aliveInRow(i+1);
        }
        return count;
    }
    
    public String toString() {
        String outString = Format.right("12345678901234567890", 26) + "\n";
        for(int x = 0; x < cellStates.length; x++) {
            outString += Format.center(x+1, 6);
            for(int y = 0; y < cellStates[0].length; y++) {
                 if(cellStates[x][y]) 
                     outString += "*";
                 else
                     outString += " ";
            }
            outString += "\n";
        }
        outString += "\nNumber in Row 10 ---> " + aliveInRow(10);
        outString += "\n\nNumber in Column 10 ---> " + aliveInColumn(10);
        outString += "\n\nNumber of living organisms ---> " + allAlive();
        
        return outString;
    }
}
