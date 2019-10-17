// File Game.jave from the package edu.bostonuniversity.homework2

package edu.bostonuniversity.homework2;
import edu.bostonuniversity.collections.LinkedStack;

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
    //  2. Stack will have access to a top node and size variables within the LinkedStack.java class.
    //  3. The instance variable success indicates whether or not a solution to the 8 queens problem has been found.
    private boolean success;
    private LinkedStack<Integer> stack;

    public Game() {
        success = false;
        stack = new LinkedStack<>();
    }

    public boolean play() {
        while (!success && !stack.getSize())
    }

}
