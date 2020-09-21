// FILE Queue.java from the package edu.bostonuniversity.collections

package edu.bu.met342.collections;

/**********************************************************************************************************************
 * A Queue is a First-in/First-out data structure of ordered items such that items can be inserted at one end (called
 * the rear) and removed from the other end (called the front). The item at the front of the Queue is called the first
 * item.
 *
 * @note
 *   1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *
 * @author mlewis
 * @version Nov 1, 2019
 *********************************************************************************************************************/

public interface Queue<E> {

    /**
     * public void add(E item)
     * Mutator method that adds a new item to the rear of the Queue. The new item may be a null reference
     * @param item
     *  The item to be added to the Queue.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this item.
     */
    void add(E item);

    /**
     * public boolean isEmpty()
     * Accessor method that determines whether or not this Queue is empty.
     * @return boolean
     *  True if this Queue is empty. Otherwise false.
     * @postcondition
     *  This Queue has not been modified.
     */
    boolean isEmpty();

    /**
     * public E remove()
     * Mutator method that removes the front item from this Queue.
     * @precondition
     *  This Queue is not empty.
     * @return E
     *  The front item from this Queue.
     * @postcondition
     *  The front item from this Queue has been removed and the next item (if there is one) is now the front item. Size
     *  has been decreased by one.
     */
    E remove();

    /**
     * public int size()
     * Accessor method to determine the number of elements in this Queue.
     * @return int
     *  The number of items in this Queue.
     * @postcondition
     *  This Queue has not been modified.
     */
    int size();
}
