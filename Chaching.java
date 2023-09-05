import java.util.Scanner;
import chn.util.ConsoleIO;
import apcslib.Format;

public class Chaching {

    public static void gimmeDaMoney() {
        boolean doesOwe;
        double temp;
        int qrt, dm, nk, pn;

        ConsoleIO inp = new ConsoleIO();

        System.out.print("Amount of Purchase: ");
        double amnt = inp.readDouble(); // Takes input for the price of the transaction
        System.out.println(" ");

        System.out.print("Amount paid: ");
        double paid = inp.readDouble(); // Takes input for the amount of cash tendered
        System.out.println(" ");

        double change = paid - amnt;
        
        if(change > 1) {
            change -= Math.floor(change);
        }
        change *= 100;
        change += 0.01;

        int changeAsInt = (int) change;

        if(change < 0) {
            doesOwe = true;
        } else {
            doesOwe = false;
        }


        if(!doesOwe) {
            qrt = (int) (change / 25); // Gets the number of quarters
            temp = change % 25; // Gets the leftover money for the next calculation

            dm = (int) (temp / 10); // Gets the number of dimes
            temp = temp % 10; // Gets the leftover money for the next calculation

            nk = (int) (temp / 5); // Gets the number of nickels
            temp = temp % 5; // Gets the leftover money for the next calculation

            pn = (int) temp; // Leftover money is now pennies
            
            System.out.println("Amount of coins needed: " + "\n");
            
            System.out.println(Format.right(changeAsInt, 4) + " cents");
            System.out.println(Format.right(qrt, 5) + " quarters");
            System.out.println(Format.right(dm, 5) + " dimes");
            System.out.println(Format.right(nk, 5) + " nickels");
            System.out.println(Format.right(pn, 5) + " pennies");
        } else {
            System.out.println("You owe: " + changeAsInt + " cents");
        }

    }
}