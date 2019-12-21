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
     * @param start
     *  The first index in the data array.
     * @param end
     *  The length of the data array.
     * @precondition
     *  n is greater than 1, indicating that the array contains data.
     * @postcondition
     *  The data array has been sorted from smallest to largest.
     */
    public static void quickSort(int[] data, int start, int end) {
        int pivotIndex;
        int n1;
        int n2;

        if (end > 1) {
            pivotIndex = partition(data, start, end);

            n1 = pivotIndex - start;
            n2 = end - n1 - 1;

            quickSort(data, start, n1);
            quickSort(data, pivotIndex + 1, n2);
        }
    }

    /**
     * private static int partition(int[] data, int first, int n)
     * Helper method that returns a pivot index used by the quickSort method.
     * @param data
     *  The array to be sorted.
     * @param start
     *  The first index in the data array.
     * @param end
     *  The length of the data array
     * @return int
     *  The pivot index.
     */
    private static int partition(int[] data, int start, int end) {
        int pivotIndex;
        int pivot;
        int randomIndex1;
        int randomIndex2;
        int randomIndex3;
        int temp;
        int tooBigIndex;
        int tooSmallIndex;

        // Find three random numbers within the bounds of the data array and use the values at those indexes to
        // determine a pivotElement.
        randomIndex1 = start + (int) (Math.random() * end);
        randomIndex2 = start + (int) (Math.random() * end);
        randomIndex3 = start + (int) (Math.random() * end);

        pivot = Math.max(Math.min(data[randomIndex1], data[randomIndex2]), Math.min(Math.max(data[randomIndex1],
                data[randomIndex2]), data[randomIndex3]));

        // Find the pivot index
        if (data[randomIndex1] == pivot) {
            pivotIndex = randomIndex1;
        } else if (data[randomIndex2] == pivot) {
            pivotIndex = randomIndex2;
        } else {
            pivotIndex = randomIndex3;
        }

        tooBigIndex = start;
        tooSmallIndex = start + end - 1;
        while (tooBigIndex < tooSmallIndex) {
            while (data[tooBigIndex] < pivot) { tooBigIndex++; }
            while (data[tooSmallIndex] > pivot) { tooSmallIndex--; }

            // Swap the elements so that they are in the correct partition of the array.
            if (tooBigIndex < tooSmallIndex) {
                temp = data[tooBigIndex];
                data[tooBigIndex] = data[tooSmallIndex];
                data[tooSmallIndex] = temp;
            }
        }

        if (data[tooSmallIndex] < pivot) {
            temp = data[tooSmallIndex];
            data[tooSmallIndex] = pivot;
            data[pivotIndex] = temp;
        }

        return tooSmallIndex;
    }
}
