// File GraphQueue.java from the package edu.bostonuniversity.graphs

package edu.bu.met342.graphs;

import edu.bu.met342.nodes.GraphNode;

/**********************************************************************************************************************
 * A GraphQueue is used to implement a breadth-first search of a Graph. The queue keeps track of which vertices might
 * still have unprocessed neighbors. The search beings with a starting vertex, which is processed, marked, and placed
 * in this queue.
 *
 * @author mlewis
 * @version Dec 14, 2019
 *********************************************************************************************************************/

public class GraphQueue {
    // Invariant of the GraphQueue.java class
    //  1. The front is a reference to the first node in this Queue.
    //  2. The rear is a reference to the final node in this Queue.
    //  3. The size is a reference to the number of elements in this Queue.
    private GraphNode front;
    private GraphNode rear;
    private int size;

    public GraphQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * public void add(Integer vertex)
     * Mutator method that adds a new item to the rear of the Queue. The new item may be a null reference.
     * @param vertex
     *  The vertex to be added to the Queue.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this item.
     */
    public void add(Integer vertex) {
        GraphNode graphNode = new GraphNode();
        graphNode.setVertex(vertex);

        if (size == 0) {
            front = graphNode;
            rear = graphNode;
            size++;
        } else {
            rear.setNext(graphNode);
            rear = graphNode;
            size++;
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
    public boolean isEmpty() { return size == 0; }

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
    public Integer remove() {
        Integer answer;

        if (size == 0) { return null; }

        answer = front.getVertex();
        front = front.getNext();
        size--;

        if (size == 0) { front = rear = null; }

        return answer;
    }

    /**
     * public int size()
     * Accessor method to determine the number of elements in this Queue.
     * @return int
     *  The number of items in this Queue.
     * @postcondition
     *  This Queue has not been modified.
     */
    public int size() { return size; }
}
