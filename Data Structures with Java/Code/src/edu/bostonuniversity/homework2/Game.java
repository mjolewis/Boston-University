// File Game.jave from the package edu.bostonuniversity.homework2

package edu.bostonuniversity.homework2;
import edu.bostonuniversity.collections.LinkedStack;
import edu.bostonuniversity.nodes.NodeList;

/**********************************************************************************************************************
 * A Game is a sequence of choices attempting to solve the 8 Queens problem on a chess board. Each choice consists of a
 * row and column number and is then pushed onto a LinkedStack.
 *
 * The 8 Queens problem postulates that you can place 8 Queens on a chess board, so that no Queen could capture any
 * other.
 *
 * @note
 *  1. Beyond Integer.MAX_VALUE elements, the size method in LinkedStack does not work.
 *
 * @author mlewis
 * @version Oct 17, 2019
 *********************************************************************************************************************/

public class Game {
    // Invariant of the Game class.
    //  1. The instance variable stack is a LinkedStack.
    //  2. The instance variable success indicates whether or not a solution to the 8 queens problem has been found.
    //  3. The instance variable boardSize indicates how many rows and columns are on the chess board.
    //  4. Stack will have access to a top node and size variables within the LinkedStack.java class.
    private boolean success;
    private int boardSize;
    private LinkedStack<Integer> stack;

    /**
     * A default constructor.
     * @postcondition
     *   This LinkedStack has been initialized with a board size of 8 rows and 8 columns.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Game.
     */
    public Game() {
        this.boardSize = 8;
    }

    /**
     * Initialize the game with an empty LinkedStack.
     * @postcondition
     *   This LinkedStack is empty.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Game.
     */
    public Game(int boardSize) {
        success = false;
        this.boardSize = boardSize;
        stack = new LinkedStack<>();
    }

    /**
     * Attempts to find a solution for the 8 queens problem. If a solution is found, the instance variable success is
     * set to true
     * @return boolean
     *  Indicates whether or not a solution to the 8 queens problem has been found
     */
    public boolean play() {
        while (!success && !stack.isEmpty()) {
            NodeList current;
            for (current = stack.getHead(); current.getNext() != null; current = current.getNext()) {
                if (current.getData() == stack.getHead().getData()) {

                }
            }
        }
    }

}
