package edu.bostonuniversity.projects;

/**********************************************************************************************************************
 * SieveOfEratosthenesMain.java initiates the SieveOfEratosthenes class where the class calculates all the prime
 * numbers up to some integer n. The technique was developed by a Greek mathematician and poet Eratosthenes who lived
 * in the third century BC.
 *
 * @author mlewis
 * @version Nov 8, 2019
 *********************************************************************************************************************/

public class SieveOfEratosthenesMain {
    public static void main(String[] args) {
        UserInput start = new UserInput();
        start.constructGUI();
        String result = start.getUserInput();
        System.out.println(result);
    }
}
