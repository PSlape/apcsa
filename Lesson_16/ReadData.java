package Lesson_16;

import chn.util.*;
import apcslib.Format;
import java.io.DataOutputStream;
import java.io.OutputStream;

/*
 * Name: Peyton Slape
 * Lab: 16.1
 * Date: 12/18/23
 * Description: Reads a file then removes extra spaces
 * Purpose: File input and output
 */

/**
 * Removes extra spaces from Java source files
 *
 * @author Peyton Slape
 * @version 12/18/23
 */
public class ReadData {
    private static final String PATH = "H:\\apcsa-copy\\Lesson_16\\";
    private static final String NAME = "Shrunka";
    private static final String EXT = ".java";
    
    public static void main(String[] args) {
        FileInput inFile = new FileInput(PATH + NAME + EXT);
        FileOutput outFile = new FileOutput(PATH + NAME + "_shrunked" + EXT);
        
        String writeToFile = "";
        String out;
        while(inFile.hasMoreLines()) {
            String next = inFile.readLine(); // Get line
            Integer store = null;
            
            for(int i = 0; i < next.length(); i++) {
                if(next.charAt(i) != ' ') {
                    store = i;
                    break;
                }
            }
            if(store != null) {
                out = Format.left(Integer.toString(store), 2) + next.trim();
                
                System.out.println(out);
                outFile.println(out); // Add to file
            }
        }
        // Close in/out streams
        inFile.close();
        outFile.close();
    }
}
