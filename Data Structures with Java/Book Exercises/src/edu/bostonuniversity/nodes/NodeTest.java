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


        head.addNodeAfter(1);
        head.getNext().addNodeAfter(2);
        head.getNext().getNext().addNodeAfter(3);
        head.getNext().getNext().getNext().addNodeAfter(4);

        System.out.println("Head is: " + head.getData());
        System.out.println("Head is: " + head.getNext().getData());
        System.out.println("Head is: " + head.getNext().getNext().getData());
        System.out.println("Head is: " + head.getNext().getNext().getNext().getData());
        System.out.println("Head is: " + head.getNext().getNext().getNext().getNext().getData());

        System.out.println();
        DoubleNode.listCopyWithTail(head);
    }
}