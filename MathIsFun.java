import java.lang.Math;
import apcslib.Format;
import java.awt.geom.Point2D.Double;

public class MathIsFun {
    private static final double[] F_TO_C = {212.0, 98.6, 10.0};
    private static final double[] C_TO_F = {-15.0, 0.0, 70.0};
    private static final double[] SPHERE_RADS = {1.0, 2.25, 7.50};
    private static final Double[] HYPO_CALCULATIONS = {new Double(3.0, 4.0), new Double(6.75, 12.31)};
    
    public static void main() {
        for(double value : F_TO_C) {
            System.out.println(value + " degrees F: " + Format.left(fToC(value), 5, 2) + "Celsius");
        }
        
        for(double value : C_TO_F) {
            System.out.println(value + " degrees C = " + Format.left(cToF(value), 5, 2) + "Fahrenheit");
        }
        
        for(double value : SPHERE_RADS) {
            System.out.println("Radius = " + value + ", Area = " + Format.left(sphereVolume(value), 5, 2));
        }
        
        for(Double value : HYPO_CALCULATIONS) {
            System.out.println("a = " + value.x + " b = " + value.y + " c = " + Format.left(hypoCalc(value.x, value.y), 5, 2));
        }
        
    }
    private static double fToC(double f) {
        return ((f - 32) * 5) / 9;
    }
    private static double cToF(double cel) {
        return ((9/5) * cel) + 32;
    }
    private static double sphereVolume(double rad) {
        return (4/3) * Math.PI * Math.pow(rad, 3);
    }
    private static double hypoCalc(double a, double b) {
        return Math.sqrt((a*a) + (b*b));
    }
    private static double autoRound(double toRound, int dp) {
         return Math.round(toRound * Math.pow(10, dp)) / Math.pow(10, dp);   
    }
}