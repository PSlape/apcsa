package Lesson_7;

import java.lang.Math;
import apcslib.Format;
import java.awt.geom.Point2D.Double;

/*
 * Name: Peyton Slape
 * Lab: 7.1
 * Description: Uses static methods from the Fun class to calculate some things
 * Purpose: Practice with static methods.
 */

public class funRunner {
        // Initialize input values to pass into methods
    private static final double[] F_TO_C = {212.0, 98.6, 10.0};
    private static final double[] C_TO_F = {-15.0, 0.0, 70.0}; 
    private static final double[] SPHERE_RADS = {1.0, 2.25, 7.50};
    private static final Double[] HYPO_CALCULATIONS = {new Double(3.0, 4.0), new Double(6.75, 12.31)};
    
    public static void main() {
            // Prints the Fahrenheit value for each F_TO_C input
        for(double value : F_TO_C) {
            System.out.println(value + " degrees F: " + Format.left(Fun.fToC(value), 5, 2) + " Celsius");
        }
        
            // Prints the Celsuis value for each C_TO_F input
        for(double value : C_TO_F) {
            System.out.println(value + " degrees C = " + Format.left(Fun.cToF(value), 5, 2) + " Fahrenheit");
        }
        
            // Prints the volume for each SPHERE_RADS input
        for(double value : SPHERE_RADS) {
            System.out.println("Radius = " + value + ", Volume = " + Format.left(Fun.sphereVolume(value), 5, 2));
        }
        
            // Prints the hypotenuse for each HYPO_CALCULATIONS input
        for(Double value : HYPO_CALCULATIONS) {
            System.out.println("a = " + value.x + " b = " + value.y + " c = " + Format.left(Fun.hypoCalc(value.x, value.y), 5, 2));
        }
        
    }
}

class Fun {
    public static double fToC(double f) {
        return ((f - 32) * 5) / 9.0; // Formula to change from fahrenheit to celsuis
    }
    public static double cToF(double cel) {
        return ((9.0/5.0) * cel) + 32; // Formula to change from celsius to fahrenheit
    }
    public static double sphereVolume(double rad) {
        return (4.0/3.0) * Math.PI * Math.pow(rad, 3); // Formula for volume of a sphere
    }
    public static double hypoCalc(double a, double b) {
        return Math.sqrt((a*a) + (b*b)); // Pythagorean formula
    }
    public static double autoRound(double toRound, int dp) {
         return Math.round(toRound * Math.pow(10, dp)) / Math.pow(10, dp); // Truncates numbers to the nearest decimal place (dp)
    }
}