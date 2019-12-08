// File BinarySearchTree.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;
import edu.bu.met.cs342a1.TextParser;

/**********************************************************************************************************************
 * A BinarySearchTree class is used to add T objects to a binary tree. However, duplicate elements are not added to
 * this Binary Search Tree. Instead, we find the matching data using the comparable interface and increment a counter
 * to keep track of how many times this element occurred.
 *
 * @author mlewis
 * @version Dec 8, 2019
 *********************************************************************************************************************/

public class BinarySearchTree<T extends Comparable<? super T>> {
    // Invariant of the BinarySearchTree.java class
    //  1. The instance variable count is a reference to the total number of elements being added to this Binary Search
    //     Tree.
    //  2. The instance variable depth is a static variable used to terminate the recursive print traversal
    //     activations.
    //  3. The instance variable MAX_DEPTH is the maximum depth allowed during any print traversal activation.
    //  4. The instance variable maxOccurrence is the number of times the most frequent element occurred in this
    //     Binary Search Tree.
    //  5. The instance variable mostFrequent is a reference to the data that most frequently occurred in this Binary
    //     Search Tree.
    //  6. The instance variable root is a reference to the root of a Binary Search Tree.
    private int count;
    private static int depth;
    private static final int MAX_DEPTH = 20;
    private int maxOccurrence;
    private T mostFrequent;
    private BTNode<T> root;

    /**
     * public BinarySearchTree()
     * Initializes an empty BinarySearchTree.
     * @postcondition
     *  An empty BinarySearchTree has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the new BinarySearchTree.
     */
    public BinarySearchTree() {
        root = null;
        count = 0;
        maxOccurrence = 0;
        depth = 0;
    }

    /**
     * public int countOccurrences(T element)
     * Accessor method that returns the number of times the specified element occurred.
     * @param element
     *  The element to search for in this Binary Search Tree.
     * @return int
     *  The number of times the specified element occurred.
     */
    public int countOccurrences(T element) {
        BTNode<T> cursor = root;

        while (true) {
            if (element.compareTo(cursor.getData()) < 0) {
                if (cursor.getLeft() == null) {
                    break;
                } else {
                    cursor = cursor.getLeft();
                }
            } else if (element.compareTo(cursor.getData()) > 0) {
                if (cursor.getRight() == null) {
                    break;
                } else {
                    cursor = cursor.getRight();
                }
            } else {
                return cursor.getCount();
            }
        }
        return 0;
    }

    /*
     * private int depthOfNode(BTNode<T> node)
     * Helper method that calculates the depth of the specified node. Note that node may be a null reference.
     * @param node
     *  The node whose depth we are finding.
     * @param node
     *  A reference to the node for which we calculate its depth.
     */
    private int depthOfNode(BTNode<T> node) {
        BTNode<T> cursor = root;

        while (true) {
            depth++;
            if (node.getData().compareTo(cursor.getData()) < 0) {
                if (cursor.getLeft() == null) {
                    break;
                } else {
                    cursor = cursor.getLeft();
                }
            } else if (node.getData().compareTo(cursor.getData()) > 0) {
                if (cursor.getRight() == null) {
                    break;
                } else {
                    cursor = cursor.getRight();
                }
            } else {
                return depth;
            }
        }
        return depth;
    }

    /**
     * public int getCount()
     * Accessor method that returns a reference to the total number of elements processed by this Binary Search Tree.
     * @return int
     *  The total number of elements processed by this Binary Search Tree.
     */
    public int getCount() { return count; }

    /**
     * public void getDeepestLeaves(BTNode<T> cursor)
     * Finds every leaf that is as deep as the tree depth using a post-order traversal. The data from each of those
     * leaves is then written by System.out.println().
     * @param cursor
     *  The node whose depth we are finding.
     * @postcondition
     *  The data from all the deepest leaves (if the leaf depth is equal to the tree depth) has been written by
     *  System.out.println().
     */
    public void getDeepestLeaves(BTNode<T> cursor) {
        if (cursor == null) { return; }
        getDeepestLeaves(cursor.getLeft());
        getDeepestLeaves(cursor.getRight());
        depth = 0;
        if (depthOfNode(cursor) == BTNode.treeDepth(root)) { System.out.print(cursor.getData()); }
    }

    /**
     * public getMaxOccurrence()
     * Accessor method that returns the number of times the most frequent element occurred in this Binary Search Tree.
     * @return int
     *  The number of times the most frequent element occurred in this Binary Search Tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public int getMaxOccurrence() { return maxOccurrence; }

    /**
     * public T getMostFrequent()
     * Accessor method that returns a reference to the most frequently occurring element in this Binary Search Tree.
     * @return T
     *  A reference to the most frequently occurring element in this Binary Search Tree.
     */
    public T getMostFrequent() { return mostFrequent; }

    /**
     * public BTNode<T> getRoot()
     * Accessor method that returns the root node of this Binary Search Tree.
     * @return BTNode<T>
     *  The root node of this Binary Search Tree.
     */
    public BTNode<T> getRoot() { return root; }

    /**
     * public void inorderPrint(BTNode<T> cursor)
     * The root of this Binary Search Tree. Each recursive call activates the root of a smaller subtree.
     * @param cursor
     *  An inorder traversal to print the data from the first 20 nodes in this Binary Search Tree.
     * @postcondition
     *  The data of the first 20 nodes have been written by System.out.println().
     */
    public void inorderTraversal(BTNode<T> cursor) {
        if (cursor == null) { return; }
        inorderTraversal(cursor.getLeft());
        depth++;
        if (depth <= MAX_DEPTH) { System.out.print(cursor.getData() + " "); }
        inorderTraversal(cursor.getRight());
    }

    /**
     * public void insert(T data)
     * Mutator method that inserts the given data to a node in this Binary Search Tree in lexicographic order. If the
     * data is already in this Binary Search Tree then we do not add the data. Instead, we update the instance variable
     * count by one to count how many times the data occurred.
     * @param data
     *  The data to insert to this Binary Search Tree. If the data is already in the tree, we do not add it. Instead,
     *  we increment the data's counter.
     * @postcondition
     *  The data has been inserted to the Binary Search Tree one element at a time. Each unique element is added;
     *  however, duplicate elements are not added to this Binary Search Tree. Instead, we find the matching data using
     *  the comparable interface and increment a counter to keep track of how many times this element occurred.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new data.
     */
    public void insert(T data) {
        BTNode<T> cursor;

        if (root == null) {
            root = new BTNode<>(data, null, null);
            root.incrementCount();
            return;
        }

        cursor = root;
        while (true) {
            if (data.compareTo(cursor.getData()) < 0) {
                if (cursor.getLeft() == null) {
                    cursor.setLeft(new BTNode<>(data, null, null));
                    cursor.getLeft().incrementCount();
                    break;
                } else {
                    cursor = cursor.getLeft();
                }
            } else if (data.compareTo(cursor.getData()) > 0) {
                if (cursor.getRight() == null) {
                    cursor.setRight(new BTNode<>(data, null, null));
                    cursor.getRight().incrementCount();
                    break;
                } else {
                    cursor = cursor.getRight();
                }
            } else {
                cursor.incrementCount();
                if (cursor.getCount() > maxOccurrence) {
                    maxOccurrence = cursor.getCount();
                    mostFrequent = cursor.getData();
                }
                break;
            }
        }
        count++;
    }

    /**
     * public void parse()
     * Parses the data one element at a time and adds that elements to the Binary Search Tree only if the element is
     * not already in the Binary Search Tree.
     * @param file
     *  The data being added to the Binary Search Tree.
     * @postcondition
     *  The data has been added to the Binary Search Tree one element at a time. Each unique element is added; however,
     *  duplicate elements are not added to this Binary Search Tree. Instead, we find the matching data using the
     *  comparable interface and increment a counter to keep track of how many times this element occurred.
     */
    @SuppressWarnings("unchecked")
    public void parse(TextParser file) {
        T word;
        if (file == null) { return; }
        for(word = (T) file.getNextWord(); word != null; word = (T) file.getNextWord()) {
            insert(word);
        }
    }

    /**
     * public void postorderTraversal(BTNode<T> cursor)
     * An post-order traversal to print the data from the first 20 nodes in this Binary Search Tree.
     * @param cursor
     *  The root of this Binary Search Tree. Each recursive call activates the root of a smaller subtree.
     * @postcondition
     *  The data of the first 20 nodes have been written by System.out.println().
     */
    public void postorderTraversal(BTNode<T> cursor) {
        if (cursor == null) { return; }
        postorderTraversal(cursor.getLeft());
        postorderTraversal(cursor.getRight());
        depth++;
        if (depth <= MAX_DEPTH) { System.out.print(cursor.getData() + " "); }
    }

    /**
     * public void preorderPrint(BTNode<T> cursor)
     * An pre-order traversal to print the data from the first 20 nodes in this Binary Search Tree.
     * @param cursor
     *  The root of this Binary Search Tree. Each recursive call activates the root of a smaller subtree.
     * @postcondition
     *  The data of the first 20 nodes has been written by System.out.println().
     */
    public void preorderTraversal(BTNode<T> cursor) {
        if (cursor == null) { return; }
        if (depth < MAX_DEPTH) { System.out.print(cursor.getData() + " "); }
        depth++;
        preorderTraversal(cursor.getLeft());
        preorderTraversal(cursor.getRight());
    }

    /**
     * public void setDepth(int depth)
     * Mutator method that sets the instance variable depth to the specified depth.
     * @param depth
     *  The target depth.
     * @postcondition
     *  The instance variable depth has been initialized to the specified depth.
     */
    public void setDepth(int depth) { BinarySearchTree.depth = depth; }

    /**
     * public int size()
     * Accessor method that determines how many nodes are in this tree.
     * @return int
     *  The number of nodes in this Binary Search Tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public int size() { return BTNode.treeSize(root); }

    /**
     * public String toString()
     * Print the data of every node within this Binary Search Tree using an pre-order traversal.
     * @return String
     *  The data from each node in this Binary Search Tree.
     */
    @Override
    public String toString() {
        root.preorderPrint();
        return "";
    }
}
