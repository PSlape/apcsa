package Lesson_16;

/*
 * Name: Peyton Slape
 * Lab: 16.2
 * Date: 12/18/23
 * Description: Gets the average value of a bunch of numbers in a text file.
 * Purpose: File input and output
 */

/**
 * Gets the average value of a bunch of numbers in a file.
 *
 * @author Peyton Slape
 * @version 12/18/23
 */
public class Average
{
    public static void main() {
        MathFile math = new MathFile("H:\\Chrome Downloads\\numbers.txt");
        System.out.println(math.getAverage());
        math.close();
    }
}
