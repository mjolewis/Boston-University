// File CalculatePrimes.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

/**********************************************************************************************************************
 * A calculate primes class uses the Sieve of Eratosthenes to calculate all the prime numbers up to some integer n. The
 * technique was developed by a Greek mathematician and poet Eratosthenes who lived in the third century BC and it is
 * implemented with an array-based queue.
 *
 * @note
 *  1) Beyond Integer.MAX_VALUE elements, the array-based queue won't work properly.
 *
 * @author mlewis
 * @version Nov 9, 2019
 *********************************************************************************************************************/

public class CalculatePrimes {
    // Invariant of the CalculatePrimes class.
    //  1. The instance variable numbers is an array-based queue that has been initialized with consecutive integers 2
    //     through n inclusive.
    //  2. The instance variable primes is an array-based queue that stores all the prime numbers calculated by the
    //     Sieve of Eratosthenes algorithm.
    private ArrayQueue<Integer> numbers;
    private ArrayQueue<Integer> primes;


}
