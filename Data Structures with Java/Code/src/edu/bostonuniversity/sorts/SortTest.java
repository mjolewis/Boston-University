package edu.bostonuniversity.sorts;

public class SortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest();
        sort.doIt();
    }

    public void doIt() {
        //int[] data = {5, 4, 3, 2, 1, 0, -1, -2, 88, 234, 583, 29, 40, 92, 91, 498, 487, 29, 458, 58, 11, 2354, 53};
        //int[] data = {40, 20, 40, 40, 40, 40, 8, 9, 9, 8, 40};
        int[] data = new int[1000000];
        for (int i = 0; i < data.length; i++) {
            int j = (int) (Math.random() * 100000);
            data[i] = j;
        }

        System.out.println("Starting sort");
        long start = System.nanoTime();

        //S.qSort(data);
        Sort.quickSort(data);

        long end = System.nanoTime();
        long time = end - start;

        //for (int datum : data) { System.out.print(datum + " "); }

        System.out.println("\nTook: " + time / 1000000000.0 + " seconds");
    }
}
