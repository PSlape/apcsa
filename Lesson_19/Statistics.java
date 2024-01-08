package Lesson_19;


/**
 * Write a description of class Statistics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Statistics
{
    private static final String PATH = "C:\\Users\\Mudzg\\Downloads\\numbers.txt";
    
    public static void main() {
        MathFile file = new MathFile(PATH);
        ArrayTools.print(file.mode());
    }
}
