package Lesson_5;

import chn.util.ConsoleIO;
import apcslib.Format;
import java.lang.Double;

public class IRSsim {

    private static final double FEDTAX = 0.15;
    private static final double FICA = 0.0765;
    private static final double STATETAX = 0.04;

    public static void doMyTaxReturns() {
        ConsoleIO cons = new ConsoleIO();
        double hourly, gross, net, amnt;
        int hours;

        System.out.println("Enter hours worked per week");
        hours = cons.readInt();

        System.out.println("Enter hourly salary");
        hourly = cons.readDouble();

        gross = hours * hourly;

        System.out.println("Your gross salary is: " + gross);

        net = gross;
        
        
        net *= 1 - FEDTAX;
        amnt = gross * FEDTAX;
        
        System.out.println("Federal Income Tax: " + Format.right(amnt, 5, 2));
        
        net *= 1 - FICA;
        amnt = gross * (FICA);
        
        System.out.println("FICA Tax: " + Format.right(amnt, 5, 2));
        
        net *= 1 - STATETAX;
        amnt = gross * STATETAX;
        
        System.out.println("State Tax: " + Format.right(amnt, 5, 2));
        System.out.println("Net Pay: " + Format.right(net, 5, 2));

        
    }
}