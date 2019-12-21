package edu.bostonuniversity.sorts;

public class SortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest();
        sort.doIt();
    }

    public void doIt() {
        int[] data = {40, 20, 10, 80, 60, 50, 7, 30, 100, 90, 70};
        //int[] data = {40, 20, 10, 50};
        int first = 0;
        int last = data.length;

        Sort.quickSort(data, first, last);

        for (int datum : data) {
            System.out.print(datum + " ");
        }
    }
}
