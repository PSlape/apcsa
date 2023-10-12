package Lesson_9;

import chn.util.ConsoleIO;
import apcslib.Format;

/**
 * Name: Peyton Slape
 * Date: 10/9/23
 * Lab: 9.1
 * Description: Gives you the amount you would pay each month for different interest rates
 * Purpose: To use while loops
 */
public class Loan {
    private static double prince, time, lowRate, highRate;
    private static final int indent = 30;
    public static void main(String[] args) {
        ConsoleIO cons = new ConsoleIO();
        
        System.out.print("Principal = ");
        prince = cons.readDouble();
        
        System.out.print("Time = ");
        time = cons.readDouble();
        
        System.out.print("Low Rate = ");
        lowRate = cons.readDouble();
        
        System.out.print("High Rate = ");
        highRate = cons.readDouble();
        
        if(lowRate >= 1) {
            lowRate *= 0.01;
        }
        if(highRate >= 1) {
            highRate *= 0.01;
        }
        System.out.println(
            Format.center("Annual Interest Rate", indent) +
            Format.center("Monthly Payment", indent)
        );
        printResults();
    }
    private static void printResults() {
        double currentRate = lowRate;
        while(currentRate <= highRate) {
            System.out.print(formatRate(currentRate));
            System.out.println(formatPay(calcFromRate(currentRate)));
            currentRate += 0.0025;
        }
    }
    private static double calcFromRate(double currentRate) {
        return (prince * currentRate) / 12;
    }
    private static String formatRate(double in) {
        return Format.center(in * 100, indent, 2);
    }
    private static String formatPay(double in) {
        return Format.center(in, indent, 2);
    }
}
