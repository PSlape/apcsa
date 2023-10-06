package Lesson_10;

import chn.util.ConsoleIO;
import CSAClasses.CustomFormat;

/*
     *          Psuedocode
     *          
     * printTable(rows, columns)
     *      for each row in length rows
     *          for each column in length columns
     *              print out row value * column value
     *          print new line
     *
     * pyramid(lines)
     *      for each line in length lines
     *          for each char in line
     *              print out * per value of lines
     *          print new line
*/
    
public class picturs {
        // final values used for the printTable method
    private static final String SPACE = "     ";
    private static final String LESS_SPACE = "    ";
    private static final String LESSER_SPACE = "   ";
    
    public static void main (String[] args) {
        ConsoleIO keyboard = new ConsoleIO();
        
        printTable(4,6);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        printTable(11,12);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        pyramid(10);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        pyramid(25);
    }
    
    
        // Prints out a multiplication table based on the number of rows and columns in the table
    public static void printTable (int rows, int cols) {
        for(int i = 1; i < rows+1; i++) {
            for(int j = 1; j < cols+1; j++) {
                if(i * j >= 100) { // If the value has 3 digits, it prints out a space with 2 less characters
                    System.out.print(i * j + LESSER_SPACE); 
                } else if( i * j >= 10) { // If the value has 2 digits, it prints out a space with 1 less character
                    System.out.print(i * j + LESS_SPACE); 
                } else {
                    System.out.print(i * j + SPACE); // If the value has 1 digit, it prints out the normal sized space
                }
            }
            System.out.print("\n"); // Gets ready to print the next row
        }
    }

        // Prints out a pyramid with a number of lines based on the parameter lines
    public static void pyramid (int lines) { 
        int numOfChar = 0;
        double center = lines / 2.0;
        if(center - Math.floor(center) != center)
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
