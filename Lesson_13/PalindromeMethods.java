package Lesson_13;

/*
 * Name: Peyton Slape
 * Date: 08/31/23
 * Description: Provides static methods to test if a String is a palindrome
 * Purpose: To practice manipulating Strings
 */

/**
 * Provides static methods to see if a String is a palindrome
 *
 * @author Peyton Slape
 * @version 08/31/23
 */
public class PalindromeMethods {
    
    /**
     * Takes an input and checks if it is a palindrome
     * 
     * @param input The String to check
     * @return Whether or not the input String is a palindrome
     */
    public static boolean checkPalindrome(String input) {
        if(input.length() <= 1) return false;
        input = format_input(input.trim().toLowerCase());
        
        String reversed = reverse(input);
        return input.equals(reversed);
    }
    
    /**
     * Reverses a String
     * 
     * @param string The input String to reverse
     * @return The reversed String
     */
    private static String reverse(String string) {
        String outString = "";
        for(int i = string.length()-1; i >=0; i--) {
            outString += string.charAt(i);
        }
        return outString;
    }
    /**
     * Formats the input to prepare for use
     * 
     * @param input The String to format
     * @return The formatted String
     */
    private static String format_input(String input) {
        String newString = "";
        for(int i = input.length()-1; i >= 0; i--) {
            if(Character.isLetterOrDigit(input.charAt(i))) newString += input.charAt(i);
        }
        return newString;
    }
}
