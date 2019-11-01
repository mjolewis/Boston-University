// FILE NodeQueue.java from the package edu.bostonuniversity.nodes

package edu.bostonuniversity.nodes;

/**********************************************************************************************************************
 * A generic Node that provides a node for a LinkedQueue.
 *
 * @note
 *  1. Queues can be of any length, limited by the amount of free memory on the heap.
 *
 * @author mlewis
 * @version Nov 1, 2019
 *********************************************************************************************************************/

public class NodeQueue<E> implements Node<E>{
    // Invariant of the NodeQueue<E> class.
    //   1. The nodes generic data type is in the instance variable data.
    //   2. The instance variable next is null for the final node in the Queue. Otherwise, the instance variable next
    //      is a reference to the next node.
    private E data;
    private NodeQueue<E> next;

    /**
     * Initialize an empty node.
     * @postcondition
     *  This NodeQueue is empty.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this node.
     */
    public NodeQueue() {
        data = null;
        next = null;
    }

    /**
     * public NodeQueue(E data, Node<E> next)
     * Initialize a node with the specified initial data and reference to the next node. Note that the next node may be
     * a null reference, which indicates that the new node has nothing after it.
     * @param data
     *  The initial data of this new node.
     * @param next
     *  A reference to the node after this node. This may be null to indicate that there is no node after this new
     *  node.
     * @postcondition
     *  A new node has been initialized with the given data and reference to the next node.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this node.
     */
    public NodeQueue(E data, NodeQueue<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * public getData()
     * Accessor method to retrieve the instance variable data from the front node.
     * @return E
     *  The instance variable data from the front node in a NodeQueue.
     * @postcondition
     *  This NodeQueue has not been modified.
     */
    @Override
    public E getData() { return data; }

    /**
     * public Node<E> getNext()
     * Accessor method to retrieve a reference to the next node.
     * @return Node<E>
     *  A reference to the node after this node (or the null reference if there is nothing after this node).
     * @postcondition
     *  This NodeQueue has not been modified.
     */
    @Override
    public NodeQueue<E> getNext() { return next; }

    /**
     * public void setData(E data)
     * Mutator method to set the instance variable data in this node.
     * @param data
     *  The data to place in this node.
     * @postcondition
     *  The instance variable data has been set to the data argument.
     */
    @Override
    public void setData(E data) { this.data = data; }

    /**
     * Mutator method to set the instance variable next to reference a new object given by the next argument.
     * @param next
     *  A reference to the next node. Note that his may be a null reference if there is nothing after this node.
     * @postcondition
     *  The instance variable next has been set to the object given by the next argument.
     */
    @Override
    public void setNext(Node<E> next) { this.next = (NodeQueue<E>) next; }
}

