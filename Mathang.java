import java.lang.*;

public class Mathang {
    public static void runMathang() {
        
        int ans1 = 4 + 9;
        double ans2 = 46 / 7;
        int ans3 = 46 % 7;
        double ans4 = 2 * 3.0;
        double ans5 = 25 / 4;
        int ans6 = (int) 7.75 + 2;
        int ans7 = (int) 'p';
        char ans8 = (char) 105;

        System.out.println("4 + 9 =" + ans1);
        System.out.println("46 / 7 = " + ans2);
        System.out.println("46 % 7 = " + ans3);
        System.out.println("2 * 3.0 = " + ans4);
        System.out.println(" 25 / 4 = " + ans5);
        System.out.println("7.75 + 2 = " + ans6);
        System.out.println("(int) 'p'" + ans7);
        System.out.println("(char) 105 = " + ans8);

        System.out.println("Largest int: " + Integer.MAX_VALUE);
        System.out.println("Smallest int: " + Integer.MIN_VALUE);
        System.out.println("Largest double: " + Double.MAX_VALUE);
        System.out.println("Smallest double: " + Double.MIN_VALUE);
    }
}
