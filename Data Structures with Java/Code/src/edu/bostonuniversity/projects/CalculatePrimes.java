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
    //  3. The instance variable MINIMUM_VALUE guarantees the minimum number of elements in the numbers array. The
    //     MINIMUM_VALUE is initialized to 11 to guarantee the numbers array contains 10 elements because the 0th
    //     index is initialized to the value of 2.
    private ArrayQueue<Integer> numbers;
    private ArrayQueue<Integer> primes;
    private static final int MINIMUM_VALUE = 11;

    /**
     * public CalculatePrimes()
     * A default constructor that initializes the numbers queue with 10 elements.
     * @postcondition
     *  This numbers queue has been initialized with 10 elements. The integer value at index 0 is 2 and each each
     *  subsequent index is initialized to a value that has been incremented by 1.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this queue.
     */
    public CalculatePrimes() {
        numbers = new ArrayQueue[];
        for (int i = 2; i <= MINIMUM_VALUE; i++) {
            numbers[i - 2] = i;
        }
    }

    /**
     * public CalculatePrimes(int n)
     * An overloaded constructor that initializes the numbers queue with consecutive integers 2 through n.
     * @param n
     *  The maximum value added to the numbers array.
     * @postcondition
     *  The numbers queue has been initialized with consecutive integers 2 through n.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this queue.
     */
    public CalculatePrimes(int n) {
        numbers = new ArrayQueue[n];
        if (n <= MINIMUM_VALUE) {
            new CalculatePrimes();
        } else {
            for (int i = 2; i <= n; i++) {
                numbers[i - 2] = i;
            }
        }
    }
}
