package Lesson_16;

import chn.util.*;
import apcslib.Format;

/*
 * Name: Peyton Slape
 * Lab: 16.2
 * Date: 12/18/23
 * Description: Gets the average value of a bunch of numbers in a text file.
 * Purpose: File input and output
 */

/**
 * Gets the average value of a bunch of numbers in a file.
 *
 * @author Peyton Slape
 * @version 12/18/23
 */
public class MathFile implements AutoCloseable {
    private final FileInput inFile;
    private final FileOutput outFile;
    
    public MathFile(String path) {
        inFile = new FileInput(path);
        outFile = new FileOutput(path, "append");
    }
    
    /**
     * Gets the average of the numbers in the file and writes it to the end of the file
     * 
     * @returns The average as a String
     */
    public String getAverage() {
        long total = 0;
        int lines = 0;
        while(inFile.hasMoreLines()) {
            int current = inFile.readInt();
            total += current;
            lines++;
        }
        String out = Format.right((double) total / (double) lines, 5, 2);
        outFile.println("\n" + out);
        return out;
    }
    
    /**
     * Closes the in/out streams
     */
    @Override
    public void close() {
        inFile.close();
        outFile.close();
    }
}
