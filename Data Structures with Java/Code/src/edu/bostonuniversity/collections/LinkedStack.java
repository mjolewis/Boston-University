// FILE: LinkedStack.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;
import edu.bostonuniversity.nodes.Node;
import org.jetbrains.annotations.Contract;

/**********************************************************************************************************************
 * A LinkedStack is a sequence of nodes. The LinkedStack is a first-in/last-out data structure meaning that items are
 * added to the top of the stack and only removed when every item on top of it has been removed.
 *
 * @note
 *   1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *
 * @author mlewis
 * @version Nov 2, 2019
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
    private Node<E> top;

    /**
     * public LinkedStack()
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
     * public LinkedStack(E data, Node<E> next)
     * Initialize an LinkedStack with one node. The node contains the initial specified data and link to the next node.
     * Note that the initial next link may be a null reference, which indicates that the new node has nothing after it.
     * @note
     *  Suppressing compile time warnings because the program ensures that the new Node is of type Node<E>.
     * @param data
     *   The element that is being added.
     * @param next
     *   A reference to the next node if there is one. If there is no next node, then next can be null.
     */
    @SuppressWarnings("unchecked")
    public LinkedStack(E data, Node<E> next) {
        size++;
        top = new Node(data, next);
    }

    /**
     * public void add(E element)
     * Add a new element to the front of this LinkedStack.
     * @note
     *  Suppressing compile time warnings because the program ensures that the new Node is of type Node<E>.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to the front of this LinkedStack. The new element becomes the new
     *   top.
     */
    @SuppressWarnings("unchecked")
    public void add(E element) {
        top = new Node(element, top);
        size++;
    }

    /**
     * public Node<E> clone()
     * Generate a copy of this LinkedStack. Super.clone() returns a generic object that has had its type information
     * erased at run time and generates an unchecked warning. However, this implementation suppresses that warning.
     * @return LinkedStack<E>
     *   The return value is a copy of this LinkedStack. Subsequent changes to the copy will not affect the original,
     *   nor vice versa.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedStack.
     */
    @SuppressWarnings("unchecked")
    public LinkedStack<E> clone() {
        LinkedStack<E> answer;

        try {
            answer = (LinkedStack<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception should not occur. But if it does, it would probably indicate a programming error that
            // made super.clone unavailable. The most common error would be forgetting the "Implement Cloneable" clause
            // at the start of the class.
            throw new RuntimeException("This class does not implement Cloneable.");
        }

        answer.top = new Node<>();
        return answer;
    }

    /**
     * Compare this Stack to another Stack for equality.
     * @param obj
     *  An object with which this Node is being compared.
     * @return boolean
     *  A return value of true indicates that obj refers to an object with the same data as this Stack. Otherwise, the
     *  return value is false.
     */
    @Contract(value = "null -> false", pure = true)
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node<E> candidate = (Node<E>) obj;
            return (top.getData() == candidate.getData());
        }
        return false;
    }

    /**
     * public Node<E> getTop()
     * Accessor method to retrieve the top of the Stack.
     * @return Node<E>
     */
    public Node<E> getTop() {
        if (size == 0) { return null; }
        return top;
    }

    /**
     * public int getSize()
     * Accessor method to determine the number of elements in this Stack.
     * @return int
     *   The number of elements in this Stack.
     */
    public int getSize() { return size; }

    /**
     * public boolean isEmpty()
     * Accessor method to determine if the Stack is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * public E peek()
     * Accessor method to look at the object on the top of the Stack.
     * @return E
     *   The top object on the Stack if there is one, otherwise returns null.
     * @postcondition
     *   The Stack is not modified and the object on the top of the Stack remains on the top of the Stack.
     */
    public E peek() {
        if (getSize() == 0) { return null; }
        return top.getData();
    }

    /**
     * public E pop()
     * Mutator method that retrieves the top object from the Stack. The next object (if there is one) is now at the top
     * of the Stack.
     * @return E
     *   The top object from the Stack.
     * @postcondition
     *   The top object was removed from the Stack and the next object (if there is one) is now at the top of the
     *   Stack. The size of the Stack has decreased by one.
     */
    public E pop() {
        E answer;
        if (size == 0) { return null; }
        answer = top.getData();
        top = top.getNext();
        size--;
        return answer;
    }

    /**
     * public E push(E item)
     * Mutator method that pushes a new node to the top of the Stack.
     * @note
     *  Suppressing compile time warnings because the program ensures that the new Node is of type Node<E>.
     * @param item
     *   The item being pushed onto the Stack.
     * @return E
     *   The item being pushed onto the Stack.
     * @postcondition
     *   The item is now on the top of the Stack and the size of the Stack has increased by one.
     */
    @SuppressWarnings("unchecked")
    public E push(E item) {
        top = new Node(item, top);
        size++;
        return item;
    }

    /**
     * public void removeAll()
     * Mutator method that removes all the nodes from the Stack.
     * @postcondition
     *   Stack is empty.
     */
    public void removeAll() {
        top = null;
        size = 0;
    }

    /**
     * Accessor method that returns the 1-based position of an object on the Stack (if the object is on the Stack). If
     * the object is not on the Stack, the method returns -1.
     * @param obj
     *   The item to search for on the stack.
     * @return int
     *   The 1-based position of the item on the Stack. Otherwise, if the item is not on the Stack, -1 is returned.
     * @postcondition
     *   The Stack remains unchanged.
     */
    public int search(Object obj) {
        int count;
        Node<E> cursor;

        cursor = top;
        for (count = 1; cursor != null; cursor = cursor.getNext()) {
            if (cursor.getData().equals(obj)) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
