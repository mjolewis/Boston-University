package edu.bostonuniversity.collections;

public class StackTest {
    public static void main(String[] args) {
        StackTest driver = new StackTest();
        driver.doIt();
    }

    public void doIt() {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);



        System.out.println("Peek --->" + stack.peek());
        System.out.println("Pop ---> " + stack.pop());
        System.out.println("Peek --->" + stack.peek());
        System.out.println("Size --->" + stack.getSize());
        System.out.println("Head --->" + stack.getHead());

        System.out.println("Clearing stack ---->");
        stack.clear();
        System.out.println("Stack size is: " + stack.getSize());
        System.out.println("Stack empty " + stack.isEmpty());

        stack.push(77);
        stack.push(100);

        stack1.push(77);
        stack1.push(100);

        System.out.println("Stack size is: " + stack.getSize());
        System.out.println("Stack empty " + stack.isEmpty());

        System.out.println("Peek --->" + stack.peek());



        System.out.println(stack.search(stack1));


    }
}
