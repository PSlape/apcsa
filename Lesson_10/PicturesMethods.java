package Lesson_10;

import CSAClasses.CustomFormat;

/**
 * Provides the methods for the Pictures 10.1 Lab.
 *
 * @author Peyton Slape
 * @version 10/19/23
 */
public class PicturesMethods
{
        // final values used for the printTable method
    public static final String SPACE = "     ";
    public static final String LESS_SPACE = "    ";
    public static final String LESSER_SPACE = "   ";
    
    /**
     * Prints out a multiplication table
     * 
     * @param rows      The number of rows the table will have
     * @param cols      The number of columns the table will have
     */
    public static void printTable (int rows, int cols) {
        for(int i = 0; i < rows+1; i++) {
            System.out.print(CustomFormat.left(Integer.toString(i), 5));
            if(i != 0) {
                for(int j = 1; j < cols+1; j++) {                
                    if(i * j >= 100) { // If the value has 3 digits, it prints out a space with 2 less characters
                        System.out.print(i * j + LESSER_SPACE); 
                    } else if( i * j >= 10) { // If the value has 2 digits, it prints out a space with 1 less character
                        System.out.print(i * j + LESS_SPACE); 
                    } else {
                        System.out.print(i * j + SPACE); // If the value has 1 digit, it prints out the normal sized space
                    }
                }
            } else {
                for(int j = 1; j < cols+1; j++) {
                    if(j < 100) {
                        System.out.print(j + LESSER_SPACE);
                    } else if(j < 10) {
                        System.out.print(j + LESS_SPACE);
                    } else {
                        System.out.print(j + SPACE);
                    }
                }
            }
            if(rows == 1) System.out.println();
            System.out.print("\n"); // Gets ready to print the next row
        }
    }

    /**
     * Prints out a pyramid
     * 
     * @param lines     The number of lines the pyramid should have
     */
    public static void pyramid (int lines) { 
        int numOfChar = -1;
        double center = lines / 2.0;
        // if(center - Math.floor(center) != center)
        for(int i = lines-1; i >= 0; i -= 1) {
            String toFormat = "";
            numOfChar += 2;
            for(int j = 0; j < numOfChar; j++) {
                toFormat += "*";
            }
            System.out.println(CustomFormat.right(toFormat, i));
        }
    }
}
