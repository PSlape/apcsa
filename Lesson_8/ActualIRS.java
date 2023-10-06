package Lesson_8;


import chn.util.ConsoleIO;
import apcslib.Format;
import java.lang.Exception;

public class ActualIRS {
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        
        System.out.println("Enter filing status: Single or Married?");
        System.out.print("Status: ");
        String status = cons.readToken();
        
        System.out.print("Enter taxable income: ");
        double income = cons.readDouble();
        
        Taxpayer client = new Taxpayer(status, income);
        System.out.println("Your federal tax owed is: " + client.calculateTax());
    }
    
}

class Taxpayer {
    private double income;
    private String status;
    
    public Taxpayer() {
        income = 0;
        status = "single";
    }
    public Taxpayer(String status, double income) {
        this.status = status;
        this.income = income;
    }
    double calculateTax() {
        if(status.equalsIgnoreCase("married")) {
            return marriedTax(income);
        } else if(status.equalsIgnoreCase("single")) {
            return singleTax(income);
        }
        return 0;
    }
    private static double marriedTax(double income){
        if(income >= Constants.TAX_E_MIN) {
            return Constants.TAX_E_FLAT_M + (Constants.TAX_E_PER * income);
        } else if(income >= Constants.TAX_D_MIN_M) {
            return Constants.TAX_D_FLAT_M + (Constants.TAX_D_PER * income);
        } else if(income >= Constants.TAX_C_MIN_M) {
            return Constants.TAX_C_FLAT_M + (Constants.TAX_C_PER * income);
        } else if(income >= Constants.TAX_B_MIN_M) {
            return Constants.TAX_B_FLAT_M + (Constants.TAX_B_PER * income);
        } else if(income >= 0) {
            return Constants.TAX_A * income;
        }
        return 0;
    }
    private static double singleTax(double income) {
        if(income >= Constants.TAX_E_MIN) {
            return Constants.TAX_E_FLAT_S + (Constants.TAX_E_PER * income);
        } else if(income >= Constants.TAX_D_MIN_S) {
            return Constants.TAX_D_FLAT_S + (Constants.TAX_D_PER * income);
        } else if(income >= Constants.TAX_C_MIN_S) {
            return Constants.TAX_C_FLAT_S + (Constants.TAX_C_PER * income);
        } else if(income >= Constants.TAX_B_MIN_S) {
            return Constants.TAX_B_FLAT_S + (Constants.TAX_B_PER * income);
        } else if(income >= 0) {
            return Constants.TAX_A * income;
        }
        return 0;
    }
    
}