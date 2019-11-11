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
//        BuildGUI start = new BuildGUI();
//        start.constructGUI();

        CalculatePrimes queue = new CalculatePrimes();

        //queue.getNumbers().print();

        System.out.println();
        queue.getNumbers().add(12);
        //queue.getNumbers().print();

        System.out.println();
        queue.getNumbers().clear();
        queue.getNumbers().trimToSize();
        queue.getNumbers().print();

        System.out.println();
        queue.getNumbers().print();
    }
}
