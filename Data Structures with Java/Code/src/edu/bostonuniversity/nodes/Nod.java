// FILE Node.java in the package edu.bostonuniversity.nodes

package edu.bostonuniversity.nodes;

/**********************************************************************************************************************
 * A generic Node is an object that contains data and a connection to any subsequent element through a reference link.
 *
 * @note
 *   (1) Nodes can be dynamically created or destroyed (not subject to static memory allocation like arrays). However,
 *   they are limited only by the amount of free memory on the heap and beyond Integer.MAX_VALUE, the answer from any
 *   size operation is incorrect.
 *
 * @author mlewis
 * @version Nov 2, 2019
 *
 *********************************************************************************************************************/

public class Nod<E> {
    // Invariant of the Node class:
    //   1. The node's generic data type is in the instance variable data.
    //   2. For the final node of a list, the link part is null. Otherwise, the link part is a reference to the next
    //      node of the list.
    private E data;
    private Nod<E> next;

    /**
     * public Node()
     * Initializes an empty node. Note that the initial next is a null reference, which indicates that the new node has
     * nothing after it.
     * @postcondition
     *   This new node is an empty node with a null reference as its link.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node.
     */
    public Nod() {
        data = null;
        next = null;
    }

    /**
     * public Node(E data, Node<E> next)
     * Initializes a node with the specified initial data and a link to the next node. Note that the initial next may
     * be a null reference, which indicates that the new node has nothing after it.
     * @param data
     *  The initial data of this new node.
     * @param next
     *  A reference to the node after this new node (this reference may be null to indicate that there is no node
     *  after this new node).
     * @postcondition
     *  This new node contains the specified data and a link to the next node.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the new Node.
     */
    public Nod(E data, Nod<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * public E getData()
     * Accessor method to get the data from this node.
     * @return data
     *   The data from this node.
     */
    public E getData() {
        return data;
    }

    /**
     * public Node<E> getNext()
     * Accessor method to get a reference to the next node after this node.
     * @return next
     *  A reference to the node after this node (or the null reference if there is nothing after this node).
     */
    public Nod<E> getNext() {
        return next;
    }

    /**
     * public void setData(E data)
     * Mutator method to set the data in this node.
     * @param data
     *  The new data to place in this node.
     * @postcondition
     *  The data of this node has been set to data
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * public void setNext(Node<E> next)
     * Mutator method to set a reference to the next node after this node.
     * @param next
     *  A reference to the node that should appear after this node in the linked list (or the null reference if there
     *  should be no node after this node).
     * @postcondition
     *  The link to the node after this node has been set to next. Any other node (that used to be in this link) is no
     *  longer connected to this node.
     */
    public void setNext(Nod<E> next) {
        this.next = next;
    }
}
