package Lesson_13;

import java.util.StringTokenizer;

/**
 * Write a description of class ShorthandMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShorthandMethods
{
    public static String convertToShort(String input) {
        input = input.toLowerCase();
        input = replaceWords(input);
        return removeVowels(input);
    }
    private static String replaceWords(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String out = "";
        while(st.hasMoreTokens()) {
            String current = st.nextToken();
            if(current.equals("you")) {
                out += "U";
            } else if(current.equals("and")) {
                out += "&";
            } else if(current.equals("to")) {
                out += "2";
            } else if(current.equals("for")) {
                out += "4";
            } else {
                out += current;
            }
            out += " ";
        }
        return out;
    }
    private static String removeVowels(String input) {
        String out = "";
        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if(current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') continue;
            out += current;
        }
        return out;
    }
}
