package Lesson_10;

import chn.util.ConsoleIO;
import apcslib.Format;
/**
 * Name: Peyton Slape
 * Lab: 10.2
 * Description: Gives you the total interest you would pay off depending on your monthly interest rate
 * Purpose: Practice with do-while loops
 */
public class Payments {
    private static final int SPACES = 15;
    
    private static double principal, annualRate, payment, interest, balance, totalInterest;
    private static int month;
    private static ConsoleIO cons = new ConsoleIO();
    public static void main(String[] args) {
        
        
        principal = getInput("Enter your amount borrowed: ");
        annualRate = getInput("Enter annual interest rate. Format as XX: ") / 100;
        payment = getInput("Enter monthly payment: ");
        
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
                Double.toString(roundTo(totalInterest, 2)) + " total interest", SPACES * 5
            )
        );
    }
    
    private static double getInput(String in) {
        System.out.print(in);
        return cons.readDouble();
    }
    private static void firstOutput() {
        System.out.println(
            Format.center("Month", SPACES) + 
            Format.center("Principal", SPACES) +
            Format.center("Interest", SPACES) + 
            Format.center("Payment", SPACES) + 
            Format.center("New Balance", SPACES)
        );
    }
    private static void getOutput() {
        System.out.println(
            Format.center(month, SPACES) +
            Format.center(principal, SPACES, 2) + 
            Format.center(interest, SPACES, 2) +
            Format.center(payment, SPACES, 2) +
            Format.center(balance, SPACES, 2)
            
        );
    }
    private static double roundTo(double num, int spaces) {
        int numRound = (int) (num *  Math.pow(10, spaces));
        return (double) numRound / Math.pow(10, spaces);
    }
}
