package edu.bostonuniversity.nodes;

import edu.bostonuniversity.collections.LinkedList;

public class NodeTest {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        LinkedList<Integer> list = new LinkedList<>(7, node);

        System.out.println("Size is : " + list.size());
        //System.out.println("Prev is: " + list.getPrevious());
        System.out.println("Head is: " + list.getHead());
        System.out.println("Cursor is: " + list.getCurrent());

    }
}