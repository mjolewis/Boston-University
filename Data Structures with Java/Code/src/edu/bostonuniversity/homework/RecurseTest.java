package edu.bostonuniversity.homework;

public class RecurseTest {
    public static void main(String[] args) {
        Recurse recurse = new Recurse();
        System.out.println("Run 1 of recursive print ->");
        recurse.printRecursivePattern(1, 4);
        System.out.println("-----------------------------");

        System.out.println("Run 2 of recursive print ->");
        recurse.printRecursivePattern(1, 5);
        System.out.println("-----------------------------");

        System.out.println("Run 3 of recursive print ->");
        recurse.printRecursivePattern(1, 6);
        System.out.println("-----------------------------");

        System.out.println("Run 1 of convert ->");
        String answer = recurse.convert(1234);
        System.out.println(answer);
        System.out.println("-----------------------------");

        System.out.println("Run 2 of convert ->");
        answer = recurse.convert(58790);
        System.out.println(answer);
        System.out.println("-----------------------------");

        System.out.println("Run 3 of convert ->");
        answer = recurse.convert(5034);
        System.out.println(answer);
        System.out.println("-----------------------------");
    }
}
