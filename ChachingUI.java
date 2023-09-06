import java.util.Scanner;
import chn.util.ConsoleIO;
import apcslib.Format;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChachingUI { // DOES NOT WORK
    
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    
    private String costStr, paidStr;
    
    private JFrame frame, tooltip;
    private JPanel panel;
    private JButton addGrade, giveGrade;
    private JTextField costIn, paidIn, output;
    private JTextField[] coinFields;
    
    public static void main() {
        
    }
    
    public ChachingUI() {
        frame = new JFrame("GPA Calculator");
        tooltip = new JFrame("Error");
        
        panel = new JPanel();

        addGrade = new JButton("Add Grade");
        giveGrade = new JButton("Calculate Final GPA");
        
        coinFields = new JTextField[4];
        
        costIn = new JTextField(4);
        paidIn = new JTextField(4);
        
        for(int i = 0; i < coinFields.length-1; i++) {
            coinFields[i] = new JTextField(2);
        }
        
    }
    
    public int[] calculateCoins(double amnt, double paid) {
        boolean doesOwe;
        double temp, change;
        int qrt, dm, nk, pn;

        change = amnt - paid;
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
        qrt = (int) (change / 25); // Gets the number of quarters
        temp = change % 25; // Gets the leftover money for the next calculation

        dm = (int) (temp / 10); // Gets the number of dimes
        temp = temp % 10; // Gets the leftover money for the next calculation

        nk = (int) (temp / 5); // Gets the number of nickels
        temp = temp % 5; // Gets the leftover money for the next calculation
        pn = (int) temp; // Leftover money is now pennies
            
        int[] sample = {qrt, dm, nk, pn};
        return sample;
        

    }
}
