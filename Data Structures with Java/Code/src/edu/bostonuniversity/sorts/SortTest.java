package edu.bostonuniversity.sorts;

public class SortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest();
        sort.doIt();
    }

    public void doIt() {
        int[] data = {40, 20, 10, 80, 60, 50, 7, 30, 100, 90, 70};
        int first = 0;
        int last = data.length;
        int[] answer;

        answer = Sort.quickSort(data, first, last);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
