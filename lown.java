// L.A.9.1
import java.lang.Math;
import apcslib.Format;

public class lown {
    public static void main() {
        
    }
    
    private static double calculateLoan(double amnt, int years, double intRate) {
        return (amnt * (intRate / 12) * Math.pow(1+(intRate / 12), years * 12)) / (Math.pow(1 + (intRate / 12), years * 12) - 1);
    }
    private static void calculateLoan(double amnt, int years, double intRateLow, double intRateHigh) {
        double counter = intRateHigh;
        System.out.println("Annual Interest Rate        Monthly Payment");
        while(counter >= 0) {
            System.out.println(Format.left(counter, 5, 2) + Format.right(calculateLoan(amnt, years, counter), 10, 2));
        }
    }
}