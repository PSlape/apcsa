package Lesson_19;

import java.lang.reflect.Array;
/**
 * Write a description of class DynamicIntArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DynamicIntArray {
    public static final int DEFAULT_CAPACITY = 10;
    
    private transient Integer[] array;
    private int furthestStoredIndex = 0;
    
    
    /**
     * Initializes a new DynamicIntArray with the default length.
     */
    public DynamicIntArray() {
        array = new Integer[DEFAULT_CAPACITY];
    }
    
    
    /**
     * Initializes a new DynamicIntArray with a defined length.
     * 
     * @param length The length the DynamicIntArray will be.
     */
    public DynamicIntArray(int length) {
        if(length > 0) {
            array = new Integer[length];
        } else {
            array = new Integer[DEFAULT_CAPACITY];
        }
    }
    
    /**
     * Increases the capacity of the DynamicIntArray, if the desired length is greater than the current length.
     * 
     * @param length The desired minimum capacity
     */
    public void ensureCapacity(int length) {
        if(length > array.length) {
            Integer[] tempArray = new Integer[length];
            for(int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
    }
    
    /**
     * Appends an object to the array.
     * 
     * @param element The object to be added
     */
    public void append(int element) {
        while(true) {
            try {
                array[furthestStoredIndex] = element;
                furthestStoredIndex++;
                break;
            } catch(ArrayIndexOutOfBoundsException ex) {
                ensureCapacity(furthestStoredIndex + 1);
            }
        }
    }
    
    public void append(DynamicIntArray arr) {
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) != null) {
                append(arr.get(i));
            }
        }
    }
    
    public void append(Integer[] arr) {
        for(int element : arr) {
            append(element);
        }
    }
    
    /**
     * Adds an object to the array.
     * 
     * @param element The object to be added
     */
    public void add(int element) {
        while(true) {
            try {
                array[furthestStoredIndex] = element;
                furthestStoredIndex++;
                break;
            } catch(ArrayIndexOutOfBoundsException ex) {
                ensureCapacity(furthestStoredIndex + 1);
            }
        }
    }
    
    /**
     * Adds an object to the array at a certain index.
     * 
     * @param element The object to be added
     * @param index The index to insert the object in.
     */
    public void add(Integer element, int index) {
        while(true) {
            try {
                if(index < furthestStoredIndex) {
                    Integer temp = array[index];
                    array[index] = element;
                    furthestStoredIndex++;
                    break;
                }
            } catch(ArrayIndexOutOfBoundsException ex) {
                ensureCapacity(furthestStoredIndex + 1);
            }
        }
    }
    
    /**
     * Gets the item at a certain index of the array.
     * 
     * @param index The index of the element to retrieve
     * @return The object at the index
     */
    public Integer get(int index) {
        return array[index];
    }
    
    /**
     * Returns the DynamicIntArray as a primitive array.
     * 
     * @return The locally stored array
     */
    public Integer[] toArray() {
        return array;
    }
    
    /**
     * Tmpties the array of elements, but keeps the same length.
     */
    public void clear() {
        furthestStoredIndex = 0;
        int length = array.length;
        array = new Integer[length];
    }
    
    /**
     * Checks if the array contains a certain object.
     * 
     * @param obj The object that could be in the array
     * @return Whether or not the object is in the array
     */
    public boolean contains(Integer obj) {
        for(Integer inArray : array) {
            if(obj == inArray) return true;
        }
        return false;
    }
    
    /**
     * Finds the index of a certain object in the array.
     * 
     * @param obj The object to get the index of
     * @return The index of the object, or -1 if it is not in the array
     */
    public int indexOf(Integer obj) {
        for(int i = 0; i < array.length; i++) {
            if(obj == array[i]) return i;
        }
        return -1;
    }
    
    /**
     * Returns the nth occurence of an object.
     * 
     * @param n Which occurence to get
     * @param obj The object to find
     * @return The index of the nth occurence, or -1 if it cannot be found
     */
    public int nthIndexOf(int n, Integer obj) {
        int occ = 1;
        for(int i = 0; i < array.length; i++) {
            if(obj == array[i]) {
                if(occ == n) {
                    return i;
                } else {
                    occ++;
                }
            }
        }
        return -1;
    }
    
    /**
     * Removes a specific element of the array, then shifts the array to fill the empty spot.
     * 
     * @param index The index of the element to remove
     */
    public void removeIndex(int index) {
        for(int i = index; i < array.length-1; i++) {
            array[index] = array[index + 1];
        }
        trim(array.length - 1);
    }
    
    /**
     * Finds the first occurence of an object in the array, then removes it.
     * 
     * @param object The object to remove
     */
    public void removeElement(Integer object) {
        int index = indexOf(object);
        removeIndex(index);
    }
    
    /**
     * Trims the length of the array and removes any extra elements.
     * 
     * @param length The new desired length of the array.
     */
    public void trim(int length) {
        if(length < array.length) {
            Integer[] tempArray = new Integer[length];
            for(int i = 0; i < tempArray.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
    }
    
    public void trim() {
        int nullCount = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) removeIndex(i);
        }
    }
    
    /**
     * Sets the length of the array, trims the array if the desired length is shorter, 
     * extends the array if the desired length is longer.
     */
    public void setLength(int length) {
        if(length > array.length) {
            ensureCapacity(length);
        } else if(length < array.length) {
            trim(length);
        }
    }
    
    public void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public String toString() {
        String outString = "[";
        for(int element : array) {
            outString += element + ", ";
        }
        return outString + "]";
    }
    
    public int size() {
        int elementCount = 0;
        for(Integer element : array) {
            if(element != null) elementCount++;
        }
        return elementCount;
    }
    
    public void sort() {
        DynamicIntArray sorted = new DynamicIntArray(1);
    
        while(sorted.size() < size()) {
            int lowest = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < size(); i++) {
                if((int) get(i) < lowest) {
                    lowest = (int) get(i);
                    index = i;
                }
            }
            if(lowest == Integer.MAX_VALUE) continue;
            removeIndex(index);
            sorted.append(lowest);
        }
        clear();
        append(sorted);
    }
}
