// File Main.Java from the package edu.bostonuniversity.homework2

package edu.bostonuniversity.homework2;

/**********************************************************************************************************************
 * Main.java initiates the Game.java class where a solution for the 8 Queens problem is found.
 *
 * @author mlewis
 * @version Oct 17, 2019
 *********************************************************************************************************************/

public class Main {
    public static void main(String[] args) {
        Game game = new Game(8);
        game.play();
        System.out.println(game);
    }
}
