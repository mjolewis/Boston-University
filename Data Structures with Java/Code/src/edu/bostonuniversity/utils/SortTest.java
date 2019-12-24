package edu.bostonuniversity.utils;

public class SortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest();
        sort.doIt();
    }

    public void doIt() {
        int[] data = new int[15];
        for (int i = 0; i < data.length; i++) {
            int j = (int) (Math.random() * 100);
            data[i] = j;
        }

        System.out.println("Starting sort");
        long start = System.nanoTime();

        //Quicksort.quicksort(data);
        //S.quicksort(data);
        Insertionsort.insertionsort(data);

        long end = System.nanoTime();
        long time = end - start;

        for (int datum : data) { System.out.print(datum + " "); }

        System.out.println("\nTook: " + time / 1000000000.0 + " seconds");
    }
}
