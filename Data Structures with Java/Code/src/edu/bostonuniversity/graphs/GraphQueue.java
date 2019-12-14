// File GraphQueue.java from the package edu.bostonuniversity.graphs

package edu.bostonuniversity.graphs;

import edu.bostonuniversity.collections.Queue;
import edu.bostonuniversity.nodes.GraphNode;

/**********************************************************************************************************************
 * A GraphQueue is used to implement a breadth-first search of a Graph. The queue keeps track of which vertices might
 * still have unprocessed neighbors. The search beings with a starting vertex, which is processed, marked, and placed
 * in this queue.
 *
 * @author mlewis
 * @version Dec 14, 2019
 *********************************************************************************************************************/

public class GraphQueue<E> implements Queue<E> {
    // Invariant of the GraphQueue.java class
    //  1. The front is a reference to the first node in this Queue.
    //  2. The rear is a reference to the final node in this Queue.
    //  3. The size is a reference to the number of elements in this Queue.
    private GraphNode<E> front;
    private GraphNode<E> rear;
    private int size;


    /**
     * public void add(E item)
     * Mutator method that adds a new item to the rear of the Queue. The new item may be a null reference.
     * @param item
     *  The item to be added to the Queue.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this item.
     */
    @Override
    public void add(E item) {
        if (size == 0) {
            front =
        }
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
    public boolean isEmpty() { return size() == 0; }

    /**
     * public E remove()
     * Mutator method that removes the front item from this Queue.
     * @return E
     *  The front item from this Queue.
     * @precondition
     *  This Queue is not empty.
     * @postcondition
     *  The front item from this Queue has been removed and the next item (if there is one) is now the front item. Size
     *  has been decreased by one.
     */
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
    public int size() {
        return 0;
    }
}
