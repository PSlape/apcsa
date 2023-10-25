package Lesson_10;

import chn.util.ConsoleIO;
import apcslib.Format;
/*
 * Purpose: To use while loops
 */
/**
 * Gives the total interest paid off with a provided principal and annual rate
 * 
 * @author Peyton Slape
 * @version Lab 10.2
 */
public class Payments {
    private static final int SPACES = 15;
    
    private static double principal, annualRate, payment, interest, balance, totalInterest;
    private static int month;
    private static ConsoleIO cons = new ConsoleIO();
    public static void main(String[] args) {
        
        
        principal = PaymentMethods.getInput("Enter your amount borrowed: ");
        annualRate = PaymentMethods.getInput("Enter annual interest rate. Format as XX: ") / 100;
        payment = PaymentMethods.getInput("Enter monthly payment: ");
        
        double monthlyRate = annualRate / 12;
        balance = principal;
        month = 0;
        
        firstOutput();
        
        do {
            interest = principal * monthlyRate;
            balance += interest - payment;
            month++;
            if(balance > 0) {
                getOutput();
                totalInterest += interest;
                principal = balance;
            }
        } while(balance > 0);
        
        System.out.println(
            Format.center(
                Double.toString(PaymentMethods.roundTo(totalInterest, 2)) + " total interest", SPACES * 5
            )
        );
    }
    
    /**
     * Prints out the first output with the table headers
     */
    private static void firstOutput() {
        System.out.println(
            Format.center("Month", SPACES) + 
            Format.center("Principal", SPACES) +
            Format.center("Interest", SPACES) + 
            Format.center("Payment", SPACES) + 
            Format.center("New Balance", SPACES)
        );
    }
    /**
     * Prints out the output for one line
     */
    private static void getOutput() {
        System.out.println(
            Format.center(month, SPACES) +
            Format.center(principal, SPACES, 2) + 
            Format.center(interest, SPACES, 2) +
            Format.center(payment, SPACES, 2) +
            Format.center(balance, SPACES, 2)
        );
    }
    
}
