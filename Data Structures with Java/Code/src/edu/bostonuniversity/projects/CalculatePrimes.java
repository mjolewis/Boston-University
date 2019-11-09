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
    //     through n inclusive if the value of n is greater than START_VALUE (+) MINIMUM_SIZE. Otherwise, the
    //     array-based queue has been initialized with 10 elements starting with the START_VALUE.
    //  2. The instance variable primes is an array-based queue that stores all the prime numbers calculated by the
    //     Sieve of Eratosthenes algorithm.
    //  3. The instance variable START_VALUE is the first element in the numbers array.
    //  4. The instance variable MINIMUM_SIZE guarantees the minimum size of the numbers array.
    private int[] numbers;
    private int[] primes;
    private static final int START_VALUE = 2;
    private static final int MINIMUM_SIZE = 10;

    /**
     * public CalculatePrimes()
     * A default constructor that initializes the numbers queue with 10 elements.
     * @postcondition
     *  This numbers queue has been initialized with 10 elements. The integer value at index 0 is 2 and each subsequent
     *  index is initialized to a value that has been incremented by 1.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this queue.
     */
    public CalculatePrimes() {
        numbers = new int[MINIMUM_SIZE];
        for (int i = START_VALUE; i < START_VALUE + MINIMUM_SIZE; i++) {
            numbers[i - START_VALUE] = i;
        }
    }

    /**
     * public CalculatePrimes(int n)
     * An overloaded constructor that initializes the numbers queue with consecutive integers 2 through n inclusive.
     * @param n
     *  The maximum value added to the numbers array.
     * @postcondition
     *  The numbers queue has been initialized with consecutive integers 2 through n inclusive.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this queue.
     */
    public CalculatePrimes(int n) {
        numbers = new int[n];
        if (n < START_VALUE + MINIMUM_SIZE) {
            new CalculatePrimes();
        } else {
            for (int i = START_VALUE; i <= n; i++) {
                numbers[i - START_VALUE] = i;
            }
        }
    }
}
