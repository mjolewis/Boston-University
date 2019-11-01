package edu.bostonuniversity.nodes;
public class NodeTest {
    public static void main(String[] args) {
        NodeTest driver = new NodeTest();
        driver.doIt();
    }

    public static void doIt() {
        NodeQueue<Integer> queue = new NodeQueue<>();
        NodeQueue<Integer> newnode = new NodeQueue<>(5000, null);

        System.out.println(queue.getData());
        System.out.println(queue.getNext());
        queue.setData(7);
        queue.setNext(newnode);
        System.out.println(queue.getData());
        System.out.println(queue.getNext().getData());
    }
}