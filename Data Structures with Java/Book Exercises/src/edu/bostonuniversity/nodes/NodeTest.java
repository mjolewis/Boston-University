package edu.bostonuniversity.nodes;

public class NodeTest {
    public static void main(String[] args) {
        NodeTest driver = new NodeTest();
        driver.doIt();
    }

    public static void doIt() {
        DoubleNode head = DoubleNode.getInstance();
        DoubleNode node1 = DoubleNode.getInstance();
        DoubleNode node2 = DoubleNode.getInstance();
        DoubleNode node3 = DoubleNode.getInstance();


        head.addNodeAfter(node1);
        node1.addNodeAfter(node2);
        node2.addNodeAfter(node3);

        System.out.println("Head is: " + head.getData());
        System.out.println("Head is: " + head.getNext().getData());
        System.out.println("Head is: " + head.getNext().getNext().getData());
        System.out.println("Head is: " + head.getNext().getNext().getNext().getData());
        System.out.println("Head is: " + head.getNext().getNext().getNext().getNext().getData());

        System.out.println();
        DoubleNode.listCopyWithTail(head);
    }
}