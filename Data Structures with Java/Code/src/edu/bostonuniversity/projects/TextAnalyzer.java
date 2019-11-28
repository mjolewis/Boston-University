// File BinaryTree.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;

/**********************************************************************************************************************
 * A TextAnalyzer class is used to add E objects to a binary tree. If the E object is already in the binary tree
 * (using the Comparable interface) we increment a counter instead of adding a duplicate node.
 *
 * @author mlewis
 * @version November 27, 2019
 *********************************************************************************************************************/

public class TextAnalyzer<T extends Comparable<? super T>> {
    // Invariant of the TextAnalyzer.java class
    //  1. The instance variable root is a reference to the root of a Binary Search Tree.
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
     * public BTNode<T> parseText(BTNode<T>, T word)
     * Mutator method that adds the given word to a node in the binary tree in lexicographic order. If the word is
     * already in the binary tree then we do not add the word and instead update the instance variable counter
     * associated with the given word.
     * @param root
     *  The root of this binary tree.
     * @param word
     *  The word to add to the binary tree. If the word is already in the tree, we do not add it. Instead, we increment
     *  the words counter.
     * @postcondition
     *  The word has been added to the binary tree in lexicographic order if the word was not already in the tree.
     *  Otherwise, the word is already in the tree and it has not been added; however, the counter associated with the
     *  word has been incremented.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new word.
     */
    public BTNode<T> add(BTNode<T> root, T word) {
        if (root == null) { root = new BTNode<T>(word, null, null); }

        if (root.getData().compareTo(word) < 0) { return add(root.getLeft(), word); }
        if (root.getData().compareTo(word) == 0) { root.incrementCount(); }
        if (root.getData().compareTo(word) > 0) { return add(root.getRight(), word); }

        return root;
    }

    /**
     * public BTNode<T> getRoot()
     * Accessor method that returns the root node of this binary tree.
     * @return BTNode<T>
     *  The root node of this binary tree.
     */
    public BTNode<T> getRoot() { return root; }

    /**
     * public int size()
     * Accessor method that determines how many nodes are in this tree.
     * @return int
     *  The number of nodes in this tree.
     */
    public int size() {
        int count;

        count = 0;
        while (root.getLeft() != null) { count++; }
        while (root.getRight() != null) { count++; }

        return count;
    }
}