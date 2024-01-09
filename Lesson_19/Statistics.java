package Lesson_19;


/*
 * Name: Peyton Slape
 * Lab: 19.2
 * Date: 12/18/23
 * Description: Gets a bunch of things from a text file.
 * Purpose: File input and output, 1D Arrays
 */
public class Statistics
{
    private static final String PATH = "C:\\Users\\Mudzg\\Downloads\\numbers.txt";
    
    public static void main() {
        MathFile file = new MathFile(PATH);
        file.printOut();
    }
}
