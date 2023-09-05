import java.util.Scanner;

public class Chaching {

    public static void gimmeDaMoney(String[] args) {
        boolean doesOwe;
        double temp;
        int qrt, dm, nk, pn;

        Scanner inp = new Scanner(System.in);

        System.out.print("Amount of Purchase: ");
        double amnt = inp.nextDouble(); 
        System.out.println(" ");

        System.out.print("Amount paid: ");
        double paid = inp.nextDouble();
        System.out.println(" ");

        double change = paid - amnt;
        change *= 100;
        change += 0.01;

        int changeAsInt = (int) change;

        if(change < 0) {
            change *= -1;
            doesOwe = true;
        } else {
            doesOwe = false;
        }


        if(!doesOwe) {
            qrt = (int) (change / 25);
            temp = change % 25;

            dm = (int) (temp / 10);
            temp = temp % 10;

            nk = (int) (temp / 5);
            temp = temp % 5;

            pn = (int) temp;
            
            
            System.out.println("Total Change: " + changeAsInt + " cents");
            System.out.println("Quarters: " + qrt);
            System.out.println("Dimes: " + dm);
            System.out.println("Nickels: " + nk);
            System.out.println("Pennies: " + pn);
        } else {
            System.out.println("You owe: " + changeAsInt + " cents");
        }

    }
}