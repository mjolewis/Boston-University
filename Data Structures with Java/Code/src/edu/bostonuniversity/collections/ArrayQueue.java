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
 * @version Nov 9, 2019
 *********************************************************************************************************************/

public class ArrayQueue implements Queue {
}
