package edu.bostonuniversity.playground;

public class Playground {
    private static void insertionsort(int[] data, int n) {
        int i, lt;

        for (i = 1; i <= n; i++) {
            lt = i - 1;
            while (lt >= 0 && data[lt] > data[i]) { swap(data, lt--, i--); }
        }
    }

    public static void insertionsort(int[] data) { insertionsort(data, data.length - 1); }

    private static int partition(int[] data, int lo, int hi) {
        int i, j, k, pivot, pivotIndex;

        i = lo + (int) (Math.random() * (hi - lo));
        j = lo + (int) (Math.random() * (hi - lo));
        k = lo + (int) (Math.random() * (hi - lo));
        pivot = Math.max(Math.min(data[i], data[j]), Math.min(Math.max(data[i], data[j]), data[k]));

        if (data[i] == pivot) { pivotIndex = i; }
        else if (data[j] == pivot) { pivotIndex = j; }
        else { pivotIndex = k; }

        swap(data, lo, pivotIndex);
        return pivot;
    }

    private static void quicksort(int[] data, int lo, int hi) {
        int i, gt, lt, pivot;

        if (hi <= lo) { return; }

        pivot = partition(data, lo, hi);

        i = lo + 1;
        gt = hi;
        lt = lo;
        while (i <= gt) {
            if (data[i] < pivot) { swap(data, lt++, i++); }
            else if (data[i] > pivot) { swap(data, i, gt--); }
            else { i++; }
        }
        quicksort(data, lo, lt - 1);
        quicksort(data, gt + 1, hi);
    }

    public static void quicksort(int[] data) { quicksort(data, 0, data.length - 1); }

    private static void swap(int[] data, int lo, int hi) {
        int temp = data[lo];
        data[lo] = data[hi];
        data[hi] = temp;
    }
}