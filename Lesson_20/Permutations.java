package Lesson_20;

import java.util.*;

import apcslib.Format;
/*
 * Name: Peyton Slape
 * Date: 1/17/24
 * Lab: 20.2
 * Purpose: ArrayList manipulation
 * Description: Generates ArrayLists filled with random numbers, gives the sum of the ends.
 */
public class Permutations {
    public static void main(String[] args) {
        Random rand = new Random();
        
        for(int i = 1; i <= 10; i++) {
            ArrayList<Integer> array = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();
            for(int ind = 1; ind <= 10; ind++) {
                array.add(ind);
            }
            
            while(!array.isEmpty()) {
                array2.add(
                    array.remove(
                        rand.nextInt(array.size())
                ));
            }
            
            int sum = array2.get(0) + array2.get(array2.size() - 1);
            System.out.println("List" + Format.right(i + ":", 4) + Format.center(listToString(array2), 56) + "Sum of first and last: " + sum);
            
            array.clear();
            array2.clear();
        }
    }
    
    public static String listToString(ArrayList list) {
        String out = "[";
        for(Object obj : list) {
            if(list.lastIndexOf(obj) != list.size()-1) {
                out += Format.left(obj.toString() + ",", 4);
            } else {
                out += obj.toString();
            }
        }
        return out + "]";
    }
}
