// File TextAnalyzerMain.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.nodes.BTNode;
import edu.bu.met.cs342a1.TextParser;

/**********************************************************************************************************************
 * TextAnalyzerMain initializes a TextAnalyzer object that is used to read in a body of text, insert the text into a
 * binary tree, and answer a series of questions about the body of text.
 *
 * @author mlewis
 * @version November 28, 2019
 *********************************************************************************************************************/

public class TextAnalyzerMain {
    // Invariant of the TextAnalyzerMain class.
    //  1. The instance variable FILE_NAME is an absolute pathname to a text file on your local system.
    //  2. The instance variable textAnalyzer is a TextAnalyzer object used to build a binary tree from the text from
    //     the text stored in FILE_NAME.
    //  3. The instance variable parser is a TextParser object used to read in a text file stored at FILE_NAME.
    //  4. The instance variable fileExists is a boolean object used to confirm whether or not the file stored in
    //     FILE_NAME exists and has been opened for processing.
    private static final String FILE_NAME = "/Users/mlewis/Downloads/Dracula.txt";
    private BinarySearchTree<String> binarySearchTree;
    private TextParser parser;
    private boolean fileExists;

    /**
     * public void buildTree(TextParser file)
     * Builds a binary search tree from the text stored in the specified file.
     * @postcondition
     *  A binary search tree has been built using the text stored in the specified file.
     */
    public void buildTree(TextParser file) {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.parse(parser);
        query();
    }

    /**
     * public static void main(String[] args)
     * The main entry point for the TextAnalyzer.java class
     * @param args
     *  The required signature for Java's main method.
     */
    public static void main(String[] args) {
        TextAnalyzerMain start = new TextAnalyzerMain();
        start.openFile(FILE_NAME);
    }

    /**
     * public void openFIle(String fileName)
     * @param fileName
     *  The absolute pathname for a file on your local system.
     * @postcondition
     *  If the file exists, then it has been opened.
     */
    public void openFile(String fileName) {
        parser = new TextParser();
        fileExists = parser.openFile(fileName);
        if (fileExists) { buildTree(parser); }
    }

    /**
     * public void query()
     * Query the binary search tree to programmatically answer a series of questions.
     * @postcondition
     *  All questions have programmatically been answered and written to the terminal using System.out.println().
     */
    public void query() {
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

        System.out.println();
        binarySearchTree.setDepth(0);
        System.out.println("The first 20 words in a pre-order traversal are: ");
        binarySearchTree.preorderTraversal(binarySearchTree.getRoot());

        System.out.println();
        binarySearchTree.setDepth(0);
        System.out.println("The first 20 words in a post-order traversal are: ");
        binarySearchTree.postorderTraversal(binarySearchTree.getRoot());

    }
}
