// File QuickSort.java from the package edu.bostonuniversity.edu

package edu.bostonuniversity.sorts;

/**********************************************************************************************************************
 * The Sort class is a utility class of sorting algorithms.
 *
 * @author mlewis
 * @version Dec 16, 2019
 */

public class Sort {

    /**
     * public static int[] quickSort(int[] data, int first, int n)
     * Utility method used to sort the specified array in O(n log n) time complexity.
     * @param data
     *  The array to be sorted.
     * @param first
     *  The first index in the data array.
     * @param n
     *  The length of the data array.
     * @precondition
     *  n is greater than 1, indicating that the array contains data.
     * @return int[]
     *  The sorted data array.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    public static int[] quickSort(int[] data, int first, int n) {
        int pivotIndex;
        int n1;
        int n2;

        if (n > 1) {
            pivotIndex = partition(data, first, n);

            n1 = pivotIndex - first;
            n2 = n - n1 - 1;

            quickSort(data, first, n1);
            quickSort(data, pivotIndex + 1, n2);
        }
        return data;
    }

    /**
     * private static int partition(int[] data, int first, int n)
     * Helper method that returns a pivot index used by the quickSort method.
     * @param data
     *  The array to be sorted.
     * @param first
     *  The first index in the data array.
     * @param n
     *  The length of the data array
     * @return int
     *  The pivot index.
     */
    private static int partition(int[] data, int first, int n) {
        int pivot;
        int pivotElement;
        int randomIndex1;
        int randomIndex2;
        int randomIndex3;
        int temp;
        int tooBigIndex;
        int tooSmallIndex;

        // Find three random numbers within the bounds of the data array and use the values at those indexes to
        // determine a pivotElement.
        randomIndex1 = (int) (Math.random() * n);
        randomIndex2 = (int) (Math.random() * n);
        randomIndex3 = (int) (Math.random() * n);

        pivotElement = Math.max(Math.min(data[randomIndex1], data[randomIndex2]), Math.min(Math.max(data[randomIndex1],
                data[randomIndex2]), data[randomIndex3]));

        // Find the pivot index;
        if (data[randomIndex1] == pivotElement) {
            pivot = randomIndex1;
        } else if (data[randomIndex2] == pivotElement) {
            pivot = randomIndex2;
        } else {
            pivot = randomIndex3;
        }

        tooBigIndex = 0;
        tooSmallIndex = n - 1;
        while (tooBigIndex <= tooSmallIndex) {
            while (tooBigIndex <= n && data[tooBigIndex] <= pivotElement) { tooBigIndex++; }
            while (data[tooSmallIndex] > pivotElement) { tooSmallIndex--; }

            // Swap the elements so that they are in the correct partition of the array.
            if (tooBigIndex < tooSmallIndex) {
                temp = data[tooBigIndex];
                data[tooBigIndex] = data[tooSmallIndex];
                data[tooSmallIndex] = temp;
            }
        }

        temp = data[tooSmallIndex];
        data[tooSmallIndex] = data[pivot];
        data[pivot] = temp;

        return tooSmallIndex;
    }
}
