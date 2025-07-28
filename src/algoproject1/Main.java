package algoproject1;

import java.util.Arrays;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Techno
 */
public class Main {

    // an array with instances of all the sorting algorithms
    final public static SortingAlgorithm[] ALGORITHM_OBJ_ARR = {new SelectionSort(), new InsertionSort(), 
            new ShellSort(), new MergeSort(), new ThreeWayMergeSort(), 
            new QuickSortLomuto(), new QuickSortHoare(), new HeapSort()};
    
    // an array with the names of all the sorting algorithms
    final static String[] ALGORITHM_NAME_ARR = {"Selection Sort", "Insertion Sort", 
            "Shell Sort", "Merge Sort", "3-Way Merge Sort", "Lomuto Quick Sort", 
            "Hoare Quick Sort", "Heap Sort"};
    
    public static void main(String[] args) {
        // generates random array
        int arraySize = 15000; 
        int[] randomArr = Utils.generateRandomIntArr(arraySize, 0, 15000);
        
        // generates reverse sorted array
        int[] reverseSortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Utils.makeReverseSorted(reverseSortedArr);
        
        // generates almost sorted array
        int[] almostSortedArr = Arrays.copyOf(randomArr, randomArr.length);
        Utils.makeAlmostSorted(almostSortedArr);
        
        // creates a new dataset
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        // runs comparison between execution times for each type of array 
        // with each sorting algorithm and saves the results to the dataset.
        getExecTimesAndAddToDataset(randomArr, "Random Array", dataSet);
        getExecTimesAndAddToDataset(reverseSortedArr, "Reverse Sorted Array", dataSet);
        getExecTimesAndAddToDataset(almostSortedArr, "Almost Sorted Array", dataSet);
        
        // creates the bar chart graphic
        BarChart chart = new BarChart("Sorting Algorithm Time Comparison",
                "Sorting Algorithm Time Comparison: Array Size = "+arraySize,"Array Type",
                "Execution time in Nanoseconds",dataSet);
        
        // packs chart and shows it
        chart.pack();
        chart.setVisible(true);
    }
    
    
    public static void getExecTimesAndAddToDataset(int[] arr, String category, DefaultCategoryDataset dataSet){
        System.out.println(category);
        long[] executionTimes = getExecutionTimes(arr);
        System.out.println("");
        Number[] executeTimesNumArr = Utils.convertLongToNumberArr(executionTimes);
        BarChart.addToDataset(dataSet, ALGORITHM_NAME_ARR, executeTimesNumArr, category);
    }
    
    public static long[] getExecutionTimes(int[] arr){
        long executionTimes[] = new long[ALGORITHM_OBJ_ARR.length];
        
        for (int i = 0; i < ALGORITHM_OBJ_ARR.length; i++) {
            executionTimes[i] = Utils.measureExecutionTime(arr, ALGORITHM_OBJ_ARR[i]);
        }
        
        return executionTimes;
    }
    
}
