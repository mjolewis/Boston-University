package edu.bostonuniversity.nodes;
import edu.bostonuniversity.collections.LinkedQueue;

public class NodeTest {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("Empty Queue: " + queue.isEmpty());

        queue.add(7);
        queue.add(9);
        System.out.println("Front node is: " + queue.getFront().getData());
        System.out.println("Rear node is: " + queue.getRear().getData());
        queue.getFront().setData(77777);
        System.out.println("Front node is: " + queue.getFront().getData());
        System.out.println("Empty Queue: " + queue.isEmpty());
        System.out.println("Size of Queue: " + queue.size());
        System.out.println("Removing front item: " + queue.remove());
        System.out.println("Size of Queue: " + queue.size());
        System.out.println("Removing front item: " + queue.remove());
        System.out.println("Empty Queue: " + queue.isEmpty());
        System.out.println("Removing front item: " + queue.remove());

    }
}