package Gridworld;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.print("Enter a palindrome: ");
    String input = inp.nextLine();
    if(isPalindrome(input)) {
      System.out.println("\nThis is a palindrome");
    } else {
      System.out.println("\nThis is not a palindrome");
    }
    
  }

  public static boolean isPalindrome(String input) {
    String toTest = "";
    for(int i = 0; i < input.length(); i++) {
      if(Character.isLetterOrDigit(input.charAt(i))) {
        toTest += Character.toLowerCase(input.charAt(i));
      }
    }

    String reversed = "";
    for(int i = toTest.length()-1; i >= 0; i--) {
      reversed += toTest.charAt(i);
    }

    return reversed.equals(toTest);
  }
}