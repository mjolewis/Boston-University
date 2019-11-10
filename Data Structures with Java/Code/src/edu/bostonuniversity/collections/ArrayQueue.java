// File ArrayQueue.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;

/**********************************************************************************************************************
 * A ArrayQueue is a First-in/First-out data structure of ordered items such that items can be inserted at one end
 * (called the rear) and removed from the other end (called the front). The item at the front of the Queue is called
 * the first item.
 *
 * @note
 *  1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *  2. A queue's capacity cannot exceed Integer.MAX_VALUE. Any attempt to create a larger capacity results in failure
 *     due to arithmetic overflow.
 *  3. The capacity of the queues can change after it's created, but the capacity is limited by the amount of free
 *     memory on the machine. The constructors, ensureCapacity, add, and trimToSize will result in an OutOfMemoryError
 *     when free memory is exhausted.
 *
 * @author mlewis
 * @version Nov 10, 2019
 *********************************************************************************************************************/

public class ArrayQueue<E> implements Queue {
    // Invariant of the ArrayQueue class.
    // 1. For a nonempty ArrayQueue, the items in the ArrayQueue are stored in a circular array beginning at
    //    data[front] and continuing through data[rear].
    // 2. The instance variable size is the number of items in this ArrayQueue.
    // 3. This ArrayQueue is a first-in/first-out data structure, so items are added at the rear and removed at the
    //    front.
    private int front;
    private int rear;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;

    /**
     * public ArrayQueue()
     * Initialize an ArrayQueue with an initial capacity of 10 elements.
     * @postcondition
     *  This ArrayQueue has been initialized with an initial capacity of 10 elements.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this ArrayQueue.
     */
    public ArrayQueue() {
        front = 0;
        rear = 0;
        size = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    /**
     * public void add(E item)
     * Mutator method that adds a new item to the rear of the Queue. The new item may be a null reference.
     * @param item
     *  The item to be added to the Queue.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this item.
     */
    @Override
    public void add(Object item) {


    }

    /**
     * public boolean isEmpty()
     * Accessor method that determines whether or not this Queue is empty.
     * @return boolean
     *  True if this Queue is empty. Otherwise false.
     * @postcondition
     *  This Queue has not been modified.
     */
    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public Object remove() {
        return null;
    }

    /**
     * public int size()
     * Accessor method to determine the number of elements in this Queue.
     * @return int
     *  The number of items in this Queue.
     * @postcondition
     *  This Queue has not been modified.
     */
    @Override
    public int size() { return size; }
}
