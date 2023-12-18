package Lesson_19;

import chn.util.*;
import apcslib.Format;

/*
 * Name: Peyton Slape
 * Lab: 16.2
 * Date: 12/18/23
 * Description: Gets a bunch of things from a text file.
 * Purpose: File input and output, 1D Arrays
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

    public void writeToFile() {
        long total = 0;
        int lines = 0;
        while(inFile.hasMoreLines()) {
            int current = inFile.readInt();
            total += current;
            lines++;
        }
        double average = (double) total / (double) lines;
        outFile.println("\nAverage: " + Format.right(total, 5, 2));
        
        
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
