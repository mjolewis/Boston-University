// File BinaryTree.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;
import edu.bu.met.cs342a1.TextParser;

/**********************************************************************************************************************
 * A BinarySearchTree class is used to add E objects to a binary tree. If the E object is already in the Binary Search
 * Tree (using the Comparable interface) we increment a counter instead of adding a duplicate node.
 *
 * @author mlewis
 * @version November 27, 2019
 *********************************************************************************************************************/

public class BinarySearchTree<T extends Comparable<? super T>> {
    // Invariant of the TextAnalyzer.java class
    //  1. The instance variable root is a reference to the root of a Binary Search Tree.
    //  2. The instance variable count is a reference to the total number of elements being added to this Binary Search
    //     Tree.
    //  3. The instance variable maxOccurrence is the number of times the most frequent element occurred in this
    //     Binary Search Tree.
    //  4. The instance variable mostFrequent is a reference to the data that most frequently occurred in this Binary
    //     Search Tree.
    //  5. The instance variable MAX_DEPTH is the maximum depth allowed during any print traversal activation.
    //  6. The instance variable depth is a static variable used to terminate the recursive print traversal
    //     activations.
    private BTNode<T> root;
    private int count;
    private int maxOccurrence;
    private T mostFrequent;
    private static final int MAX_DEPTH = 20;
    private static int depth = 0;

    /**
     * public TextAnalyzer()
     * Initializes an empty TextAnalyzer.
     * @postcondition
     *  An empty TextAnalyzer has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the new TextAnalyzer.
     */
    public BinarySearchTree() { root = null; }

    /**
     * public void add(BTNode<T> node, T data)
     * Mutator method that adds the given data to a node in the Binary Search Tree in lexicographic order. If the data
     * is already in the Binary Search Tree then we do not add the data. Instead, we update the instance variable count
     * by one to count how many times the data occurred.
     * @param node
     *  The root of this Binary Search Tree.
     * @param data
     *  The data to add to the Binary Search Tree. If the data is already in the tree, we do not add it. Instead, we
     *  increment the data's counter.
     * @postcondition
     *  The data has been added to the Binary Search Tree in lexicographic order if the data was not already in the
     *  tree. Otherwise, the data is already in the tree and it has not been added; however, the counter associated
     *  with the data has been incremented.
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
                if (node.getCount() > maxOccurrence) {
                    maxOccurrence = node.getCount();
                    mostFrequent = node.getData();
                }
                nodeAdded = true;
            }
        }
    }

    /**
     * public int getCount()
     * Accessor method that returns a reference to the total number of elements processed by this Binary Search Tree.
     * @return int
     *  The total number of elements processed by this Binary Search Tree.
     */
    public int getCount() {
        return count;
    }

    /**
     * public getMaxOccurrence()
     * Accessor method that returns the number of times the most frequent element occurred in this Binary Search Tree.
     * @return int
     *  The number of times the most frequent element occurred in this Binary Search Tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public int getMaxOccurrence() {
        return maxOccurrence;
    }

    /**
     * public T getMostFrequent()
     * Accessor method that returns a reference to the most frequently occurring element in this Binary Search Tree.
     * @return T
     *  A reference to the most frequently occurring element in this Binary Search Tree.
     */
    public T getMostFrequent() {
        return mostFrequent;
    }

    /**
     * public BTNode<T> getRoot()
     * Accessor method that returns the root node of this Binary Search Tree.
     * @return BTNode<T>
     *  The root node of this Binary Search Tree.
     */
    public BTNode<T> getRoot() {
        return root;
    }

    /**
     * public void parse()
     * Parses the data one element at a time and adds that elements to the Binary Search Tree if the element is not
     * already in the Binary Search Tree.
     * @param data
     *  The data being added to the Binary Search Tree.
     * @postcondition
     *  The data has been added to the Binary Search Tree one element at a time. Each unique element is added in it's
     *  own node and if there is a duplicate element, then a counter is incremented.
     */
    @SuppressWarnings("unchecked")
    public void parse(TextParser data) {
        if (data == null) { return; }

        T cursor = (T) data.getNextWord();

        count = 0;
        root = new BTNode<>(cursor, null, null);
        while (cursor != null) {
            count++;
            add(root, cursor);
            cursor = (T) data.getNextWord();
        }
    }

    /**
     * public void postorderTraversal(BTNode<T> cursor)
     * An post-order traversal to print the data from the first 20 nodes in this Binary Search Tree.
     * @postcondition
     *  The data of the first 20 nodes have been written by System.out.println().
     */
    public void postorderTraversal(BTNode<T> cursor) {
        if (cursor == null) { return; }
        postorderTraversal(cursor.getLeft());
        postorderTraversal(cursor.getRight());
        depth++;
        if (depth <= MAX_DEPTH) {
            System.out.println(cursor.getData());
        }
    }

    /**
     * public void preorderPrint(BTNode<T> cursor)
     * An pre-order traversal to print the data from the first 20 nodes in this Binary Search Tree.
     * @postcondition
     *  The data of the first 20 nodes have been written by System.out.println().
     */
    public void preorderTraversal(BTNode<T> cursor) {
        if (cursor == null) { return; }

        if (depth < MAX_DEPTH) {
            System.out.println(cursor.getData());
        }
        depth++;
        preorderTraversal(cursor.getLeft());
        preorderTraversal(cursor.getRight());
    }

    /**
     * public int search(String element)
     * Accessor method that returns the number of times the specified element was processed by this Binary Search Tree.
     * @param element
     *  The element to search for in this Binary Search Tree.
     * @return int
     *  The number of times the specified element was processed by this Binary Search Tree.
     */
    public int search(T element) {
        boolean terminate = false;
        BTNode<T> cursor = root;

        while (!terminate) {
            if (element.compareTo(cursor.getData()) < 0) {
                if (cursor.getLeft() == null) {
                    terminate = true;
                } else {
                    cursor = cursor.getLeft();
                }
            } else if (element.compareTo(cursor.getData()) > 0) {
                if (cursor.getRight() == null) {
                    terminate = true;
                } else {
                    cursor = cursor.getRight();
                }
            } else {
                return cursor.getCount();
            }
        }
        return 0;
    }

    /**
     * public void setDepth(int depth)
     * Mutator method that sets the instance variable depth to the specified depth
     * @param depth
     *  The target depth.
     * @postcondition
     *  The instance variable depth has been initialized to the specified depth.
     */
    public void setDepth(int depth) {
        BinarySearchTree.depth = depth;
    }

    /**
     * public int size()
     * Accessor method that determines how many nodes are in this tree.
     * @return int
     *  The number of nodes in this Binary Search Tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public int size() {
        return BTNode.treeSize(root);
    }

    /**
     * public String toString()
     * Print the data in every node within this Binary Search Tree.
     * @return String
     *  The data from each node in this Binary Search Tree.
     */
    @Override
    public String toString() {
        root.inorderPrint();
        return "";
    }
}
