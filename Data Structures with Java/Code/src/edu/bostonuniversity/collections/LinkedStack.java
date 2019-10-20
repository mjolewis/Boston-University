// FILE: LinkedStack.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;
import edu.bostonuniversity.nodes.NodeList;

/**********************************************************************************************************************
 * A LinkedStack is a sequence of generic types. The LinkedStack can have a special "current element", which is
 * specified and accessed through four methods (start, getCurrent, advance, and isCurrent).
 *
 * @note
 *   1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *
 * @author mlewis
 * @version Oct 6, 2019
 *********************************************************************************************************************/

public class LinkedStack<E> implements Cloneable {
    // Invariant of the LinkedStack class.
    //  1. The instance variable top is the head reference of the LinkedStack.
    //  2. The instance variable size is the number of objects in the LinkedStack.
    //  3. For the final node in the LinkedStack, the next reference is null. Otherwise, the next reference is a
    //     reference to the next node.
    //  4. The elements in the LinkedStack can only be retrieved from the top. As such, this is aLast-In-First-Out data
    //     structure. To access an item other than the first item, you must first remove every node that sits on top of
    //     the target item in the LinkedStack.
    private int size;
    private NodeList<E> top;

    /**
     * Initialize an empty LinkedStack.
     * @postcondition
     *   This LinkedStack is empty.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedStack.
     */
    public LinkedStack() {
        size = 0;
        top = null;
    }

    /**
     * Initialize an LinkedStack with one node. The node contains the initial specified data and link to the next node.
     * Note that the initial next link may be a null reference, which indicates that the new node has nothing after it.
     * @param data
     *   The element that is being added.
     * @param next
     *   A reference to the next node if there is one. If there is no next node, then next can be null.
     */
    public LinkedStack(E data, NodeList<E> next) {
        size++;
        top = NodeList.getInstance(data, next);
    }

    /**
     * Add a new element to the front of this LinkedStack.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to the front of this LinkedStack. The new element becomes the new
     *   top.
     */
    public void add(E element) {
        top = NodeList.getInstance(element, top);
        size++;
    }

    /**
     * Generate a copy of this LinkedStack. Super.clone() returns a generic object that has had its type information
     * erased at run time and generates an unchecked warning. However, this implementation suppresses that warning.
     * @return LinkedStack
     *   The return value is a copy of this LinkedStack. Subsequent changes to the copy will not affect the original,
     *   nor vice versa.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedStack.
     */
    @SuppressWarnings("unchecked")
    public NodeList<E> clone() {
        NodeList<E> answer;

        try {
            answer = (NodeList<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception should not occur. But if it does, it would probably indicate a programming error that
            // made super.clone unavailable. The most common error would be forgetting the "Implement Cloneable" clause
            // at the start of the class.
            throw new RuntimeException("This class does not implement Cloneable.");
        }

        // The clone method needs extra work before it returns. The extra work creates new Node<E> components for
        // the clone's reference variables to refer to. 1) head, 2) tail...
        answer = (NodeList<E>) NodeList.listCopy(top);

        return answer;
    }

    /**
     * Accessor method to retrieve the head of the LinkedStack.
     * @return NodeList<E>
     */
    public NodeList<E> getHead() { return top; }

    /**
     * Accessor method to determine the number of elements in this LinkedStack.
     * @return int
     *   The number of elements in this LinkedStack.
     */
    public int getSize() { return size; }

    /**
     * Accessor method to determine if the LinkedStack is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Mutator method that removes all the nodes from the LinkedStack.
     * @postcondition
     *   LinkedStack is empty.
     */
    public void removeAll() {
        top = null;
        size = 0;
    }

    /**
     * Mutator method that removes the head of the LinkedStack. The next item (if there is one) becomes the new head.
     * Otherwise, head becomes a null reference.
     * @return NodeList<E>
     *   The head of the LinkedStack
     * @postcondition
     *   The head of the LinkedStack has been removed. The next item (if there is one) becomes the new head. Otherwise,
     *   the head becomes a null reference. The size of the LinkedStack is decreased by one.
     */
    public NodeList<E> removeHead() {
        NodeList<E> answer = top;
        top = top.getNext();
        size--;
        return answer;
    }
}
