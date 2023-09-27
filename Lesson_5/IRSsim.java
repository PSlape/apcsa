package Lesson_5;

import chn.util.ConsoleIO;
import apcslib.Format;
import java.lang.Double;

/*
 * Name: Peyton Slape
 * Lab: 5.1
 * Description: Returns the net pay after an input of hours worked and salary.
 * Purpose: To practice input and output.
 */

public class IRSsim {

    private static final double FEDTAX = 0.15;
    private static final double FICA = 0.0765; // Initialize tax percentages.
    private static final double STATETAX = 0.04;

    public static void doMyTaxReturns() {
        ConsoleIO cons = new ConsoleIO();
        double hourly, gross, net, amnt;
        int hours;

        System.out.print(Format.left("Enter hours worked per week: ", 25));
        hours = cons.readInt(); 

                // Takes input for salary
        System.out.print(Format.left("Enter hourly salary: ", 25));
        hourly = cons.readDouble(); 

<<<<<<< HEAD
                // Calculates gross pay
        gross = hours * hourly; 
        System.out.println(Format.left("\nYour gross salary is: ", 26) + Format.right(gross, 5, 2));
=======
        gross = hours * hourly;
        System.out.println("Your gross salary is: " + gross);
>>>>>>> 01091e9059fbb1443c66a5a81b353b2298edba42

        net = gross;
        
<<<<<<< HEAD
                // Calculates federal income tax.
=======
>>>>>>> 01091e9059fbb1443c66a5a81b353b2298edba42
        amnt = gross * FEDTAX;
<<<<<<< HEAD
        net -= amnt; 
        System.out.println(Format.left("\nFederal Income Tax: ", 26) + Format.right(amnt, 5, 2));
        
                // Calculates social security tax.
=======
        System.out.println("Federal Income Tax: " + Format.right(amnt, 5, 2));
        
>>>>>>> 01091e9059fbb1443c66a5a81b353b2298edba42
        amnt = gross * (FICA);
<<<<<<< HEAD
        net -= amnt; 
        System.out.println(Format.left("FICA Tax: ", 25) + Format.right(amnt, 5, 2));
        
=======
        System.out.println("FICA Tax: " + Format.right(amnt, 5, 2));
>>>>>>> 01091e9059fbb1443c66a5a81b353b2298edba42
        
<<<<<<< HEAD
                // Calculates state income tax.
=======
>>>>>>> 01091e9059fbb1443c66a5a81b353b2298edba42
        amnt = gross * STATETAX;
<<<<<<< HEAD
        net -= amnt; 
        System.out.println(Format.left("State Tax: ", 25) + Format.right(amnt, 5, 2));
        
                // Prints out the net pay.
        System.out.println(Format.left("\nNet Pay: ", 26) + Format.right(net, 5, 2));
=======
        System.out.println("State Tax: " + Format.right(amnt, 5, 2));
        
        net *= 1 - STATETAX - FICA - STATETAX;
        System.out.println("Net Pay: " + Format.right(net, 5, 2));
>>>>>>> 01091e9059fbb1443c66a5a81b353b2298edba42
    }
}