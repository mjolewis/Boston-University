// File BinaryTree.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;
import edu.bu.met.cs342a1.TextParser;

/**********************************************************************************************************************
 * A TextAnalyzer class is used to add E objects to a binary tree. If the E object is already in the binary tree
 * (using the Comparable interface) we increment a counter instead of adding a duplicate node.
 *
 * @author mlewis
 * @version November 27, 2019
 *********************************************************************************************************************/

public class TextAnalyzer<T extends Comparable<? super T>> {
    // Invariant of the TextAnalyzer.java class
    //  1. The instance variable root is a reference to the root of a Binary Tree.
    private BTNode<T> root;

    /**
     * public TextAnalyzer()
     * Initializes an empty TextAnalyzer.
     * @postcondition
     *  An empty TextAnalyzer has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the new TextAnalyzer.
     */
    public TextAnalyzer() { root = null; }

    /**
     * public void add(BTNode<T> node, T data)
     * Mutator method that adds the given data to a node in the binary tree in lexicographic order. If the data is
     * already in the binary tree then we do not add the data. Instead, we update the instance variable count by one to
     * count how many times the data occurred.
     * @param node
     *  The root of this binary tree.
     * @param data
     *  The data to add to the binary tree. If the data is already in the tree, we do not add it. Instead, we increment
     *  the data's counter.
     * @postcondition
     *  The data has been added to the binary tree in lexicographic order if the data was not already in the tree.
     *  Otherwise, the data is already in the tree and it has not been added; however, the counter associated with the
     *  data has been incremented.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new data.
     */
    public void add(BTNode<T> node, T data) {
        boolean nodeAdded = false;

        while (!nodeAdded) {
            if (data.compareTo(node.getData()) < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(new BTNode<>(data, null, null));
                    node.getLeft().incrementCount();
                    nodeAdded = true;
                } else {
                    node = node.getLeft();
                }
            } else if (data.compareTo(node.getData()) > 0) {
                if (node.getRight() == null) {
                    node.setRight(new BTNode<>(data, null, null));
                    node.getRight().incrementCount();
                    nodeAdded = true;
                } else {
                    node = node.getRight();
                }
            } else {
                node.incrementCount();
                nodeAdded = true;
            }
        }
    }

    /**
     * public void parse()
     * Parses the data one element at a time and adds that elements to the binary tree if the element is not already
     * in the tree.
     * @param data
     *  The data being added to the binary tree.
     * @postcondition
     *  The data has been added to the binary tree one element at a time. Each unique element is added in it's own node
     *  and if there is a duplicate element, then a counter is incremented.
     */
    @SuppressWarnings("unchecked")
    public void parse(TextParser data) {
        if (data == null) { return; }

        T cursor = (T) data.getNextWord();
        root = new BTNode<>(cursor, null, null);
        while (cursor != null) {
            add(root, cursor);
            cursor = (T) data.getNextWord();
        }
    }

    /**
     * public int size()
     * Accessor method that determines how many nodes are in this tree.
     * @return int
     *  The number of nodes in this binary tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public int size() {
        return BTNode.treeSize(root);
    }

    /**
     * public String toString()
     * Print the data in every node within this binary tree.
     * @return String
     *  The data from each node in this binary tree.
     */
    @Override
    public String toString() {
        root.preorderPrint();
        return "";
    }
}
