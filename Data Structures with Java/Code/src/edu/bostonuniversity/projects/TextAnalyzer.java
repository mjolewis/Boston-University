// File BinaryTree.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;
import java.util.Scanner;

/**********************************************************************************************************************
 * A TextAnalyzer class reads in a text file and maps each word to a node in a Binary Tree. If the word is already in
 * this Binary Tree, we increment a counter instead of adding a duplicate. The TextAnalyzer is capable of performing
 * queries on the text.
 *
 * @author mlewis
 * @version November 27, 2019
 *********************************************************************************************************************/

public class TextAnalyzer<E> {
    // Invariant of the TextAnalyzer.java class
    //  1. The instance variable scanner is a Scanner object used to read in a text file.
    //  2. The instance variable root is the root node of the Binary Tree.
    private Scanner scanner;
    private BTNode<E> root;

    /**
     * public TextAnalyzer()
     * Initializes an empty TextAnalyzer.
     * @postcondition
     *  An empty TextAnalyzer has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the new TextAnalyzer.
     */
    public TextAnalyzer() { scanner = new Scanner(System.in); }

    /**
     * private void parseText(String word)
     * A helper method that adds the given word to a node in the binary tree. If the word is already in the binary tree
     * then we do not add the word and instead update the instance variable counter associated with the given word.
     * @param word
     *  The word to add to the binary tree. If the word is already in the tree, we do not add it. Instead, we increment
     *  the words counter.
     * @postcondition
     *  The word has been added to the binary tree if it did not exist. Otherwise, the words counter has been
     *  incremented.
     */
    private void add(String word) {
        String answer;
        E leftWord;
        E rightWord;

        while (leftWord != null) {
            root.getLeft()
        }
        if (answer.equals(word)) {
        }
    }
}
