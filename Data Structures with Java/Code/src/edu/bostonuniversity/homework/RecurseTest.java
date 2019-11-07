package edu.bostonuniversity.homework;

public class RecurseTest {
    public static void main(String[] args) {
        Recurse recurse = new Recurse();
        recurse.printRecursivePattern(1, 4);
        String answer = recurse.convert(1234);
        System.out.println(answer);
    }
}
