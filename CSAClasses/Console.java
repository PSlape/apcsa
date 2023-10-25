package CSAClasses;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.StreamTokenizer;
import java.io.IOException;


/**
 * Write a description of class Console here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Console {
    private final BufferedReader bufferedInput;
    private final StreamTokenizer tokenizer;
    
    public Console() {
        bufferedInput = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StreamTokenizer(bufferedInput); 
    }
    
    public double readDouble() {
        double in = 0;
        try {
            in = Double.parseDouble(tokenizer.toString());
        } catch(NumberFormatException ex) {
            System.out.println("Type entered was not of type double");
            in = readDouble();
        }
        return in;
    }
}
