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
    
    private final DynamicArray<Integer> fileContents;
    
    public MathFile(String path) {
        inFile = new FileInput(path);
        outFile = new FileOutput(path, "append");
        
        fileContents = new DynamicArray<Integer>();
        
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
    
    public double average() {
        long total = 0;
        int lines = 0;
        for(int num : fileContents.toArray()) {
            total += num;
            lines++;
        }
        return (double) total / (double) lines;
    }
    
    public int[] mode() {
        DynamicArray<Pair> shown = new DynamicArray<Pair>();
        
        for(int num : fileContents.toArray()) {
            boolean didFind = false;
            for(Pair pair : shown.toArray()) {
                if(pair.x == num) {
                    didFind = true;
                    pair.add(new Pair(0, 1));
                }
            }
            if(!didFind) {
                shown.append(new Pair(num, 1));
            }
        }
        
        DynamicArray<Pair> modePairs = new DynamicArray<Pair>();
        for(Pair pair : shown.toArray()) {
            for(Pair mode : modePairs.toArray()) {
                if(pair.y > mode.y) {
                    modePairs.remove(pair);
                    modePairs.append(pair);
                } else if(pair.y == mode.y) {
                    modePairs.append(pair);
                }
            }
        }
        int[] modes = new int[modePairs.size()];
        for(int i = 0; i < modes.length; i++) {
            modes[i] = modePairs.get(i).x;
        }
        return modes;
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
