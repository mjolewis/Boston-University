package edu.bostonuniversity.nodes;
import edu.bostonuniversity.collections.LinkedList;

public class NodeTest {
    public static void main(String[] args) {
        NodeTest driver = new NodeTest();
        driver.doIt();
    }

    public static void doIt() {
        LinkedList<String> seq = LinkedList.getInstance();

        Node<String> node = Node.getInstance("Hi", Node.getInstance());
        LinkedList<String> seq1 = LinkedList.getInstance("there", node);
        seq1.addBefore("I");

        System.out.println("seq1 is: " + seq1.getCurrent());
        System.out.println();

        System.out.println("size is: " + seq.size());
        System.out.println();


        seq.addBefore("I am");
        System.out.println(seq.getCurrent());

        seq.addAfter("a");
        System.out.println(seq.getCurrent());

        seq.addAfter("Scientist");
        System.out.println(seq.getCurrent());

        seq.addBefore("Computer");
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

        LinkedList<String> linkedSeq = LinkedList.getInstance();
        linkedSeq.addBefore("and");
        linkedSeq.addAfter("a");


        System.out.println();
        System.out.println();
        LinkedList<String> newSeq = LinkedList.concatenation(seq, linkedSeq);

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
        newSeq.addBefore("Software Engineer");

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