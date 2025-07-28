
import algoproject1.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Techno
 */
public class SortingAlgorithmTest {

    @Test
    public void insertionSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new InsertionSort().run(arr);
        assertTrue(isArraySorted(arr));
    }

    @Test
    public void selectionSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new SelectionSort().run(arr);
        assertTrue(isArraySorted(arr));
    }
    
    @Test
    public void shellSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new ShellSort().run(arr);
        assertTrue(isArraySorted(arr));
    }
    
    @Test
    public void mergeSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new MergeSort().run(arr);
        assertTrue(isArraySorted(arr));
    }
    
    @Test
    public void threeWayMergeSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new ThreeWayMergeSort().run(arr);
        assertTrue(isArraySorted(arr));
    }

    @Test
    public void quickSortHoareSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new QuickSortHoare().run(arr);
        assertTrue(isArraySorted(arr));
    }
    
    @Test
    public void quickSortLomutoResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new QuickSortLomuto().run(arr);
        assertTrue(isArraySorted(arr));
    }
    
    @Test
    public void heapSortResultIsSorted() {
        int[] arr = Utils.generateRandomIntArr(100, -100, 100);
        new HeapSort().run(arr);
        assertTrue(isArraySorted(arr));
    }
    
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
