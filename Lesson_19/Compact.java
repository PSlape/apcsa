package Lesson_19;


/*
 * Name: Peyton Slape
 * Lab: 19.2
 * Date: 1/9/24
 * Description: Gets an array from a txt file and removes zeros.
 * Purpose: File input and output, 1D Arrays
 */
public class Compact {
    private final chn.util.FileInput fileIn;
    private Integer[] fileContents = new Integer[100];
    
    public Compact(String path) {
        fileIn = new chn.util.FileInput(path);
        
        while(fileIn.hasMoreTokens()) {
            ArrayTools.append(fileContents, fileIn.readInt());
        }
    }
    
    public void compact() {
        System.out.print("Original Array: ");
        ArrayTools.print(fileContents);
        
        for(int i = 0; i < fileContents.length; i++) {
            int zeros = 0;
            while(
                fileContents[i + zeros] != null && fileContents[i + zeros] == 0
            ) {
                remove(i + zeros);
                if(fileContents[i+zeros] != null && fileContents[i + zeros] != 0) {
                    zeros++;
                }
            }
        }
        System.out.print("Compacted Array: ");
        ArrayTools.print(fileContents);
    }
    
    public void remove(int index) {
        for(int i = index; i < fileContents.length-1; i++) {
            fileContents[i] = fileContents[i+1];
        }
    }
}
