package edu.bostonuniversity.collections;

public class StackTest {
    public static void main(String[] args) {
        StackTest driver = new StackTest();
        driver.doIt();
    }

    public void doIt() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek --->" + stack.peek());
        System.out.println("Pop ---> " + stack.pop());
        System.out.println("Peek --->" + stack.peek());
        System.out.println("Size --->" + stack.getSize());
        System.out.println("Head --->" + stack.getHead());

    }
}
