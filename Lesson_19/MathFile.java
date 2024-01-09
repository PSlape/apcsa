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
public class MathFile implements java.io.Closeable {
    private final FileInput inFile;
    private final FileOutput outFile;
    
    private final DynamicIntArray fileContents;
    
    public MathFile(String path) {
        inFile = new FileInput(path);
        outFile = new FileOutput(path, "append");
        
        fileContents = new DynamicIntArray();
        
        while(inFile.hasMoreLines()) {
            fileContents.append(inFile.readInt());
        }
    }

    public void writeToFile() {
        outFile.println("\nAverage: " + Format.right(average(), 5, 2));
        outFile.print("Modes: ");
        for(int num : mode()) {
            outFile.print(num + ", ");
        }
        outFile.println();
    }
    
    public void printOut() {
        System.out.println("Average: " + average());
        System.out.println("Standard Deviation: " + stdev());
        System.out.print("Mode(s): ");
        ArrayTools.print(mode());
    }
    
    public double average() {
        long total = 0;
        int lines = 0;
        for(int num : fileContents.toArray()) {
            total += num;
            lines++;
        }
        return (double) total / (double) lines;
    }
    
    public double stdev() {
        double total = 0;
        for(int num : fileContents.toArray()) {
            total += Math.pow(num - average(), 2);
        }
        return Math.sqrt(total / (fileContents.toArray().length - 1));
    }
    
    public Integer[] mode() {
        Integer[] numSeen = new Integer[100];
        
        for(int num : fileContents.toArray()) {
            if(numSeen[num-1] == null)
                numSeen[num-1] = 0;

            numSeen[num-1]++;
        }
        
        DynamicIntArray modes = new DynamicIntArray(1);
        int modeTemp = 0;
        
        for(int num : numSeen) {
            if(num > modeTemp) {
                modeTemp = num;
            }
        }
        
        for(int i = 0; i < numSeen.length; i++) {
            if(numSeen[i] == modeTemp) {
                modes.append(i + 1);
            }
        }
        
        return modes.toArray();
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
