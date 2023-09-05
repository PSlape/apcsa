import chn.util.ConsoleIO;
import java.lang.Math;
import java.lang.Integer;

public class Quadratic {
    public static void quadFormula() {
        ConsoleIO cons = new ConsoleIO();
        

        System.out.println("Input a b and c, all one space apart. Put negative symbols directly next to the number.");
        double a = cons.readDouble();
        double b = cons.readDouble();
        double c = cons.readDouble();

        double internal = Math.pow(b, 2) - (4 * a * c);

        if(internal < 0) return;
        
        double x1 = ((-1 * b) + Math.sqrt(internal)) / (2 * a);
        double x2 = ((-1 * b) - Math.sqrt(internal) / (2 * a));

        System.out.println("The x intercepts are located at: " + x1 + " " + x2);
    }
}