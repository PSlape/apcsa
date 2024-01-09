package Lesson_19;


/**
 * Write a description of class CompactMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompactMain {
    private static final String PATH = "C:\\Users\\Mudzg\\Downloads\\compact.txt";
    public static void main(String[] args) {
        Compact compact = new Compact(PATH);
        compact.compact();
    }
}
