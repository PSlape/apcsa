package Lesson_5;

import chn.util.ConsoleIO;
import apcslib.Format;
import java.lang.Double;

public class IRSsim {

    private static final double FEDTAX = 0.15; // Federal Income Tax
    private static final double FICA = 0.0765; // Social Security Tax
    private static final double STATETAX = 0.04; // State Income Tax

    public static void doMyTaxReturns() {
        ConsoleIO cons = new ConsoleIO();
        double hourly, gross, net, amnt; // Declares variables
        int hours;

        System.out.print("Enter hours worked per week");
        hours = cons.readInt(); // Reads hours worked

        System.out.println("Enter hourly salary");
        hourly = cons.readDouble(); // Reads salary

        gross = hours * hourly; // Gets gross pay

        System.out.println("Your gross salary is: " + Format.right(gross, 5, 2));

        net = gross;
        
        
        net *= 1 - FEDTAX; // Gets pay after federal income tax.
        amnt = gross * FEDTAX;
        
        System.out.println("Federal Income Tax: " + Format.right(amnt, 5, 2));
        
        net *= 1 - FICA; // Gets pay after FICA tax
        amnt = gross * FICA;
        
        System.out.println("FICA Tax: " + Format.right(amnt, 5, 2));
        
        net *= 1 - STATETAX; // Gets pay after state tax
        amnt = gross * STATETAX;
        
        System.out.println("State Tax: " + Format.right(amnt, 5, 2));
        System.out.println("Net Pay: " + Format.right(net, 5, 2));

        
    }
}