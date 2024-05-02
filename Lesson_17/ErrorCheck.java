package Lesson_17;

import chn.util.ConsoleIO;

/* 
 * Name: Peyton Slape
 * Lab: 17.1
 * Date: 4/30/24
 * Description: Banking system with errors.
 * Purpose: Learn how to use exceptions/try-catch statements.
 */
public class ErrorCheck
{
    private static final ConsoleIO cons = new ConsoleIO();
    
    public static void main(String[] args) {
        CheckingAccount errorFree = null;
        System.out.println("ErorFreeChecking Test\n");
        while(true) {
            try {
                System.out.print("\nEnter initial account balance: ");
                errorFree = new CheckingAccount(cons.readDouble());
                break;
            } catch(IllegalArgumentException ex) {
                System.out.print("Invalid entry. Try again: ");
            }
        }
        
        if(errorFree == null) throw new NullPointerException("Account initialization failed.");
        
        String in = null;
        while(true) {
            if(in == null) {
                System.out.print("\nWould you like to make a deposit or withdrawal: ");
                in = cons.readToken();
            }
            if(in.equalsIgnoreCase("deposit")) {
                try {
                    System.out.print("\n\nPlease enter amount to deposit: ");
                    errorFree.deposit(cons.readDouble());
                } catch(IllegalArgumentException ex) {
                    System.out.println("Invalid amount entered. Try again.");
                    in = "deposit";
                    continue;
                }
            } else if(in.equalsIgnoreCase("withdraw") || in.equalsIgnoreCase("withdrawal")) {
                try {
                    System.out.print("\n\nPlease enter amount to withdraw: ");
                    errorFree.withdraw(cons.readDouble());
                } catch(IllegalArgumentException ex) {
                    System.out.println("Invalid amount entered. Try again.");
                    in = "withdraw";
                    continue;
                } catch(UnsupportedOperationException ex) {
                    System.out.println("Account balance too low for transaction.");
                    System.out.println("Current account balance = " + errorFree.getBalance());
                    in = null;
                    continue;
                }
            } else if(in.equalsIgnoreCase("exit") || in.equalsIgnoreCase("quit")) {
                System.out.println("\nThank you for using ErrorFreeChecking. Goodbye!");
                break;
            } else {
                System.out.println("\nInvalid Entry.");
            }
            System.out.println(in + " made. Current account balance = " + errorFree.getBalance());
            in = null;
        }
    }
    
}
