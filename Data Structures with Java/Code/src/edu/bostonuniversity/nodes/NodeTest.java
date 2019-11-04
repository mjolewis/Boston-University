package edu.bostonuniversity.nodes;

public class NodeTest {
    public static void main(String[] args) {
        BTNode<String> root = new BTNode<>("Grandma", null, null);
        BTNode<String> copy;
        BTNode<String> leaf;

        root.setLeft(new BTNode<>("Rosemarie", new BTNode<>("Kortney", null, null),
                new BTNode<>("Michael", null, null)));

        root.setRight(new BTNode<>("Melanie", new BTNode<>("Rae", null, null),
                new BTNode<>("Caitlin", null, null)));

        System.out.println("Root is: " + root.getData());
        System.out.println("Root left child is: " + root.getLeft().getData());
        System.out.println("Root right child is: " + root.getRight().getData());

        System.out.println();

        System.out.println("Left Child is: " + root.getLeft().getData());
        System.out.println("Child's left child is: " + root.getLeft().getLeft().getData());
        System.out.println("Child's right child is: " + root.getLeft().getRight().getData());

        System.out.println();

        System.out.println("Right Child is: " + root.getRight().getData());
        System.out.println("Child's left child is: " + root.getRight().getLeft().getData());
        System.out.println("Child's right child is: " + root.getRight().getRight().getData());

        System.out.println();
        leaf = root.getRight().getLeft();
        root.setData("Grandma");
        System.out.println("Root is: " + root.getData());
        System.out.println("Leaf is : " + leaf.getData());
        System.out.println("Is the root a leaf? " + leaf.isLeaf());

        System.out.println();
        System.out.println("Get left most data: " + root.getLeftmostData());
        System.out.println("Get right most data: " + root.getRightmostData());

        System.out.println();
        copy = BTNode.treeCopy(root);
        System.out.println("Copy root is: " + copy.getData());
        System.out.println("Copy root left child is: " + copy.getLeft().getData());
        System.out.println("Copy root right child is: " + copy.getRight().getData());

        System.out.println();
        System.out.println("Root is: " + root.getData());
        System.out.println("Copy root is: " + copy.getData());

        root.setLeft(new BTNode<>("new person here now", null, null));

        System.out.println("Root is: " + root.getData());
        System.out.println("Root left child is: " + root.getLeft().getData());
        System.out.println("Copy left child is: " + copy.getLeft().getData());



    }
}