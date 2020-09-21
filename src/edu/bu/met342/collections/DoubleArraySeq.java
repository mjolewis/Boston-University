package edu.bu.met342.collections;

// FILE: DoubeArraySeq.java from the package edu.bostonuniversity.collections

// This is a programming project from chapter 3 of "Data Structures and Other Objects Using Java" by Michael Main.

/**********************************************************************************************************************
 * A DoubleArraySeq is a collection of double numbers.
 * The sequence can have a special "current element", which is specified and accessed through four methods available in
 * the sequence class (start, getCurrent, advance, and isCurrent).
 *
 * @note
 *   1. The capacity of a sequence can change after it's created, but the maximum capacity is limited by the amount of
 *      free memory on the machine. The constructor, addAfter, addBefore, clone, and concatenation will result in an
 *      OutOfMemoryError when free memory is exhausted.
 *   <p></p>
 *   2. A sequence's capacity cannot exceed the maximum integer 2,147,483,647 (Integer.MAX_VALUE). Any attempt to
 *      create a larger capacity results in a failure due to an arithmetic overflow.
 *
 * @author mlewis
 * @version Sep 18, 2019
 *********************************************************************************************************************/

public class DoubleArraySeq implements Cloneable {
    // Invariant of the DoubleArraySeq class:
    //   1. The number of elements in the sequence is stored in the instance variable manyItems.
    //   2. For an empty sequence (with no elements), we do not care what is stored in any of data; for a nonempty
    //      sequence, the elements of the sequence are stored from the front to the end in data[0] to
    //      data[manyItems - 1] and we don't care what is stored in the rest of data.
    //   3. If there is a current element, then it lies in data[currentIndex]; if there is no current element, then
    //      currentIndex equals manyItems.
    private double[] data;
    private int manyItems;
    private int currentIndex;

    /**
     * Initializes an empty sequence with an initial capacity of 10. Note that the addAfter and addBefore methods work
     * efficiently (without needing more memory) until this capacity is reached.
     * @postcondition
     *   This sequence is empty and has an initial capacity of 10.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new double[10].
     */
    private DoubleArraySeq() { data = new double[10]; }

    /**
     * Initializes an empty sequence with a specified initial capacity. Note that the addAfter and addBefore methods
     * work efficiently (without needing more memory) until this capacity is reached.
     * @param initialCapacity
     *   The initial capacity of this sequence.
     * @precondition
     *   initialCapacity is non-negative.
     * @postcondition
     *   This sequence is empty and has the given initial capacity.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new double[initialCapacity].
     */
    private DoubleArraySeq(int initialCapacity) { data = new double[initialCapacity]; }

    /**
     * Activates the no arg constructor for DoubleArraySeq. Note that the addAfter and addBefore methods work
     * efficiently (without needing more memory) until this capacity is reached.
     * @postcondition
     *   This sequence is empty and has an initial capacity of 10.
     * @return
     *   A reference to a DoubleArraySeq object. Initial capacity is 10.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new double[10].
     */
    public static DoubleArraySeq getInstance() { return new DoubleArraySeq(); }

    /**
     * Activates the single argument constructor for DoubleArraySeq with a specified initial capacity. Note that the
     * addAfter and addBefore methods work efficiently (without needing more memory) until this capacity is reached.
     * @param initialCapacity
     *   The initial capacity of this sequence.
     * @precondition
     *   initialCapacity is non-negative.
     * @postcondition
     *   This sequence is empty and has the given initial capacity.
     * @return
     *   A reference to a DoubleArraySeq object with the specified initial capacity.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new double[initialCapacity].
     * @exception IllegalArgumentException
     *   Indicates that initial capacity is negative.
     */
    public static DoubleArraySeq getInstance(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Initial capacity must be non-negative.");
        return new DoubleArraySeq(initialCapacity);
    }

    /**
     * Adds a new element to this sequence after the current element. If this new element would take this sequence
     * beyond its current capacity, then the capacity is increased before adding the new element.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to this sequence. If there was a current element, then addAfter
     *   places the new element after the current element. If there was no current element, then addAfter places the
     *   new element at the end of this sequence. In all cases, the new element becomes the new current element of this
     *   sequence.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory to increase the size of this sequence.
     * @note
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence to fail with an
     *   arithmetic overflow.
     */
    public void addAfter(double element) {
        if (manyItems == data.length) { ensureCapacity(manyItems * 2 + 1); }

        if (!isCurrent()) { currentIndex = manyItems; }
        for (int i = manyItems; i > currentIndex + 1; i--) {
            data[i] = data[i - 1];
        }
        data[++currentIndex] = element;
        manyItems++;
    }

    /**
     * Adds a new element to this sequence before the current element. If this new element would take this sequence
     * beyond its current capacity, then the capacity is increased before adding the new element.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to this sequence. If there was a current element, then addBefore
     *   places the new element before the current element. If there was no current element, then addBefore places the
     *   new element at the front of this sequence. In all cases, the new element becomes the new current element of
     *   this sequence.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory to increase the size of this sequence.
     * @note
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence to fail with an
     *   arithmetic overflow.
     */
    public void addBefore(double element) {
        if (manyItems == data.length) { ensureCapacity(manyItems * 2 + 1); }

        if (!isCurrent()) { currentIndex = 0; }
        for (int i = manyItems; i > currentIndex; i--) {
            data[i] = data[i - 1];
        }
        data[currentIndex] = element;
        manyItems++;
    }

    /**
     * Place the contents of another sequence at the end of this sequence.
     * @param addend
     *   A sequence whose contents will be placed at the end of this sequence.
     * @precondition
     *   The parameter, addend, is not null.
     * @postcondition
     *   The elements from addend have been placed at the end of this sequence. The current element of this sequence
     *   remains where it was, and the addend is also unchanged.
     * @exception NullPointerException
     *   Indicates that addend is null
     * @exception OutOfMemoryError
     *   Indicates insufficient memory to increase the capacity of this sequence.
     * @note
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence to fail with an
     *   arithmetic overflow.
     */
    public void addAll(DoubleArraySeq addend) {
        ensureCapacity(manyItems * 2 + 1);

        System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
        manyItems += addend.manyItems;
    }

    /**
     * Move forward so that the current element is now the next element in this sequence.
     * @precondition
     *   isCurrent() returns true.
     * @postcondition
     *   If the current element was already the end element of this sequence (with nothing after it), then there is no
     *   longer any current element. Otherwise, the new element is the element immediately after the original current
     *   element.
     * @exception IllegalStateException
     *   Indicates that there is no current element, so advance may not be called.
     */
    public void advance() {
        if (isCurrent() && currentIndex < manyItems - 1) { currentIndex++; }
        else {
            throw new IllegalStateException("The current element was already at the end of this sequence. Advancing " +
                    "beyond the sequence is not allowed."); }
    }

    /**
     * Generate a copy of this sequence.
     * @return
     *   The return value is a copy of this sequence. Subsequent changes to the copy will not affect the original, nor
     *   vice versa. The return value must be typecast to a DoubleArraySeq before it is used.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for creating the clone.
     * @exception CloneNotSupportedException
     *   Indicates a programming error that made super.clone unavailable. The most common cause would be forgetting to
     *   "implement Cloneable".
     */
    public DoubleArraySeq clone() {
        DoubleArraySeq answer;

        try {
            answer = (DoubleArraySeq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }

        answer.data = data.clone(); // Array's need extra work for copying. Else answer.data is a reference to data
        return answer;
    }

    /**
     * Create a new sequence that contains all the elements from one sequence followed by another.
     * @param s1
     *   The first of two sequences.
     * @param s2
     *   The second of two sequences.
     * @precondition
     *   Neither s1 nor s2 is null.
     * @return
     *   A new sequence that has the elements of s1 followed by the elements of s2 (with no current element).
     * @exception NullPointerException
     *   Indicates that one (or both) of the arguments is (are) null.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new sequence.
     * @note
     *   An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence to fail with an
     *   arithmetic overflow.
     */
    public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2) {
        DoubleArraySeq answer = new DoubleArraySeq(s1.getCapacity() + s2.getCapacity());

        System.arraycopy(s1.data, 0, answer.data, 0, s1.manyItems);
        System.arraycopy(s2.data, 0, answer.data, s1.manyItems, s2.manyItems);
        answer.manyItems = s1.manyItems + s2.manyItems;
        return answer;
    }

    /**
     * Change the current capacity of this sequence.
     * @param minimumCapacity
     *   The new capacity for this sequence.
     * @postcondition
     *   This sequence's capacity has been changed to at least minimumCapacity.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new double[minimumCapacity).
     */
    public void ensureCapacity(int minimumCapacity) {
        double[] biggerArray;

        if (data.length < minimumCapacity) {
            biggerArray = new double[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    /**
     * Accessor method to determine the current capacity of this sequence. The addBefore and addAfter methods work
     * efficiently (without needing more memory) until this capacity is reached.
     * @return
     *   The current capacity of this sequence.
     */
    public int getCapacity() { return data.length; }

    /**
     * Accessor method to determine the current element of this sequence.
     * @precondition
     *   isCurrent() returns true.
     * @return
     *   The current element of this sequence.
     * @exception IllegalStateException
     *   Indicates that there is no current element.
     */
    public double getCurrent() {
        if (isCurrent()) { return data[currentIndex]; }
        else { throw new IllegalStateException("There is no current element"); }
    }

    /**
     * Accessor method to determine whether this sequence has a specified current element that can be retrieved with
     * the getCurrent method.
     * @return
     *   true (there is a current element) or false (there is no current element at the moment).
     */
    public boolean isCurrent() { return currentIndex != manyItems; }

    /**
     * Remove the current element from this sequence.
     * @precondition
     *   isCurrent() returns true.
     * @postcondition
     *   The current element has been removed from this sequence, and the following element (if there is one) is now
     *   the new current element. If there was no following element, then there is now no current element.
     * @exception IllegalStateException
     *   Indicates that there is no current element, so removeCurrent may not be called.
     */
    public void removeCurrent() {
        if (isCurrent()) {
            data[currentIndex] = data[--manyItems];
        }
    }

    /**
     * Accessor method to determine the number of elements in this sequence.
     * @return
     *   The number of elements in this sequence.
     */
    public int size() { return manyItems; }

    /**
     * Set the current element at the front of this sequence.
     * @postcondition
     *   The front element of this sequence is now the current element (but if this sequence has no elements at all,
     *   then there is no current element.
     */
    public void start() { if (isCurrent() && manyItems > 0) currentIndex = 0; }

    /**
     * Reduce the current capacity of this sequence to its actual size (e.g. the number of elements it contains).
     * @postcondition
     *   This sequence's capacity has been changed to its current size.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for altering the capacity.
     */
    public void trimToSize() {
        double[] trimmedArray;

        if (data.length != manyItems) {
            trimmedArray = new double[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
}
