// File BinarySearchTreeMain.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;
import edu.bu.met.cs342a1.TextParser;

/**********************************************************************************************************************
 * BinarySearchTreeMain initializes a Binary Search Tree object that is used to read in a body of text, insert the text
 * into a Binary Search Tree, and answer a series of questions about the body of text.
 *
 * @author mlewis
 * @version November 28, 2019
 *********************************************************************************************************************/

public class BinarySearchTreeMain {
    // Invariant of the BinarySearchTreeMain class.
    //  1. The instance variable FILE_NAME is an absolute pathname to a text file on your local system.
    //  2. The instance variable binarySearchTree is a binarySearchTree object used to build a Binary Search Tree
    //     the text from the text stored in FILE_NAME.
    //  3. The instance variable parser is a TextParser object used to read in a text file stored at FILE_NAME.
    private static final String FILE_NAME = "/Users/mlewis/Downloads/Dracula.txt";
    private BinarySearchTree<String> binarySearchTree;
    private TextParser parser;

    /**
     * public void buildTree()
     * Helper method that builds a binary search tree from the text stored in the specified file.
     * @postcondition
     *  A binary search tree has been built using the text stored in the specified file.
     */
    private void buildTree() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.parse(parser);
        query();
    }

    /**
     * public static void main(String[] args)
     * The main entry point for the BinarySearchTreeMain.java class
     * @param args
     *  The required signature for Java's main method.
     */
    public static void main(String[] args) {
        BinarySearchTreeMain start = new BinarySearchTreeMain();
        start.openFile();
    }

    /**
     * public void openFile()
     * Helper method to open a file from a specified absolute path.
     * @postcondition
     *  If the file exists, then it has been opened.
     */
    private void openFile() {
        parser = new TextParser();
        boolean fileExists = parser.openFile(BinarySearchTreeMain.FILE_NAME);
        if (fileExists) { buildTree(); }
    }

    /**
     * public void query()
     * Helper method to query the Binary Search Tree and programmatically answer a series of questions.
     * @postcondition
     *  All questions have programmatically been answered and written to the terminal using System.out.println().
     */
    private void query() {
        int answer;
        System.out.println("How many times do each of the following words appear in the text?");
        answer = binarySearchTree.search("transylvania");
        System.out.println("transylvania appears " + answer + " times.");

        answer = binarySearchTree.search("harker");
        System.out.println("harker appears " + answer + " times.");

        answer = binarySearchTree.search("renfield");
        System.out.println("renfield appears " + answer + " times.");

        answer = binarySearchTree.search("vampire");
        System.out.println("vampire appears " + answer + " times.");

        answer = binarySearchTree.search("expostulate");
        System.out.println("expostulate appears " + answer + " times.");

        answer = binarySearchTree.search("fang");
        System.out.println("fang appears " + answer + " times.");

        System.out.println();
        System.out.println("The depth of the tree is " + BTNode.treeDepth(binarySearchTree.getRoot()) + " nodes.");

        System.out.println();
        System.out.println("There are " + binarySearchTree.size() + " different words in the book.");

        System.out.println();
        System.out.println("The word at the root of the tree is \"" + binarySearchTree.getRoot().getData() + "\".");

//        System.out.println();
//        System.out.println("The words at the deepest leaves in the tree are: " + );

        System.out.println();
        System.out.println("There are " + binarySearchTree.getCount() + " words in the book.");

        System.out.println();
        System.out.println("\"" + binarySearchTree.getMostFrequent() + "\" occurs most frequently.");

        binarySearchTree.setDepth(0);
        System.out.println("\n");
        System.out.println("The first 20 words in a pre-order traversal are: ");
        binarySearchTree.preorderTraversal(binarySearchTree.getRoot());

        binarySearchTree.setDepth(0);
        System.out.println("\n");
        System.out.println("The first 20 words in a post-order traversal are: ");
        binarySearchTree.postorderTraversal(binarySearchTree.getRoot());

        binarySearchTree.setDepth(0);
        System.out.println("\n");
        System.out.println("The first 20 words in a in-order traversal are: ");
        binarySearchTree.inorderTraversal(binarySearchTree.getRoot());
    }
}
