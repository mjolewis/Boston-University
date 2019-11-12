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
        BuildGUI start = new BuildGUI();
        start.constructGUI();

        CalculatePrimes primes = start.getPrimes();
        while (primes == null) {
            primes = start.getPrimes();
        }
        primes.findPrimeNumbers();

        System.out.println();
        System.out.println("Size of numbers is: " + primes.getNumbers().size());
        start.getPrimes().getNumbers().toString();

        System.out.println();

        System.out.println("Prime numbers are: ");
        primes.getPrimes().toString();
    }
}
