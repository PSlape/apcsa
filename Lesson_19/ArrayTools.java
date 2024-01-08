package Lesson_19;
import java.util.function.Consumer;


/**
 * Write a description of class ArrayTools here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class ArrayTools
{
    public static void forEach(Object[] array, Consumer<Object> consumer) {
        for(Object obj : array) {
            consumer.accept(obj);
        }
    }
    
    public static void setLength(Object[] array, int length) {
        if(length > array.length) {
            ensureCapacity(array, length);
        } else if(length < array.length) {
            trim(array, length);
        }
    }
    
    public static void ensureCapacity(Object[] array, int length) {
        if(length > array.length) {
            Object[] tempArray = new Object[length];
            for(int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
    }
    
    public static void trim(Object[] array, int length) {
        if(length < array.length) {
            Object[] tempArray = new Object[length];
            for(int i = 0; i < tempArray.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
    }
    
    public static void trim(Object[] array) {
        int length = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                length = i;
                break;
            }
        }
        
        Object[] tempArray = new Object[length+1];
        for(int i = 0; i < tempArray.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
    
    public static void remove(Object[] array, int index) {
        array[index] = null;
        for(int i = index; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        trim(array, array.length-1);
    }
    
    public static void removeObject(Object[] array, Object obj) {
        int index = indexOf(array, obj);
        if(index != -1) {
            remove(array, index);
        }
    }
    
    public static int indexOf(Object[] array, Object obj) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == obj) return i;
        }
        System.out.println("Object Not Found");
        return -1;
    }
    
    public static void append(Object[] array, Object obj) {
        int furthestIndex = -1;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                furthestIndex = i;
                break;
            }
        }
        if(furthestIndex == -1) {
            furthestIndex = array.length;
        }
        while(true) {
           try {
                array[furthestIndex] = obj;
                break;
            } catch(IndexOutOfBoundsException ex) {
                System.out.println(array.length);
                ensureCapacity(array, array.length + 1);
            } 
        }
        
        print(array);
    }
    
    public static void print(Object[] array) {
        System.out.print("[");
        forEach(array, (Object element) -> {
            if(element != null) {
                if(indexOf(array, element) == array.length-1) {
                    System.out.print("\"" + element.toString() + "\" ");
                } else {
                    System.out.print("\"" + element.toString() + "\", ");
                }
            }
        });
        System.out.println("]");
    }
}
