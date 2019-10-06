package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.LinkedList;

public class NodeTest {
    public static void main(String[] args) {
        NodeTest driver = new NodeTest();
        driver.doIt();
    }

    public static void doIt() {
        LinkedList seq = LinkedList.getInstance();


//        DoubleNode node = DoubleNode.getInstance(1, DoubleNode.getInstance());
//        DoubleLinkedSeq seq1 = DoubleLinkedSeq.getInstance(1, node);
//        seq1.addBefore(2);
//
//        System.out.println("seq1 is: " + seq1.getCurrent());
//        System.out.println();
        DoubleNode node = DoubleNode.getInstance(1, DoubleNode.getInstance());
        LinkedList seq1 = LinkedList.getInstance(2, node);
        seq1.addBefore(2);

        System.out.println("seq1 is: " + seq1.getCurrent());
        System.out.println();

        System.out.println("size is: " + seq.size());
        System.out.println();


        seq.addBefore(4);
        System.out.println(seq.getCurrent());

        seq.addAfter(5);
        System.out.println(seq.getCurrent());

        seq.addAfter(7);
        System.out.println(seq.getCurrent());

        seq.addBefore(6);
        System.out.println(seq.getCurrent());

        System.out.println("Current after addBefore is: " + seq.getCurrent());

        System.out.println();
        System.out.println("size is: " + seq.size());

        seq.start();
        System.out.println(seq.getCurrent());

        seq.advance();
        System.out.println(seq.getCurrent());

        seq.advance();
        System.out.println(seq.getCurrent());

        seq.advance();
        System.out.println(seq.getCurrent());

        System.out.println();

        System.out.println(seq.isCurrent());
        System.out.println();

        seq.start();

        System.out.println();

        System.out.println("current is: " + seq.getCurrent());
        seq.removeCurrent();
        System.out.println("After removal, current is: " + seq.getCurrent());
        System.out.println(("size is now: " + seq.size()));

        System.out.println();
        seq.start();

        System.out.println(seq.getCurrent());
        seq.advance();

        System.out.println(seq.getCurrent());
        seq.advance();

        System.out.println(seq.getCurrent());

        System.out.println();

        System.out.println("\nAbout to add more nodes");

        LinkedList linkedSeq = LinkedList.getInstance();
        linkedSeq.addBefore(100);
        linkedSeq.addAfter(101);


        System.out.println();
        System.out.println();
        LinkedList newSeq = LinkedList.concatenation(seq, linkedSeq);

        newSeq.start();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        System.out.println("current for newSeq is: " + newSeq.getCurrent());
        System.out.println("About to remove current");
        newSeq.removeCurrent();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());



        System.out.println();

        newSeq.start();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        System.out.println();
        System.out.println("adding 1000");
        newSeq.addBefore(1000);

        newSeq.start();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());

        newSeq.advance();
        System.out.println(newSeq.getCurrent());
    }
}