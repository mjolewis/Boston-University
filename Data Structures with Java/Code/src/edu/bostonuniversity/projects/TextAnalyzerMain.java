// File TextAnalyzerMain.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bu.met.cs342a1.TextParser;

/**********************************************************************************************************************
 * TextAnalyzerMain initializes a TextAnalyzer object that is used to read in a body of text, insert the text into a
 * binary tree, and answer a series of questions about the body of text.
 *
 * @author mlewis
 * @version November 28, 2019
 *********************************************************************************************************************/

public class TextAnalyzerMain {
    public static void main(String[] args) {
        String FILE_NAME = ;
        String word;
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        TextParser parser = new TextParser();
        boolean fileExists;

        fileExists = parser.openFile(FILE_NAME);
        if (fileExists) {
            word = parser.getNextWord();
            while (word != null) {
                textAnalyzer.add(textAnalyzer.getRoot(), word);
                word = parser.getNextWord();
            }
        }
    }
}
