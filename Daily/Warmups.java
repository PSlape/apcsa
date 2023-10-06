package Daily;
import chn.util.ConsoleIO;

public class Warmups {
    static final int geese = 5;
    static final int meese = 6;
    static final double neese = 3.885893489385893920020924;
    
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        
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
}