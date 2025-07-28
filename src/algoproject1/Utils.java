
package algoproject1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Techno
 */
public class Utils {
    public static long measureExecutionTime(int[] arr, SortingAlgorithm algorithm){
        int[] copiedArr = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();
        algorithm.run(copiedArr);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time for " + algorithm.getClass().getSimpleName() 
                + ": " + executionTime + " nanoseconds");
        
        return executionTime;
    }
    
    // takes size, lower bound and upper bound as parameters and 
    // generates an array with random integers from the range specified
    public static int[] generateRandomIntArr(int size, int lower_bound, int upper_bound) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = generateRandomInt(lower_bound, upper_bound);
        }
        return result;
    }

    // generates and returns a random integer
    public static int generateRandomInt(int lower_bound, int upper_bound) {
        Random rand = new Random();
        return rand.nextInt(upper_bound - lower_bound) + lower_bound;
    }
    
    // converts a Long array into a Number array
    public static Number[] convertLongToNumberArr(long[] longArr){
        Number[] numberArray = new Number[longArr.length];
        for (int i = 0; i < longArr.length; i++) {
            numberArray[i] = Long.valueOf(longArr[i]);
        }
        return numberArray;
    }
    
    // makes reverse sorted array
    public static void makeReverseSorted(int[] arr){
        QuickSortHoare qsh = new QuickSortHoare();
        qsh.run(arr);
        reverseArray(arr);
    }
    
    // reverses the array
    public static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move start and end towards the center
            start++;
            end--;
        }
    }
    
    // swaps last two elements of an array
    public static void makeAlmostSorted(int[] arr){
        QuickSortHoare qsh = new QuickSortHoare();
        qsh.run(arr);
        
        // If the array has less than 2 elements, it's already almost sorted
        if (arr.length < 2) 
            return;  
        
        // Swap the chosen element with the one after it
        int temp = arr[arr.length - 2];
        arr[arr.length - 2] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }
    
    public static void printArray(int[] arr) {
        for (int i = 1; i <= arr.length; ++i) {
            System.out.print(arr[i-1] + "\t");
            if(i%20 == 0){
                System.out.println("");
            }
        }
        System.out.println();
    }
}
