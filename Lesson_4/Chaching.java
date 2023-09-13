package Lesson_4;

import chn.util.ConsoleIO;
import apcslib.Format;

/*
 * Name: Peyton Slape
 * Lab: L.A.4.1
 * Date: 9/6/23
 * Description: Uses the ConsoleIO class to get input and give the amount of each coin 
 *              a cashier should give based on amount owed and paid.
 * Purpose: To learn basic user input and output.
 */

public class Chaching {

    public static void gimmeDaMoney() {
        
        /*
         * This method uses the ConsoleIO class from chn.util to take user input. The input
         * is in the form of doubles, the price of the transaction and the amount of money paid.
         * It will print out the amount of change the cashier should give to the customer,
         * telling how many of each coin the cashier should give.
         */
        
        boolean doesOwe;
        double temp; // Initializes variables
        int qrt, dm, nk, pn; 

        ConsoleIO inp = new ConsoleIO();

        System.out.print("Amount of Purchase: ");
        double amnt = inp.readDouble(); // Takes input for the price of the transaction
        System.out.println(" ");

        System.out.print("Amount paid: ");
        double paid = inp.readDouble(); // Takes input for the amount of cash tendered
        System.out.println(" ");

        double change = paid - amnt; // Gets the total change based on input values
        
        if(change > 1) {
            change -= Math.floor(change);
        }
        change *= 100; // Modifies change to a whole number
        change += 0.01; // Modifies change to account for errors

        int changeAsInt = (int) change;

        if(change < 0) { // Checks if the change is negative
            doesOwe = true; 
        } else {
            doesOwe = false;
        }


        if(!doesOwe) { // If the change is negative, this section does not run
            qrt = (int) (change / 25); // Gets the number of quarters
            temp = change % 25; // Gets the leftover money for the next calculation

            dm = (int) (temp / 10); // Gets the number of dimes
            temp = temp % 10; // Gets the leftover money for the next calculation

            nk = (int) (temp / 5); // Gets the number of nickels
            temp = temp % 5; // Gets the leftover money for the next calculation

            pn = (int) temp; // Leftover money is now pennies
            
            System.out.println("Amount of coins needed: " + "\n");
            
            System.out.println(Format.right(changeAsInt, 4) + " cents"); // prints the total change, with formatting
            System.out.println(Format.right(qrt, 5) + " quarters"); // Prints the number of quarters to returned
            System.out.println(Format.right(dm, 5) + " dimes"); // Prints the number of dimes to be returned
            System.out.println(Format.right(nk, 5) + " nickels"); // Prints the number of nickels to be returned
            System.out.println(Format.right(pn, 5) + " pennies"); // Prints the number of pennies to be returned
        } else {
            System.out.println("You owe: " + changeAsInt + " cents"); // Says if the paid amount is less than the total, and how much is owed.
        }

    }
}