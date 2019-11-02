package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.LinkedQueue;

public class NodeTest {
    public static void main(String[] args) {
        NodeTest driver = new NodeTest();
        driver.doIt();
    }

    public static void doIt() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println(queue.isEmpty());

        queue.add(7);
        queue.add(9);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.remove());
        System.out.println(queue.size());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
        System.out.println(queue.remove());

    }
}