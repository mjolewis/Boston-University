// File CalculatePrimes.java from the package edu.bostonuniversity.projects

package edu.bostonuniversity.projects;

import edu.bostonuniversity.collections.ArrayQueue;

/**********************************************************************************************************************
 * The calculate primes class uses the Sieve of Eratosthenes methodology to calculate all the prime numbers up to some
 * integer n. The technique was developed by a Greek mathematician and poet Eratosthenes who lived in the third century
 *  BC and it is implemented with an ArrayQueue.
 *
 * @note
 *  1) Beyond Integer.MAX_VALUE elements, the ArrayQueue won't work properly.
 *
 * @author mlewis
 * @version Nov 11, 2019
 *********************************************************************************************************************/

public class CalculatePrimes {
    // Invariant of the CalculatePrimes class.
    //  1. The instance variable numbers is an ArrayQueue that has been initialized with consecutive integers 2 through
    //     n inclusive.
    //  2. The instance variable primes is an ArrayQueue that stores all the prime numbers calculated by the Sieve of
    //     Eratosthenes algorithm.
    //  3. The variable START_VALUE is a constant that references the first prime number (2).
    private ArrayQueue<Integer> numbers;
    private ArrayQueue<Integer> primes;
    private static final int START_VALUE = 2;

    /**
     * public CalculatePrimes()
     * A default constructor that initializes the numbers queue and prime queue to their initial capacity.
     * @postcondition
     *  This numbers queue has been initialized with 10 elements. The integer value at index 0 is 2 and each subsequent
     *  index is initialized to a value that has been incremented by 1. The prime queue is empty, but has a default
     *  capacity of 10.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this queue.
     */
    public CalculatePrimes() {
        numbers = new ArrayQueue<>();
        primes = new ArrayQueue<>();

        addAll( 1 + numbers.getCapacity());
    }

    /**
     * public CalculatePrimes(int capacity)
     * An overloaded constructor that initializes the numbers queue and prime queue to the specified capacity.
     * @param capacity
     *  The initial capacity for this numbers queue and prime queue.
     * @postcondition
     *  This numbers queue has been initialized with the specified capacity. The integer value at index 0 is 2 and each
     *  subsequent index is initialized to a value that has been incremented by 1. The prime queue is empty, but has
     *  been initialized to the specified capacity.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this queue.
     */
    public CalculatePrimes(int capacity) {
        numbers = new ArrayQueue<>(capacity);
        primes = new ArrayQueue<>(capacity);

        addAll(1 + capacity);
    }

    /**
     * private void addAll(int n)
     * Helper method that fills the numbers queue with integers 2 through n inclusive.
     * @param n
     *  The final number added to the numbers queue.
     * @postcondition
     *  The numbers queue has been filled with numbers 2 through n inclusive.
     */
    private void addAll(int n) {
        for (int i = START_VALUE; i <= n; i++) {
            numbers.add(i);
        }
    }

    /**
     * public ArrayQueue getNumbers()
     * Accessor method that returns a reference to the numbers ArrayQueue.
     * @return ArrayQueue
     *  A reference to the numbers ArrayQueue
     */
    public ArrayQueue getNumbers() { return numbers; }

    /**
     * public ArrayQueue getPrimes()
     * Accessor method that returns a reference to the primes ArrayQueue.
     * @return ArrayQueue
     *  A reference to the primes ArrayQueue
     */
    public ArrayQueue getPrimes() { return primes; }

    /**
     * public void findPrimeNumbers()
     * A method that finds all prime numbers from 2 to n inclusive. The method adds all prime numbers to an array-based
     * queue that automatically re-sizes if it's capacity has been reached.
     * @precondition
     *  The numbers 2 through n have been added to the numbers queue.
     * @return ArrayQueue<E>
     *  An ArrayQueue filled with all prime numbers from 2 to n inclusive.
     * @postcodition
     *  All prime numbers from 2 to n inclusive have been added to the primes ArrayQueue.
     */
    public void findPrimeNumbers() {
        do {
            int item = numbers.remove();
            primes.add(item);

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.getItem(i) % item == 0) {
                    numbers
                }
            }
        }
    }
}
