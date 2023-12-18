package Lesson_16;

import chn.util.*;
import apcslib.Format;
import java.io.DataOutputStream;
import java.io.OutputStream;

/*
 * Name: Peyton Slape
 * Date: 12/18/23
 * Des
 */

/**
 * Write a description of class ReadData here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
            String next = inFile.readLine();
            Integer store = null;
            
            for(int i = 0; i < next.length(); i++) {
                if(next.charAt(i) != ' ') {
                    store = i;
                    break;
                }
            }
            if(store != null) {
                out = Format.left(Integer.toString(store), 2) + next.substring(store, next.length());
                
                System.out.println(out);
                outFile.println(out);
            }
        }
        outFile.close();
    }
}
