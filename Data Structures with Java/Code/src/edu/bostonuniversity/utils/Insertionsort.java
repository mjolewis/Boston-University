package edu.bostonuniversity.utils;

/**********************************************************************************************************************
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list. At each
 * iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted
 * list, and inserts it there. It repeats until no input elements remain.
 *
 * @Note
 *  Insertion sort is more efficient in practice than similar O(n^2) sorting algorithms like selection sort and bubble
 *  sort. However, this technique is still O(n^2).
 *
 * @author mlewis
 * @version Dec 24, 2019
 *********************************************************************************************************************/

public class Insertionsort {
    // Invariant of the Insertionsort.java class
    //  1. The data in the given array is sorted in ascending order.

    /*
     * private static void insertionsort(int[] data, int n)
     * Helper method used to sort the specified array in O(n^2) time complexity.
     * @param data
     *  The data array to be sorted.
     * @param n
     *  The length of the array.
     * @precondition
     *  The input array is non-null.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    private static void insertionsort(int[] data, int n) {
        int i, lt;

        for (i = 1; i <= n; i++) {
            lt = i - 1;
            // Move elements of data[lt] that are greater than data[i] to one position ahead of their current position.
            while (lt >= 0 && data[lt] > data[i]) { swap(data, lt--, i--); }
        }
    }

    /**
     * private static void insertionsort(int[] data)
     * Utility method used to sort the specified array in O(n^2) time complexity.
     * @param data
     *  The data array to be sorted.
     * @precondition
     *  The input array is non-null.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    public static void insertionsort(int[] data) { insertionsort(data, data.length - 1); }

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
        int temp = data[lo];
        data[lo] = data[hi];
        data[hi] = temp;
    }
}
