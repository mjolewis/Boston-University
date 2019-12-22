// File QuickSort.java from the package edu.bostonuniversity.edu

package edu.bostonuniversity.sorts;

/**********************************************************************************************************************
 * A utility class for sorting arrays of generic data types.
 *
 * @author mlewis
 * @version Dec 20, 2019
 *********************************************************************************************************************/

public class Sort {
    // Invariant of the Sort.java class
    //  1. The data in the given array is sorted in ascending order based on our implementation of compareTo.
    //  2. Elements that are determined to be equal are positioned in the correct order.

    /*
     * private static int getPivot(int[] data, int lo, int hi)
     * Helper method for quickSort. Returns a randomized pivot element to reduce the probability of incurring O(n^2)
     * time complexity.
     * @param data
     *  The array to be sorted.
     * @param lo
     *  The lower bound of this partition.
     * @param hi
     *  The upper bound of this partition.
     * @return int
     *  The pivot element.
     * @postcondition
     *  A random pivot element within the lower and upper bound is used as the pivot.
     */
    private static int getPivot(int[] data, int lo, int hi) {
        int i, j, k, pivot, pivotIndex;

        i = lo + (int) (Math.random() * (hi - lo));
        j = lo + (int) (Math.random() * (hi - lo));
        k = lo + (int) (Math.random() * (hi - lo));
        pivot = Math.max(Math.min(data[i], data[j]), Math.min(Math.max(data[i], data[j]), data[k]));


        if (data[i] == pivot) {
            pivotIndex = i;
        } else if (data[j] == pivot) {
            pivotIndex = j;
        } else {
            pivotIndex = k;
        }

        // Swapping the first element with the pivot element allows us to use the Dutch National Flag pattern in our
        // quickSort implementation.
        swap(data, lo, pivotIndex);
        return data[lo];
    }

    /**
     * public static int[] quickSort(int[] data, int first, int n)
     * Utility method used to sort the specified array in O(n log n) time complexity. Note, to achieve O(n log n) time
     * complexity, our implementation uses the median of three partitioning method and Dijkstra's Dutch National Flag
     * algorithm to handle duplicate keys.
     * @param data
     *  The array to be sorted.
     * @precondition
     *  n is greater than 1, indicating that the array contains data.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    public static void quickSort(int[] data) { quickSort(data, 0, data.length - 1);}

    /*
     * private static int partition(int[] data, int first, int n)
     * Helper method used to sort the specified array in O(n log n) time complexity. Note, to achieve O(n log n) time
     * complexity, our implementation uses the median of three partitioning method and Dijkstra's Dutch National Flag
     * algorithm to handle duplicate keys.
     * @param data
     *  The array to be sorted.
     * @param lo
     *  The lower bound of this array partition.
     * @param hi
     *  The upper bound of this array partition.
     */
    private static void quickSort(int[] data, int lo, int hi) {
        int i, gt, lt, pivot;

        if (hi <= lo) { return; }

        pivot = getPivot(data, lo, hi);

        // Sort the array.
        i = lo + 1;
        gt = hi;
        lt = lo;
        while (i <= gt) {
            if (data[i] < pivot) { swap(data, lt++, i++); }
            else if (data[i] > pivot) { swap(data, i , gt--); }
            else { i++; }
        }
        quickSort(data, lo, lt - 1);
        quickSort(data, gt + 1, hi);
    }

    /*
     * private static void swap(int[] data, int lo, int hi)
     * Helper method to swap two elements in the specified array.
     * @param data
     *  The array to be sorted.
     * @param lo
     *  The lower bound of this partition.
     * @param hi
     *  The upper bound of this partition.
     * @postcondition
     *  The elements at the lo and hi indexes have been swapped.
     */
    private static void swap(int[] data, int lo, int hi) {
        int swap = data[lo];
        data[lo] = data[hi];
        data[hi] = swap;
    }
}
