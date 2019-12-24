// File Quicksort.java from the package edu.bostonuniversity.edu

package edu.bostonuniversity.utils;

/**********************************************************************************************************************
 * A utility class to sort data arrays into ascending order.
 *
 * @author mlewis
 * @version Dec 22, 2019
 *********************************************************************************************************************/

public class Quicksort {
    // Invariant of the Sort.java class
    //  1. The data in the given array is sorted in ascending order based on our implementation of compareTo.
    //  2. Equal elements are positioned in the correct order.

    /*
     * private static int partition(int[] data, int lo, int hi)
     * Helper method to generate a randomized pivot element, which probabilistically guarantees O(n log n) time
     * complexity in the quicksort method.
     * @param data
     *  The array to be sorted.
     * @param lo
     *  The lower bound of this partition.
     * @param hi
     *  The upper bound of this partition.
     * @return int
     *  The pivot element.
     * @postcondition
     *  A random pivot element within the lower and upper bound has been returned and placed at the lower bound of this
     *  partition.
     */
    private static int partition(int[] data, int lo, int hi) {
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

        // Putting the pivot element at the lower bound eases the implementation of the Dutch National Flag pattern in
        // our quickSort implementation.
        swap(data, lo, pivotIndex);
        return pivot;
    }

    /*
     * private static int[] quicksort(int[] data, int first, int n)
     * Utility method used to sort the specified array in O(n log n) time complexity. Note, to achieve O(n log n) time
     * complexity, our implementation uses the median of three partitioning method. We also use Dijkstra's Dutch
     * National Flag algorithm to handle duplicate keys.
     * @param data
     *  The array to be sorted.
     * @precondition
     *  n is greater than 1, indicating that the array contains data.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    private static void quicksort(int[] data, int lo, int hi) {
        int i, gt, lt, pivot;

        if (hi <= lo) { return; }

        pivot = partition(data, lo, hi);

        i = lo + 1;
        gt = hi;
        lt = lo;
        while (i <= gt) {
            if (data[i] < pivot) { swap(data, lt++, i++); }
            else if (data[i] > pivot) { swap(data, i , gt--); }
            else { i++; }
        }
        quicksort(data, lo, lt - 1);
        quicksort(data, gt + 1, hi);
    }

    /**
     * public static int[] quicksort(int[] data, int first, int n)
     * Utility method used to sort the specified array in O(n log n) time complexity. Note, to achieve O(n log n) time
     * complexity, our implementation uses the median of three partitioning method. We also use Dijkstra's Dutch
     * National Flag algorithm to handle duplicate keys.
     * @param data
     *  The array to be sorted.
     * @precondition
     *  n is greater than 1, indicating that the array contains data.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    public static void quicksort(int[] data) { quicksort(data, 0, data.length - 1);}

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
     *  The elements at the lo and hi indices have been swapped.
     */
    private static void swap(int[] data, int lo, int hi) {
        int swap = data[lo];
        data[lo] = data[hi];
        data[hi] = swap;
    }
}
