package Daily;

import chn.util.ConsoleIO;
import Lesson_10.PicturesMethods;
import CSAClasses.CustomFormat;

import java.util.concurrent.TimeUnit;

public class Warmups {
    static final int geese = 5;
    static final int meese = 6;
    static final double neese = 3.885893489385893920020924;
    
    public static final int END = 0;
    public static final int MULT_TABLE = 1;
    public static final int STAR_PLOT = 2;
    
    private static final ConsoleIO cons = new ConsoleIO();
    
    public static void main(String[] args) {
        while(true) {
            System.out.println(
                "\n\nChoose a lab:\n\t" + 
                MULT_TABLE + " - Multiplication Table" + "\n\t" +
                STAR_PLOT + " - Star Tree" + "\n\n\t" +
                END + " - End Program"
                
            );
            int labChoice = cons.readInt();
            switch(labChoice) {
                case END:
                    System.out.println("Ending program...");
                    try {
                        TimeUnit.SECONDS.sleep(2);
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
}