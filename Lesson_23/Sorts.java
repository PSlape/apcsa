package Lesson_23;
import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
 */
public class Sorts
{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  list  Description of Parameter
   */
  Sorts()
  {
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort(int[] list) {
      
    System.out.println();
    System.out.println("Bubble Sort");
    System.out.println();
    setStepCount(0);
    
    steps++;
    for(int count = 1; count < list.length; count++) {
        int largestInd = 0;
        for(int i = 0; i <= list.length-count; i++) {
            if(list[i] > list[largestInd]) {
                largestInd = i;
            }
            steps += 2;
        }
        steps += 3;
        
        for(int i = largestInd; i < list.length-count; i++) {
            int temp = list[i];
            list[i] = list[i+1];
            list[i+1] = temp;
            steps += 3;
        }
        steps += 3;
    }
    
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(int[] list)
  {
    // Replace these lines with your code
    System.out.println();
    System.out.println("Selection Sort");
    System.out.println();
    setStepCount(0);
    
    int lowestInd = 0;
    steps++;
    for(int count = 0; count < list.length; count++) {
        for(int i = count; i < list.length; i++) {
            if(list[i] < list[lowestInd]) {
                lowestInd = i;
            }
            steps++;
        }
        steps += 3;
        
        int temp = list[0];
        list[0] = list[lowestInd];
        list[lowestInd] = temp;
        lowestInd = 0;
        steps += 4;
    }
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(int[] list)
  {
    // Replace these lines with your code
    System.out.println();
    System.out.println("Insertion Sort");
    System.out.println();
    setStepCount(0);
    
    for(int i = 1; i < list.length; i++) {
        int key = list[i];
        int j = i - 1;
        for(; j >= 0 && key < list[j]; j--) {
            list[j+1] = list[j];
            steps++;
        }
        list[j+1] = key;
    }
  }

 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
  private void merge(int[] a, int first, int mid, int last)
  { 
    int[] temp = new int[last+1];
    int i = first;
    int j = mid+1;
    int k = 0;
    while(i <= mid && j <= last) {
        if(a[i] <= a[j]) {
            temp[k++] = a[i++];
        } else {
            temp[k++] = a[j++];
        }
    }
    while(i <= mid) {
        temp[k++] = a[i++];
    }
    while(j <= last) {
        temp[k++] = a[j++];
    }
    a = temp;
  }

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(int[] a, int first, int last)
  { 
    if(first < last) {
        int mid = first + (last - first) / 2;
        mergeSort(a, first, mid);
        mergeSort(a, mid+1, last);
        testMerge(a, first, mid, last);
    }
  }
  
  private void testMerge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

  /**
   *  Recursive quicksort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void quickSort(int[] a, int first, int last)
  {
    // Replace these lines with your code
    System.out.println();
    System.out.println("Quicksort");
    System.out.println();
  }

  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount()
  {
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(int stepCount)
  {
    steps = stepCount;
  }
}