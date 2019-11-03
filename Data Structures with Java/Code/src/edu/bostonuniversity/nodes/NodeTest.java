package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.LinkedStack;

public class NodeTest {
    public static void main(String[] args) {

        Node<Integer> node = new Node<>();
        LinkedStack<Integer> stack2 = new LinkedStack<>(7, node);
        System.out.println("Is empty: " + stack2.isEmpty());
        stack2.push(4);

        System.out.println("Size is: " + stack2.getSize());
        System.out.println("Top is: " + stack2.peek());
        System.out.println("Remove top: " + stack2.pop());

        System.out.println();
        System.out.println("Size is: " + stack2.getSize());
        System.out.println("Top is: " + stack2.peek());
        System.out.println("Remove top: " + stack2.pop());
        System.out.println("Is empty: " + stack2.isEmpty());

        System.out.println();
        System.out.println("Size is: " + stack2.getSize());

        System.out.println();
        stack2.push(77);
        stack2.push(88);
        stack2.push(99);

        System.out.println();
        System.out.println("77 is at position " + stack2.search(77));
        System.out.println("88 is at position " + stack2.search(88));
        System.out.println("99 is at position " + stack2.search(99));

        System.out.println();
        LinkedStack<Integer> clone = stack2.clone();


        clone.getTop().setData(5000);


        System.out.println("Changed top in clone");
        System.out.println();
        System.out.println("Top is: " + stack2.peek());
        System.out.println("Clone Top is: " + clone.peek());

        System.out.println();
        System.out.println("Top is: " + stack2.peek());
        System.out.println("Remove top: " + stack2.pop());
        System.out.println("Size is: " + stack2.getSize());

        System.out.println();
        System.out.println("Clone Top is: " + clone.peek());
        System.out.println("Clone Remove top: " + clone.pop());
        System.out.println("Clone Size is: " + clone.getSize());

        System.out.println();
        System.out.println("Changed top in clone");
        clone.getTop().setData(27272);

        System.out.println();
        System.out.println("Top is: " + stack2.peek());
        System.out.println("Remove top: " + stack2.pop());
        System.out.println("Size is: " + stack2.getSize());

        System.out.println();
        System.out.println("Clone Top is: " + clone.peek());
        System.out.println("Clone Remove top: " + clone.pop());
        System.out.println("Clone Size is: " + clone.getSize());

        System.out.println();
        System.out.println("Top is: " + stack2.peek());
        System.out.println("Remove top: " + stack2.pop());
        System.out.println("Size is: " + stack2.getSize());

        System.out.println();
        System.out.println("Clone Top is: " + clone.peek());
        System.out.println("Clone Remove top: " + clone.pop());
        System.out.println("Clone Size is: " + clone.getSize());

    }
}