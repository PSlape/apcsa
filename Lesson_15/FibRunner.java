package Lesson_15;


/**
 * Write a description of class FibRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibRunner {
    private static final int[] rec_test = {0, 3, 11};
    private static final int[] non_rec_test = {1, 5, 14};
    private static final int[][] mult_test = {{0, 4}, {3, 1}, {7, 8}, {5, 0}};
    public static void main(String[] args) {
        for(int num : rec_test) {
            System.out.println(FibonacciMethods.getNumber(num));
        }
        for(int num : non_rec_test) {
            System.out.println(FibonacciMethods.getNumber_nonRec(num));
        }
        for(int[] nums : mult_test) {
            System.out.println(FibonacciMethods.mult(nums[0], nums[1]));
        }
    }
}
