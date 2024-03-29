package Daily;

import chn.util.ConsoleIO;
import Lesson_10.PicturesMethods;
import CSAClasses.CustomFormat;
import java.util.StringTokenizer;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class Warmups {
    static final int geese = 5;
    static final int meese = 6;
    static final double neese = 3.885893489385893920020924;
    private static final int[] intArray = {0, 6, 13, 0, 0, 76, 33, 0, 0, 0, 4, 29, 21, 0, 86, 0, 32, 66, 0, 0};
    private static final int[][] bioMatrix = {
        {0, 0, 0, 0},
        {1, 0, 1, 1},
        {1, 1, 1, 1},
        {0, 1, 1, 0}
    };
    private static final int[] mergeArray1 = {3, 6, 9, 12, 15, 18, 21};
    private static final int[] mergeArray2 = {2, 4, 6, 8, 10, 12, 14};
    
    public static final int END = 0;
    public static final int MULT_TABLE = 1;
    public static final int STAR_PLOT = 2;
    public static final int REVERSE_STR = 3;
    public static final int UPPERCASE_STR = 4;
    public static final int REC_STR = 5;
    public static final int FLIP_HALVES = 6;
    public static final int STRING_THIRDS = 7;
    public static final int PRINT_ARRAY = 8;
    public static final int LARGEST_NUM = 9;
    public static final int SMALLEST_NUM = 10;
    public static final int CLEAR_ZERO = 11;
    public static final int MATRIX_THING = 12;
    public static final int GUESSING_GAME = 13;
    public static final int MERGE_ARRAY = 14;    

    private static final ConsoleIO cons = new ConsoleIO();
    
    public static void main(String[] args) {
        while(true) {
            System.out.println(
                "\n\nChoose a lab:\n\t" + 
                MULT_TABLE + " - Multiplication Table" + "\n\t" +
                STAR_PLOT + " - Star Tree" + "\n\t" +
                REVERSE_STR + "- String Reverser" + "\n\t" +
                REC_STR + "- Recursive String Reverser" + "\n\t" + 
                FLIP_HALVES + " - String Flipper" + "\n\t" +
                STRING_THIRDS + " - String Thirder" + "\n\t" +
                PRINT_ARRAY + " - Print Array" + "\n\t" + 
                LARGEST_NUM + " - Largest in Array" + "\n\t" +
                SMALLEST_NUM + "- Smallest in Array" + "\n\t" + 
                CLEAR_ZERO + "- Clear Zeroes" + "\n\t" +
                MATRIX_THING + " - Check for Neighbors" + "\n\t" +
                GUESSING_GAME + " - Guessing Game" + "\n\t" + 
                MERGE_ARRAY + " - Merge Array" + "\n\n\t" +
                END + " - End Program" + "\n\n"
            );
            
            System.out.print("Pick A Lab - ");
            int labChoice = cons.readInt();
            switch(labChoice) {
                case END:
                    System.out.println("Ending program...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Ended");
                    } catch(Exception ex) {
                        System.out.println("\tError Ending Program");
                        System.out.println(ex);
                    }
                    System.exit(0);
                    break;
                case MULT_TABLE:
                    runWarmup2();
                    break;
                case STAR_PLOT:
                    runWarmup3();
                    break;
                case REVERSE_STR:
                    runWarmup4();
                    break;
                case UPPERCASE_STR:
                    runWarmup4();
                    break;
                case REC_STR:
                    runWarmup6();
                    break;
                case FLIP_HALVES:
                    runWarmup7();
                    break;
                case STRING_THIRDS:
                    runWarmup8();
                    break;
                case PRINT_ARRAY:
                    runWarmup9();
                    break;
                case LARGEST_NUM:
                    runWarmup10();
                    break;
                case SMALLEST_NUM:
                    runWarmup11();
                    break;
                case CLEAR_ZERO:
                    runWarmup12();
                    break;
                case MATRIX_THING:
                    runWarmup13();
                    break;
                case GUESSING_GAME:
                    runWarmup14();
                    break;
                case MERGE_ARRAY:
                    runWarmup15();
                    break;
                default:
                    System.out.println("Input error, try again");
                    break;
            }
        }
    }
    
    private static void runWarmup1() {
        System.out.println(
            "The identifier of my first variable is geese of type int and value of " + geese + "\n" + 
            "The identifier of my second variable is meese of type int and value of " + meese + "\n" + 
            "The identifier of my third variable is neese of type double and value of " + neese
        );
        
        
        System.out.print("Enter 2 numbers, seperated by a space: ");
        WarmupMethods wm = new WarmupMethods(cons.readDouble(), cons.readDouble());
        System.out.println(
            "Product of " + wm.getA() + " and " + wm.getB() + " is: " + wm.product()
        );
    }
    
    private static void runWarmup2() {
        WarmupMethods.drawTable(5,5);
    }
    
    private static void runWarmup3() {
        WarmupMethods.drawTree(6);
    }
    
    private static void runWarmup4() {
        WarmupMethods wm = new WarmupMethods();
        System.out.print("String to reverse: ");
        System.out.println("Output: " + wm.reverseString(cons.readLine()));
    }

    private static void runWarmup5() {
        WarmupMethods wm = new WarmupMethods();
        System.out.print("String to capitalize: ");
        System.out.println("Output: " + wm.capitalizeString(cons.readLine()));
    }
    
    private static void runWarmup6() {
        System.out.print("Enter a string: ");
        System.out.println("Output: " + reverseWords(cons.readLine()));
    }
    
    private static String reverseWords(String msg) {
        int index = msg.indexOf(" ");
        if(index == -1 || index == 1) return "";
        return reverseWords(msg.substring(index)) + " " + msg.substring(0, index);
    }
    
    private static void runWarmup7() {
        System.out.print("What is your string input?");
        System.out.println("The string output is: " + flipString(cons.readLine()));
    }
    
    private static void runWarmup8() {
        System.out.print("Enter a string: ");
        String stronk = cons.readLine();
        System.out.println("Third third: " + stringThirds(stronk, 3) + ", the first third: " + stringThirds(stronk, 1));
    }
    
    private static void runWarmup9() {
        WarmupMethods wm = new WarmupMethods();
        wm.printArray(intArray);
    }
    
    private static void runWarmup10() {
        WarmupMethods.findLargest(intArray);
    }
    
    private static void runWarmup11() {
        WarmupMethods.findSmallest(intArray);
    }
    
    private static void runWarmup12() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int element : intArray) {
            array.add(element);
        }
        System.out.println("Numbers: " + array);
        
        WarmupMethods.clearZeroes(array);
        
        System.out.println("Numbers: " + array + "\n\nThe array clearZeroes method is done");
    }
    
    private static void runWarmup13() {
        System.out.print("\nNumber of Neighbors in matrix = " + WarmupMethods.checkNeighbors(bioMatrix, 2, 2));
    }
    
    private static void runWarmup14() {
        ConsoleIO cons = new ConsoleIO();
        System.out.print("Give me a number from 1 to 1024: ");
        int num = cons.readInt();
        System.out.println("Enter correct, higher, or lower to help me find the number\n");
        int lastGuess = 0;
        int guess = (int) (Math.random() * 1023) + 1;
        int max = 1024;
        int min = 0;
        int guessCount = 0;
        while(true) {
            System.out.print("Is " + guess + " correct? ");
            guess = processInput(guess, min, max);
            guessCount++;
            if(guess < lastGuess) {
                max = lastGuess;
            } else if(guess > lastGuess) {
                min = lastGuess;
            }
            if(guess == 0) {
                System.out.println("\nYay we did it\n");
                System.out.println("It took " + guessCount + " guesses.");
                break;
            }
            lastGuess = guess;
        }
    }
    
    private static void runWarmup15() {
        WarmupMethods warm = new WarmupMethods();
        
        System.out.println("Array 1");
        warm.printArray(mergeArray1);
        
        System.out.println("\nArray 2");
        warm.printArray(mergeArray2);
        
        System.out.println("\nMerged Array");
        warm.printArray(warm.mergeIt(mergeArray1, mergeArray2));
        
        System.out.println("\nThe merge two arrays method is done");
    }
    
    private static int processInput(int guess, int min, int max) {
        String in = cons.readLine().trim().toLowerCase();
        if(in.equals("correct") || in.equals("yes")) {
            return 0;
        } else if(in.equals("lower") || in.equals("high")) {
            return (guess + min) / 2;
        } else if(in.equals("higher") || in.equals("low")) {
            return (guess + max) / 2;
        } else if(in.equals("exit")) {
            System.exit(0);
            return Integer.MIN_VALUE;
        } else {
            System.out.println("Input error, try again");
            return processInput(guess, min, max);
        }
    }
    
    private static String flipString(String str) {
        return str.substring(str.length() / 2, str.length()) + str.substring(0, str.length() / 2);
    }
    
    private static String stringThirds(String str, int third) {
        if(third > 3 || third < 1) return null;
        int thirdLength = str.length() / 3;
        if(third == 3) return str.substring((thirdLength + 1) * 2, str.length());
        
        return str.substring((thirdLength + 1) * (third - 1), (thirdLength) * third);
    }
    
}