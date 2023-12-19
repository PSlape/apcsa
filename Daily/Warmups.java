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
    
    public static final int END = 0;
    public static final int MULT_TABLE = 1;
    public static final int STAR_PLOT = 2;
    public static final int REVERSE_STR = 3;
    public static final int UPPERCASE_STR = 4;
    public static final int REC_STR = 5;
    public static final int FLIP_HALVES = 6;

    private static final ConsoleIO cons = new ConsoleIO();
    
    public static void main(String[] args) {
        while(true) {
            System.out.println(
                "\n\nChoose a lab:\n\t" + 
                MULT_TABLE + " - Multiplication Table" + "\n\t" +
                STAR_PLOT + " - Star Tree" + "\n\t" +
                REVERSE_STR + "- String Reverser" + "\n\t" +
                REC_STR + "- Recursive String Reverser" + "\n\t" + 
                FLIP_HALVES + " - String Flipper" + "\n\n\t" +
                END + " - End Program"
                
            );
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
    
    private static String flipString(String str) {
        return str.substring(str.length() / 2, str.length()) + str.substring(0, str.length() / 2);
    }
}