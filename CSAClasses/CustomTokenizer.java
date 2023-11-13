package CSAClasses;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Takes a String and breaks it into tokens
 *
 * @author Peyton Slape
 * @version 11/09/23
 */
public class CustomTokenizer {
    private final LinkedList<String> tokens = new LinkedList<String>();
    
    private final String str;
    private final Character splitChar;
    private final ArrayList<Character> splitChars;
    private final char[] defaultSplitChars = {'\t', '\n', '\f'};
    /**
     * Creates a new CustomTokenizer with an input String
     * 
     * @param str The String to tokenize
     */
    public CustomTokenizer(String str) {
        this.str = str;
        splitChar = null;
        splitChars = null;
        
        String token = "";
        for(int ch = 0;  ch < str.length(); ch++) {
            char currentChar = str.charAt(0);
            if(currentChar !=  ' ') {
                token += currentChar;
            } else {
                tokens.add(token);
                token = "";
            }
        }
    }
    
    /**
     * Creates a new CustomTokenizer with an input String, 
     * broken into tokens by splitChar
     * 
     * @param str The String to tokenize
     * @param splitChar The character to split the String into tokens at
     */
    public CustomTokenizer(String str, char splitChar) {
        this.str = str;
        this.splitChar = splitChar;
        splitChars = null;
        
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
    
    public CustomTokenizer(String str, ArrayList<Character> splitChars) {
        this.str = str;
        this.splitChar = null;
        this.splitChars = splitChars;
        
    }
    
    /**
     * Gets the next token in the queue
     * @return The next token in the queue
     */
    public String nextToken() {
        if(tokens.size() != 0) {
            return tokens.poll();
        } else {
            return null;
        }
    }
    
    /**
     * Returns the queue of tokens
     * @Return The queue of tokens
     */
    public LinkedList<String> getQueue() {
        return tokens;
    }
    
    /**
     * Checks whether or not the Tokenizer has more tokens
     * @return If the array of tokens has more than 0 tokens
     */
    public boolean hasMoreTokens() {
        return tokens.size() != 0;
    }
    
    /**
     * Gets the input string as an array of tokens
     * @return An ArrayList of tokens
     */
    public ArrayList<String> toTokens() {
        ArrayList<String> toReturn = new ArrayList<String>();
        for(String token : tokens) toReturn.add(token);
        return toReturn;
    }
    
    /**
     * Gets the input string as an array of tokens
     * @return A String array of tokens
     */
    public String[] toArray() {
        String[] toReturn = new String[tokens.size()];
        return toReturn;
    }
    
    /**
     * Translates an input String into an array of tokens
     * 
     * @param str The String to Tokenize
     * @return An ArrayList of the tokens in the input string
     */
    public static ArrayList<String> toTokens(String str) {
        CustomTokenizer tokenizer = new CustomTokenizer(str);
        return tokenizer.toTokens();
    }
    
    /**
     * Translates an input String into an array of tokens
     * 
     * @param str The String to tokenize
     * @return A String array of tokens
     */
    public static String[] toTokenArray(String str) {
        CustomTokenizer tokenizer = new CustomTokenizer(str);
        return tokenizer.toArray();
    }
    
    /**
     * Gets a specific token of an input String
     * 
     * @param str The String to tokenize
     * @param tokenNum The index of the desired token
     * @return The token at the index of tokenNum
     */
    public static String getToken(String str, int tokenNum) {
        CustomTokenizer tokenizer = new CustomTokenizer(str);
        return tokenizer.toArray()[tokenNum];
    }
}
