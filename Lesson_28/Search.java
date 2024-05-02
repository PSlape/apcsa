package Lesson_28;

import chn.util.ConsoleIO;
import Lesson_27.*;
/**
 * Write a description of class Search here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Search
{
    public static void main (String[] args)    
    {
        // test of methods from LA27.1 - sorting the database
        Store miniMart = new Store("C:\\Users\\Mudzg\\CSA\\duplicates\\apcsa\\Lesson_27\\file50.txt");
        System.out.println("Database before sorted: ");
        System.out.println();
        miniMart.display();
        miniMart.sort();
        System.out.println();
        System.out.println("Database after sorted by id: ");
        System.out.println();
        miniMart.display();
                   
        // test of methods from LA28.1 - searching the database
        testSearch(miniMart);
    }
    
    public static void testSearch(Store store)
    {
      int idToFind;
      int invReturn;
      int index;
      var myStore = store.getItems();

      ConsoleIO console = new ConsoleIO();
    
      System.out.println("Testing search algorithm\n");
      System.out.print("Enter Id value to search for (-1 to quit) ---> ");
      idToFind = console.readInt();
      while (idToFind >= 0)
      {
        // calling iterative version of binary search  
        index = bsearch(myStore, new Item(idToFind, 0));
        System.out.print("Iterative binary search: Id # " + idToFind);
        if (index == -1)
          System.out.println("     No such part in stock");
        else
          System.out.println("     Inventory = " + myStore[index].getInv());
    
        // calling recursive version of binary search
        index = bsearch(myStore, new Item(idToFind, 0), 0, myStore.length-1);
        System.out.print("Recursive binary search: Id # " + idToFind);
        if (index == -1)
          System.out.println("     No such part in stock");
        else
          System.out.println("     Inventory = " + myStore[index].getInv());    
              
        System.out.print("\nEnter Id value to search for (-1 to quit) ---> ");
        idToFind = console.readInt();
      }
    }
    
    /**
     *  Searches the myStore array of Item Objects for the specified
     *  item object using a iterative binary search algorithm
     *
     * @param  idToSearch  Item object containing Id value being search for
     * @return             index of Item if found, -1 if not found
     */
    static int bsearch(Item[] arr, Item idToSearch) {
        int first = 0;
        int last = arr.length-1;
        int mid;
        
        while(true) {
            mid = (int) Math.ceil((((double) (last - first) / 2.0) + (double) first));
            if(arr[mid].compareTo(idToSearch) == 0) {
                return mid;
            } else if(last - first <= 1) {
                return -1;
            } else if(arr[mid].compareTo(idToSearch) < 0) {
                first = mid;
            } else if(arr[mid].compareTo(idToSearch) > 0){
                last = mid;
            } else {
                return -1;
            }
        }
    }
    
    /**
     *  Searches the specified array of Item Objects for the specified
     *  item object using a recursive binary search algorithm
     *
     * @param  idToSearch  Item object containing Id value being search for
     * @param  first       Starting index of search range
     * @param  last        Ending index of search range
     * @return             index of Item if found, -1 if not found
     */ 
    static int bsearch (Item[] arr, Item idToSearch, int first, int last) {
        int mid = (int) Math.ceil((((double) (last - first) / 2.0) + (double) first));
        int compareNum = arr[mid].compareTo(idToSearch);
        
        if(compareNum == 0) {
            return mid;
        } else if(last - first <= 1) {
            return -1;
        } else if(compareNum < 0) {
            return bsearch(arr, idToSearch, mid, last);
        } else if(compareNum > 0){
            return bsearch(arr, idToSearch, first, mid);
        } else {
            return -1;
        }
    }
    
}

