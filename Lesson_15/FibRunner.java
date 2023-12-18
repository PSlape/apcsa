package Lesson_15;

/*
 * Name: Peyton Slape
 * Date: 11/25/23
 * Lab: 15.1
 * Purpose: Recursion practice
 * Description: Fibonacci Sequence
 */
public class FibRunner {
    private static final int[] rec_test = {0, 3, 11};
    private static final int[] non_rec_test = {1, 5, 14};
    private static final int[][] mult_test = {{0, 4}, {3, 1}, {7, 8}, {5, 0}};
    public static void main(String[] args) {
        for(int num : rec_test) {
            System.out.println("Fibonnaci for " + num + ": " + FibonacciMethods.getNumber(num));
        }
        for(int num : non_rec_test) {
            System.out.println("Fibonnaci for " + num + ": " + FibonacciMethods.getNumber_nonRec(num));
        }
        for(int[] nums : mult_test) {
            System.out.println("Sum of " + nums[0] + " and " + nums[1] + ": " + FibonacciMethods.mult(nums[0], nums[1]));
        }
    }
}
