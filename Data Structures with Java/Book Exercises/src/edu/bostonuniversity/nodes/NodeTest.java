package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.DoubleLinkedSeq;

public class NodeTest {
    public static void main(String[] args) {
        NodeTest driver = new NodeTest();
        driver.doIt();
    }

    public static void doIt() {
        DoubleLinkedSeq seq = DoubleLinkedSeq.getInstance();

//        DoubleNode node = DoubleNode.getInstance(1, DoubleNode.getInstance());
//        DoubleLinkedSeq seq1 = DoubleLinkedSeq.getInstance(1, node);
//        seq1.addBefore(2);
//
//        System.out.println("seq1 is: " + seq1.getCurrent());
//        System.out.println();

        System.out.println("size is: " + seq.size());
        System.out.println();



        seq.addAfter(4);
        System.out.println(seq.getCurrent());

        seq.addAfter(6);
        System.out.println(seq.getCurrent());

        seq.addBefore(5);
        System.out.println(seq.getCurrent());

        System.out.println();
        System.out.println("size is: " + seq.size());

        seq.start();
        System.out.println(seq.getCurrent());

        seq.advance();
        System.out.println(seq.getCurrent());

        seq.advance();
        System.out.println(seq.getCurrent());

        System.out.println();

        System.out.println(seq.isCurrent());
        System.out.println();

        seq.start();
        System.out.println(seq.getCurrent());

        System.out.println();

        seq.removeCurrent();
        System.out.println(seq.getCurrent());

        System.out.println();

        seq.start();
        System.out.println(seq.getCurrent());
    }
}