package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.LinkedStack;

public class NodeTest {
    public static void main(String[] args) {

        Node<Integer> node = new Node<>();
        LinkedStack<Integer> stack2 = new LinkedStack<>(7, node);
        System.out.println("Is empty: " + stack2.isEmpty());
        stack2.add(4);

        System.out.println("Size is: " + stack2.getSize());
        System.out.println("Top is: " + stack2.getTop().getData());
        System.out.println("Remove top: " + stack2.pop());

        System.out.println();
        System.out.println("Size is: " + stack2.getSize());
        System.out.println("Top is: " + stack2.getTop().getData());
        System.out.println("Remove top: " + stack2.pop());
        System.out.println("Is empty: " + stack2.isEmpty());

        System.out.println();
        System.out.println("Size is: " + stack2.getSize());

        System.out.println();
        stack2.add(77);
        stack2.add(88);
        System.out.println("Size is: " + stack2.getSize());
        System.out.println("Top is: " + stack2.getTop().getData());
        System.out.println("Remove top: " + stack2.pop());

        System.out.println();
        System.out.println("Size is: " + stack2.getSize());
        System.out.println("Top is: " + stack2.getTop().getData());



    }
}