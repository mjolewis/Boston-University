package edu.bostonuniversity.nodes;

public class NodeTest {
    public static void main(String[] args) {
        BTNode<String> root = new BTNode<>("Louise", null, null);

        root.setLeft(new BTNode<String>("Rosemarie", new BTNode<String>("Kortney", null, null),
                new BTNode<String>("Michael", null, null)));

        root.setRight(new BTNode<String>("Melanie", new BTNode<String>("Rae", null, null),
                new BTNode<String>("Caitlin", null, null)));

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
        root.setData("Grandma");
        System.out.println("Root is: " + root.getData());


    }
}