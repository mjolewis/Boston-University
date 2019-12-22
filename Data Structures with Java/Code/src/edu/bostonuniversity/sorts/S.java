// File QuickSort.java from the package edu.bostonuniversity.edu

package edu.bostonuniversity.sorts;

public class S {

    private static int getPivot(int[] data, int lo, int hi) {
        int i, j, k, pivot, pivotIndex;

        i = lo + (int) (Math.random() * (hi - lo));
        j = lo + (int) (Math.random() * (hi - lo));
        k = lo + (int) (Math.random() * (hi - lo));
        pivot = Math.max(Math.min(data[i], data[j]), Math.min(Math.max(data[i], data[j]), data[k]));

        // Find the pivot index and return it.
        if (data[i] == pivot) {
            pivotIndex = i;
        } else if (data[j] == pivot) {
            pivotIndex = j;
        } else {
            pivotIndex = k;
        }

        return pivotIndex;
    }

    public static void qSort(int[] data) { sort(data, 0, data.length - 1); }

    private static void sort(int[] data, int lo, int hi) {
        int i, gt, lt, pivot, pivotIndex;

        if (hi <= lo) { return; }

        // Use median of three random numbers in the array to reduce the probability of incurring O(n^2).
        pivotIndex = getPivot(data, lo, hi);

        // Swap the first element with the pivot element so we can traverse the array from left to right.
        swap(data, lo, pivotIndex);
        pivot = data[lo];

        // Sort the array.
        i = lo + 1;
        gt = hi;
        lt = lo;
        while (i <= gt) {
            if (data[i] < pivot) { swap(data, lt++, i++); }
            else if (data[i] > pivot) { swap(data, i, gt--); }
            else { i++; }
        }

        sort(data, lo, lt - 1);
        sort(data, gt + 1, hi);
    }

    private static void swap(int[] data, int lo, int hi) {
        int swap = data[lo];
        data[lo] = data[hi];
        data[hi] = swap;
    }
}
