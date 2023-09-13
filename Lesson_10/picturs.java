package Lesson_10;

import chn.util.ConsoleIO;

public class picturs {
    private static final String SPACE = "     ";
    private static final String LESS_SPACE = "    ";
    private static final String LESSER_SPACE = "   ";
    public static void main (String[] args) {
        ConsoleIO keyboard = new ConsoleIO();
        
        printTable(4,6);
        keyboard.readLine(); // freezes the output screen to see the picture
        
        printTable(11,12);
        //keyboard.readLine(); // freezes the output screen to see the picture
        
        //pyramid(10);
        //keyboard.readLine(); // freezes the output screen to see the picture
        
        //pyramid(25);
        //keyboard.readLine(); // freezes the output screen to see the picture
    }
    
    public static void printTable (int rows, int cols) {
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(i * j >= 100) {
                    System.out.print(i * j + LESSER_SPACE);
                } else if( i * j >= 10) {
                    System.out.print(i * j + LESS_SPACE);
                } else {
                    System.out.print(i * j + SPACE);
                }
            }
            System.out.print("\n");
        }
    }

    public static void pyramid (int lines) { 
        String toPrint;
        for(int i = 0; i < lines; i++) {
            for(int j = i; j > 0; i--) {
                
            }
        }
    }
}