package Lesson_19;


/**
 * Write a description of class Statistics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Statistics
{
    private static final String PATH = "H:\\Chrome Downloads\\numbers.txt";
    
    public static void main() {
        DynamicArray<Integer> array = new DynamicArray<Integer>();
        array.append(5);
        array.append(6);
        
        System.out.println("Element at index 0: " + array.get(0));
        System.out.println("Does the array contain 5: " + array.contains(5));
        
        System.out.println("Removed index 0");
        array.remove(0);
       
        System.out.println("Does the array contain 5: " + array.contains(5));
        System.out.println("Element at index 0: " + array.get(0));
    }
}
