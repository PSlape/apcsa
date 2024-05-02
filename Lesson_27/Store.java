package Lesson_27; 

import apcslib.Format;                 
import chn.util.FileInput;
/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    private Item[] storage;
    
    public Store(String fileName) {
        FileInput inp = new FileInput(fileName);
        storage = new Item[inp.readInt()];
        int cnt = 0;
        while(inp.hasMoreLines()) {
            storage[cnt++] = new Item(inp.readInt(), inp.readInt());
        }
    }
    
    public static void main() {
        Store store = new Store("C:\\Users\\Mudzg\\CSA\\duplicates\\apcsa\\Lesson_27\\file50.txt");
        store.display();
    }
    
    public void display() {
        sort();
        String out = Format.right("ID", 8) + Format.right("Inv", 8) + "\n"; 
        for(int i = 0; i < storage.length; i++) {
            out += Format.left(i, 6) + storage[i].toString() + "\n";
        }
        System.out.println(out);
    }
    
    public void sort() {
        quickSort(storage, 0, storage.length-1);
    }
    
    public static void quickSort(Item[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static void swap(Item[] arr, int i, int j)
    {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition(Item[] arr, int low, int high)
    {
        Item pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    public Item[] getItems() {
        return storage;
    }
}

