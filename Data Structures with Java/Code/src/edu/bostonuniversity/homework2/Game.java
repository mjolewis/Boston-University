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
        success = false;
        this.boardSize = 8;
        stack = new LinkedStack<>();
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
     * Helper method to determine if there is a diagonal conflict. A diagonal conflict indicates that placing a
     * queen at the given row and column combination would result in an invalid board setup.
     * @param row
     *  Indicates the row on the chess board being tested.
     * @param column
     *  Indicates the column on the chess board being tested.
     * @return boolean
     *  A return value of true indicates that placing a queen on this diagonal path does not violate a valid board set
     *  up. A return value of false indicates that a queen cannot be placed in the given location.
     */
    private boolean isDiagonalValid(int row, int column) {
        int slope;

        try {
            slope = (row - stack.getSize()) / (column - stack.getHead().getData());
        } catch (ArithmeticException e) {
            // This exception should only occur if the column at the top of the stack is equal to the column being
            // tested. If they are equal, then the queens position is invalid and we return false.
            return false;
        }
        return Math.abs(slope) != 1;
    }

    /**
     * Helper method to determine if there is a horizontal conflict. A horizontal conflict indicates that placing a
     * queen at the given row and column combination would result in an invalid board setup.
     * @param row
     *  Indicates the row on the chess board being tested.
     * @return boolean
     *  A return value of true indicates that placing a queen on this horizontal path does not violate a valid board
     *  set up. A return value of false indicates that a queen cannot be placed in the given location.
     */
    private boolean isRowValid(int row) {
        return row != stack.getSize();
    }

    /**
     * Helper method to determine if there is a column conflict. A column conflict indicates that placing a queen at
     * the given row and column combination would result in an invalid board setup.
     * @param column
     * Indicates the column on the chess board being tested.
     * @return boolean
     *  A return value of true indicates that placing a queen on this column does not violate a valid board set up. A
     *  return value of false indicates that a queen cannot be placed in the given location.
     */
    private boolean isColumnValid(int column) {
        int count;
        NodeList current;

        current = stack.getHead();
        for (count = 1; current != null; current = current.getNext()) {
            int tmp = (int) current.getData();
            if (tmp == column) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method used that plays the 8 queens game until a solution is found. The stack is a LinkedStack used to
     * store the positions of the queens on the board.
     * @precondition
     *  A chess board has been constructed.
     * @postcondition
     *  A solution to the 8 queens problem has been found
     */
    public void play() {
        int row = 2; // First Queen has nothing to compare against, so we immediately jump to row 2.
        int column = (int) (Math.random() * 8) + 1;

        stack.add(column); // Add first Queen to the stack to avoid a null pointer exception during first iteration.
        while (!success) {

            column = (int) (Math.random() * 8) + 1; // Used to compare against the column already on the stack.

            if (stack.getSize() == boardSize) {
                success = true;
                System.out.println(stack.toString());
                break;
            } else if (isDiagonalValid(row, column) && isRowValid(row)) {
                row++;
                stack.add(column);
            }
        }
    }

    /**
     * An override method used to print the chess board and the positions of the queens.
     * @return String
     *  A string representation of a chess board and the pattern that solved the 8 queens problem
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < boardSize; i++) {
            stringBuilder.append("\n");
            for (int j = 0; j < boardSize; j++) {
                stringBuilder.append("---");
            }
            for (int k = 0; k < boardSize; k++) {
                if (stack.search(i) == k) {
                    stringBuilder.append("| Q");
                } else {
                    stringBuilder.append(" |");
                }
            }

            stringBuilder.append("|");
        }

        return stringBuilder.toString();
    }
}
