package edu.bostonuniversity.sorts;

public class SortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest();
        sort.doIt();
    }

    public void doIt() {
        int[] data = {5, 4, 3, 2, 1, 0, -1, -2};
        //int[] data = {40, 20, 10, 50};
        int first = 0;
        int last = data.length;

        long start = System.nanoTime();

        Sort.quickSort(data, first, last);

        long end = System.nanoTime();
        long time = end - start;

        for (int datum : data) {
            System.out.print(datum + " ");
        }

        System.out.println("\nTook: " + time / 1000000000 + " seconds");

    }
}
