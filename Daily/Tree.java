package Daily;

import chn.util.ConsoleIO;
import apcslib.Format;

/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    public static void main(String[] args) {
        System.out.print("Size: ");
        int size = new ConsoleIO().readInt();
        for(int i = size; i > 0; i--) System.out.println(Format.right("*", i) + Format.right("*", (size + 1 - i) * 2));
        for(int i = size*2+1; i > 0; i--) System.out.print("*");
    }
}
