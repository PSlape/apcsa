package Lesson_15;


/**
 * Write a description of class ReverseMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReverseMethods {
    public static String recursive(String in) {
        if(in.length() == 1) return Character.toString(in.charAt(0));
        return in.charAt(in.length() - 1) + recursive(in.substring(0, in.length()-1));
    }
}
