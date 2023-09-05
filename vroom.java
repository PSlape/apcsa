import chn.util.ConsoleIO;

public class vroom {
    public static void kachow(String[] args) {

        ConsoleIO cons = new ConsoleIO();

        String inLetters, make, model;
        int inNumbers, total;
        char c1, c2, c3, letter;

        System.out.println("Enter License Plate FORMAT: (LETTERS NUMBERS)");
        inLetters = cons.readToken();
        inNumbers = cons.readInt();

        c1 = inLetters.charAt(0);
        c2 = inLetters.charAt(1);
        c3 = inLetters.charAt(2);

        total = c1 + c2 + c3 + inNumbers;
        letter = (char) ((total % 4) + 'A');

        System.out.println(letter + total.toString());
    }
}