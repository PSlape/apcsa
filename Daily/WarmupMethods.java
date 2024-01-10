package Daily;

import CSAClasses.CustomFormat;
import Lesson_10.PicturesMethods;

/**
 * Write a description of class WarmupMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarmupMethods {
    private double a, b;
    
    public WarmupMethods() {
        a = 0;
        b = 0;
    }
    public WarmupMethods(double a, double b) {
        this.a = a;
        this.b = b;
    }
    double product() {
        return a * b;
    }
    double getA() {
        return a;
    }
    double getB() {
        return b;
    }
    
    public static void drawTable(int rows, int cols) {
        for(int i = 0; i < rows+1; i++) {
            System.out.print(CustomFormat.left(Integer.toString(i), 5));
            if(i != 0) {
                for(int j = 1; j < cols+1; j++) {                
                    if(i * j >= 100) { // If the value has 3 digits, it prints out a space with 2 less characters
                        System.out.print(i * j + PicturesMethods.LESSER_SPACE); 
                    } else if( i * j >= 10) { // If the value has 2 digits, it prints out a space with 1 less character
                        System.out.print(i * j + PicturesMethods.LESS_SPACE); 
                    } else {
                        System.out.print(i * j + PicturesMethods.SPACE); // If the value has 1 digit, it prints out the normal sized space
                    }
                }
            } else {
                for(int j = 1; j < cols+1; j++) {
                    if(j > 100) {
                        System.out.print(j + PicturesMethods.LESSER_SPACE);
                    } else if(j > 10) {
                        System.out.print(j + PicturesMethods.LESS_SPACE);
                    } else {
                        System.out.print(j + PicturesMethods.SPACE);
                    }
                }
            }
            if(rows == 1) System.out.println();
            System.out.print("\n"); // Gets ready to print the next row
        }
    }
    
    public static void drawTree(int lines) {
        if(lines % 2 != 0) {
            System.out.println("Tree must have an even number of lines");
            return;
        }
        int numOfChar = -1;
        double center = lines / 2.0;
        for(int i = lines-1; i >= 0; i -= 1) {
            String toFormat = "";
            numOfChar += 2;
            for(int j = 0; j < numOfChar; j++) {
                toFormat += "*";
            }
            System.out.println(CustomFormat.right(toFormat, i));
        }
        System.out.println(CustomFormat.right("*", lines-1));
    }
    
    public static void test() {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        String d = a;
        System.out.println(
            "String a = \"hello\"" + "\n" + 
            "String b = \"hello\"" + "\n" + 
            "String c = new String(\"hello\")" + "\n" + 
            "String d = a" + "\n\n"
        );
        if(a == b) System.out.println("a = b"); else System.out.println("a != b");
        if(a == c) System.out.println("a = c"); else System.out.println("a != b");
        if(b == c) System.out.println("b = c"); else System.out.println("a != b");
        if(d == b) System.out.println("d = b"); else System.out.println("a != b");
    }
    
    public String reverseString(String str) {
        String toReturn = "";
        for(int i = str.length()-1; i > 0; i--) {
            toReturn += str.charAt(i);
        }
        return toReturn;
    }
    
    public int findVowel(String str) {
        for(char ch : str.toCharArray()) {
            if(isVowel(ch)) return str.indexOf(ch);
        }
        return -1;
    }
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        switch(ch) {
            case 'a', 'e', 'i', 'o', 'u':
                return true;
            default:
                return false;
        }
    }
}
