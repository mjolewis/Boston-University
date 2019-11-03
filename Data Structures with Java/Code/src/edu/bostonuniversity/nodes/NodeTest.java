package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.LinkedList;

public class NodeTest {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        LinkedList<Integer> list = new LinkedList<>(1, null);

        list.addAfter(3);

        System.out.println("Size is : " + list.size());
        System.out.println("Prev is: " + list.getPrevious());
        System.out.println("Head is: " + list.getHead().getData());
        System.out.println("Cursor is: " + list.getCurrent());
        System.out.println("Tail is: " + list.getTail());

        list.start();

        System.out.println();
        System.out.println("Size is : " + list.size());
        System.out.println("Head is: " + list.getHead().getData());
        System.out.println("Cursor is: " + list.getCurrent());
        System.out.println("Tail is: " + list.getTail());

        System.out.println();
        list.addAfter(2);

        System.out.println();
        System.out.println("Size is : " + list.size());
        System.out.println("Head is: " + list.getHead().getData());
        System.out.println("Cursor is: " + list.getCurrent());
        System.out.println("Tail is: " + list.getTail());

        System.out.println();
        System.out.println("Current is : " + list.getCursor().getData());
        System.out.println("Current is : " + list.getCursor().getNext().getData());
        System.out.println("Current is : " + list.getCursor().getNext().getNext().getData());

        list.removeCurrent();
        System.out.println();
        System.out.println("Size is : " + list.size());
        System.out.println("Prev is: " + list.getPrevious());
        System.out.println("Head is: " + list.getHead().getData());
        System.out.println("Cursor is: " + list.getCurrent());
        System.out.println("Tail is: " + list.getTail());
    }
}