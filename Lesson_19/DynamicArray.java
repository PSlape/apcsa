package Lesson_19;

import java.lang.reflect.Array;
/**
 * Write a description of class DynamicArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DynamicArray<T> {
    public static final int DEFAULT_CAPACITY = 10;
    
    private T[] array;
    
    public DynamicArray() {
        array = (T[]) Array.newInstance(DynamicArray.class, DEFAULT_CAPACITY);
    }
    
    public void ensureCapacity(int length) {
        if(length >= array.length) {
            
        }
    }
    
    public void append(T element) {
        
    }
}
