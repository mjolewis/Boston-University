/**
 * Guessing Game:
 *   A class that implements the "I am thinking of a number between 1 and 1000". The computer will think of the number,
 *   and the user will repeatedly guess until he/she answers correctly. The program will tell the user if the guesses
 *   are too high or too low. This only needs to be a console game. When the user guesses the correct number, the game
 *   should show the user how many turns it took. You must handle incorrect input (letters when numbers were wanted).
 *
 *   @author :   Michael Lewis
 *   Date    :   9/14/18
 *   Class   :   MET CS342
 *   Issues  :   None known
 */
public class GuessingGame {
    private boolean hasWon = false;  // Track whether or not a user guessed the target number
    private int numberOfGuesses = 0; // Track how many guesses it took to find the target number
    private int targetNumber; // The number the computer picks and the user tries to guess

    /**
     * public GuessingGame()
     *   Construct a Game with a specified target number
     */
    public GuessingGame() {
        setTargetNumber();
    }

    /**
     * private void setHasWon(boolean hasWon)
     *   Set the game status equal to the inverse of the given parameter. True become False and False become True
     * @param hasWon The current status of the game
     */
    public void setHasWon(boolean hasWon) {
        this.hasWon = !hasWon;
    }

    /**
     * private boolean getHasWon()
     *   Get the status of the game. True if the user has guessed the target number. False otherwise
     * @return True if the user has guessed the target number. False otherwise
     */
    public boolean getHasWon() {
        return hasWon;
    }

    /**
     * private void setNumberOfGuesses()
     *   Increases the number of guesses by one
     * Precondition : The user has attempted a guess
     */
    public void setNumberOfGuesses() {
        numberOfGuesses++;
    }

    /**
     * private int getNumberOfGuesses()
     *   Get the number of attempts the user has taken
     * @return An integer value totaling the number of attempts the user has taken
     */
    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    /**
     * private void setTargetNumber()
     *   Set target number to a pseudo random number between 1 and 1000
     */
    public void setTargetNumber() {
        this.targetNumber = (int) (Math.random() * 1000) + 1;
    }

    /**
     * private int getTargetNumber()
     *   Get the target number
     * Precondition : Target number is a number
     * @return A number between 1 and 1000
     */
    public int getTargetNumber() {
        return targetNumber;
    }
}
