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
    private final DynamicIntArray fileContents = new DynamicIntArray();
    
    public Compact(String path) {
        fileIn = new chn.util.FileInput(path);
        
        while(fileIn.hasMoreTokens()) {
            fileContents.append(fileIn.readInt());
        }
        
        fileContents.trim();
    }
    
    public void compact() {
        for(int i = 0; i < fileContents.size(); i++) {
            if(fileContents.get(i) == 0) {
                fileContents.removeIndex(i);
            }
        }
        ArrayTools.print(fileContents.toArray());
    }
}
