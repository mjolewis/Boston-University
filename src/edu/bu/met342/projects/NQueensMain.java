// File Main.Java from the package edu.bostonuniversity.homework2

package edu.bu.met342.projects;

/**********************************************************************************************************************
 * Main.java initiates the Game.java class where a solution for the 8 Queens problem is found.
 *
 * @author mlewis
 * @version Oct 17, 2019
 *********************************************************************************************************************/

public class NQueensMain {
    public static void main(String[] args) {
        NQueensGame game = new NQueensGame(8);
        game.play();
        System.out.println(game);
    }
}
