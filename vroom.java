import chn.util.ConsoleIO;
import java.lang.Integer;

public class vroom {
    public static void kachow() {
        
        /*
         * This method uses the ConsoleIO class to take the input of the make, model, and license
         * plate of a car and provides a code, similar to those used in rental car agencies, 
         * for each car.
         */
        ConsoleIO cons = new ConsoleIO();

        String inLetters, make, model;
        int inNumbers, total;
        char c1, c2, c3, letter;
        
        System.out.println("Enter Make: ");
        make = cons.readLine();
        
        System.out.println("Enter model: ");
        model = cons.readLine();
        
        System.out.println("Enter License Plate FORMAT: (LETTERS NUMBERS)");
        inLetters = cons.readToken();
        inNumbers = cons.readInt();

        c1 = inLetters.charAt(0);
        c2 = inLetters.charAt(1);
        c3 = inLetters.charAt(2);

        total = c1 + c2 + c3 + inNumbers;
        letter = (char) ((total % 26) + 'A');

        System.out.println(letter + Integer.toString(total));
    }
}