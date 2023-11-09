package CSAClasses;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class CustomTokenizer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomTokenizer {
    private final LinkedList<String> tokens;
    private final String str;
    private final char splitChar;
    
    public CustomTokenizer(String str) {
        tokens = new LinkedList<String>();
        this.str = str;
        splitChar = ' ';
        
        String token = "";
        for(int ch = 0;  ch < str.length(); ch++) {
            char currentChar = str.charAt(0);
            if(currentChar != splitChar) {
                token += currentChar;
            } else {
                tokens.add(token);
                token = "";
            }
        }
    }
    
    public String nextToken() {
        if(tokens.size() != 0) {
            return tokens.poll();
        } else {
            return null;
        }
    }
    
    public LinkedList<String> getQueue() {
        return tokens;
    }
    
    public ArrayList<String> toTokens() {
        ArrayList<String> toReturn = new ArrayList<String>();
        for(String token : tokens) toReturn.add(token);
        return toReturn;
    }
    
    public String[] toArray() {
        String[] toReturn = new String[tokens.size()];
        return toReturn;
    }
    
    public static ArrayList<String> toTokens(String str) {
        CustomTokenizer tokenizer = new CustomTokenizer(str);
        return tokenizer.toTokens();
    }
}
