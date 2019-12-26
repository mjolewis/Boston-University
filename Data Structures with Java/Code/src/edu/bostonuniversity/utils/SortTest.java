package edu.bostonuniversity.utils;

public class SortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest();
        sort.doIt();
    }

    public void doIt() {
        long start, end, time;
        int[] data;

        data = new int[20];
        for (int i = 0; i < data.length; i++) {
            int j = (int) (Math.random() * 100);
            data[i] = j;
        }


        // Quicksort test
        System.out.println("Starting quick sort");
        start = System.nanoTime();
        Quicksort.quicksort(data);
        //Playground.quicksort(data);
        end = System.nanoTime();
        time = end - start;
        System.out.println("Quick sort took: " + time / 1000000000.0 + " seconds");
        for (int datum : data) { System.out.print(datum + " "); }

        // Randomize data again for insertion sort
        for (int i = 0; i < data.length; i++) {
            int j = (int) (Math.random() * 100);
            data[i] = j;
        }

        System.out.println("\n\nStarting insertion sort");
        start = System.nanoTime();
        Insertionsort.insertionsort(data);
        //Playground.insertionsort(data);
        end = System.nanoTime();
        time = end - start;
        System.out.println("Insertion sort took: " + time / 1000000000.0 + " seconds");
        for (int datum : data) { System.out.print(datum + " "); }
    }
}
