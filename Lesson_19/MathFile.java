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
    
    public double average() {
        long total = 0;
        int lines = 0;
        for(int num : fileContents.toArray()) {
            total += num;
            lines++;
        }
        return (double) total / (double) lines;
    }
    
    public Integer[] mode() {
        Pair[] shown = new Pair[fileContents.size()];
        int lastStoredIndex = 0;
        
        for(Integer num : fileContents.toArray()) {
            boolean didFind = false;
            for(Pair pair : shown) {
                if(pair == null) break;
                
                if(pair.x == num) {
                    didFind = true;
                    pair.add(new Pair(0, 1));
                }
            }
            if(!didFind) {
                shown[lastStoredIndex] = new Pair(num, 1);
                lastStoredIndex++;
            }
        }
        
        Pair[] modePairs = new Pair[shown.length];
        for(Pair pair : shown) {
            if(pair == null) continue;
            for(Pair mode : modePairs) {
                if(mode == null) {
                    ArrayTools.append(modePairs, pair);
                    continue;
                }
                if(pair.y > mode.y) {
                    ArrayTools.removeObject(modePairs, pair);
                    ArrayTools.append(modePairs, pair);
                } else if(pair.y == mode.y) {
                    ArrayTools.append(modePairs, pair);
                }
            }
        }
        Integer[] modes = new Integer[modePairs.length];
        for(int i = 0; i < modes.length; i++) {
            if(modePairs[i] == null) continue;
            modes[i] = modePairs[i].x;
        }
        ArrayTools.trim(modes);
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
