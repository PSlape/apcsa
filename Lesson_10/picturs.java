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
  
/*
 * Name: Peyton Slape
 * Date: 10/8/23
 * Lab: 10.1
 * Description: Prints out different figures using nested for loops
 * Purpose: Practice with nested for loops
 */ 

/**
 * Prints out a few different pictures
 * 
 * @author Peyton Slape
 * @version 10/19/23
 */
public class picturs {
    public static void main (String[] args) {
        ConsoleIO keyboard = new ConsoleIO();
        
        PicturesMethods.printTable(4,6);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        PicturesMethods.printTable(11,12);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        PicturesMethods.pyramid(10);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        PicturesMethods.pyramid(25);
    }
}
