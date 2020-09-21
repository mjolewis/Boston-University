import java.util.Scanner;

/**
 * Play Game:
 *   Starts the game play for the "I am thinking of a number between 1 and 1000" game.
 *
 *   @author :   Michael Lewis
 *   Date    :   9/14/18
 *   Class   :   MET CS342
 *   Issues  :   None known
 */
public class PlayGame {
    /**
     * public static void main(String[] args)
     *   Prompt the user to enter a number. Require an additional entry if previous entry was not a number. Compare the
     *   number to the target number. If the numbers match, print the number of guesses. Otherwise, prompt the user for
     *   another entry.
     * @param args The string argument is not used in this implementation
     * Precondition : User must enter an integer
     */
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();

        Scanner scanner = new Scanner(System.in);
        while (!game.getHasWon()) { // Continue the game until the user enters the target number
            System.out.println("Please guess an integer (e.g 500, 750): ");

            // Require the user to enter an number, otherwise catch a NumberFormatException
            // Print clues on where the target number lies relative to the previous entry
            try{
                game.setNumberOfGuesses();
                int userGuess = Integer.parseInt(scanner.next().trim());
                if (userGuess == game.getTargetNumber()) game.setHasWon(game.getHasWon());
                else if (userGuess > game.getTargetNumber()) System.out.println("CLUE: " + userGuess + " is too large!");
                else System.out.println("CLUE: " + userGuess + " is too small!");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: You must guess an integer. Please try again.");
            }
        }

        // The user entered the target number. Print the results and end the game
        System.out.println("You won! It took you " + game.getNumberOfGuesses() + " guesses.");
        scanner.close();
    }
}
