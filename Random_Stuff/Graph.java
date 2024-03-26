package Random_Stuff;

// Imports
import apcslib.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.geom.Point2D;

public class Graph {
    private static DrawingTool dw = new DrawingTool(new SketchPad(800,800));
    
    public static void main(String[] args) {
        
        Equation eq = (xPos) -> {
            xPos *= 0.1;
            return 50 * Math.sin(xPos);
        };
        
        Equation eq2 = (xPos) -> {
            xPos *= 0.1;
            return 5 * Math.cos(xPos);
        };
        
        // var points = getPoints(eq, -314, 314, 0.01);
        var points = getPoints(approxDerivative(eq), -800, 800, 0.01);
        
        dw.up();
        dw.move(-800, eq.getPoint(-800));
        dw.down();
        
         for(Point2D.Double point : points) {
             var curPos = dw.getPosition();
             dw.move(point.x, curPos.y + (0.01 * point.y));
        }
        
        drawEquation(eq, Color.RED);
        drawEquation(eq2, Color.BLUE);
        drawEquation(approxDerivative(eq), Color.GREEN);
    }
    
    public static void drawEquation(Equation eq, Color col) {
        var points = getPoints(eq, -800, 800, 0.01);
        dw.up();
        dw.move(points.get(0).x, points.get(0).y);
        dw.down();
        
        dw.setColor(col);
        
        for(Point2D.Double point : points) {
            dw.move(point.x, point.y);
        }
    }
    
    public static ArrayList<Point2D.Double> getPoints(Equation eq, double min, double max, double inc) {
        var points = new ArrayList<Point2D.Double>();
        for(double x = min; x < max; x += inc) {
            points.add(new Point2D.Double(x, eq.getPoint(x)));
        }
        return points;
    }
    
    public static Equation approxDerivative(Equation eq) {
        Equation derivative = (x) -> {
            double xApp = x - 0.00000001;
            return (eq.getPoint(xApp) - eq.getPoint(x)) / (xApp - x);
        };
        return derivative;
    }
}

interface Equation {
    double getPoint(double x);
}


