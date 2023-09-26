package Lesson_7;


/*
 * Name: Peyton Slape
 * Lab: 7.2
 * Description: Prints out several attributes of the self-made Polygon class.
 * Purpose: Basic use of classes and constructors.
 * 
 */

import apcslib.Format;

public class PolygonTester
{
    final static String[] toPrint = {
        "Number of sides = ",
        "Side length = ",
        "Radius = ",
        "Apothem = ",
        "Vertex Angle = ",
        "Perimeter = ",
        "Area = "
    };
    
    final static double[][] inputValues = {
        {4, 10}, {8, 5.75}, {19, 2}, {91, 0.5}
    };
    
    public static void main(String[] args) {
        RegularPolygon[] polygons = new RegularPolygon[inputValues.length];
        String[] outLines = formatToPrint(toPrint);
        
        for(int i = 0; i < inputValues.length; i++) {
            polygons[i] = new RegularPolygon((int) inputValues[i][0], inputValues[i][1]);
            
            System.out.println("\n Output Number: " + (i+1) + "\n");
            String[] outData = formatToPrint(
                new double[]{
                    polygons[i].getNumSides(),
                    polygons[i].getSideLength(),
                    polygons[i].getRadius(),
                    polygons[i].getApothem(),
                    polygons[i].getPerimeter(),
                    polygons[i].getArea()
                }
            );
            
            for(int k = 0; k < outData.length; k++) {
            System.out.println(outLines[k] + outData[k]);
            }
        }
        
        
        
        
    }
    private static String[] formatToPrint(String[] inp) {
        for(String str : inp) {
            str = Format.left(str, 40);
        }
        return inp;
    }
    private static String[] formatToPrint(double[] inp) {
        String[] retArr = new String[inp.length];
        for(int i = 0; i < inp.length; i++) {
             retArr[i] = Format.right(inp[i], 5, 2);
        }
        return retArr;
    }
}
