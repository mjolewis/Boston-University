// FILE: Stack.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;
import edu.bostonuniversity.nodes.NodeList;
import org.jetbrains.annotations.Contract;

/**********************************************************************************************************************
 * A generic Stack is a Stack of references to E objects.
 *
 * @note
 *   (1) Stacks can be of any length, limited only by the amount of free memory on the heap. But beyond
 *   Integer.MAX_VALUE, the answer from size is incorrect because of arithmetic overflow.
 *
 * @author mlewis
 * @version Oct 9, 2019
 *
 *********************************************************************************************************************/

public class Stack<E> extends LinkedStack<E> {
    // Invariant of the Stack class.
    //  1. The instance variable top is the head reference in the Stack.
    //  2. For the final node in the Stack, the next reference is null. Otherwise, the next reference is a reference
    //     to the next node.
    //  3. The Stack is a Last-In-First-Out data structure. To access an item other than the first item, you must first
    //     remove every node that sits on top of the target item in the Stack.
    //  4. The instance variable size is the number of objects in the Stack.

    /**
     * Initialize an empty Stack.
     * @postcondition
     *   This Stack is empty.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Stack.
     */
    public Stack() { clear(); }

    /**
     * Mutator method to remove all objects from the Stack.
     * @return boolean
     *   Returns true if the Stack was emptied. Otherwise returns false.
     * @postcondition
     *   The Stack is now empty and every object (if there were any) are now available for garbage collection.
     */
    public boolean clear() {
        this.removeAll();
        return (this.getSize() == 0);
    }

    /**
     * Compare this Node to another object for equality
     * @param obj
     *  An object with which this Node is being compared.
     * @return boolean
     *  A return value of true indicates that obj refers to a Node object with the same value as this Node. Otherwise,
     *  the return value is false.
     */
    @Contract(value = "null -> false", pure = true)
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // TODO: 10/9/19  
        if (obj instanceof NodeList) {
            NodeList<E> candidate = (NodeList<E>) obj;
            return (this.getHead().getData() == candidate.getData());
        }
        return false;
    }

    /**
     * Accessor method to determine if the Stack is empty.
     * @return boolean
     *   Returns true if the Stack is empty. Otherwise returns false.
     */
    public boolean isEmpty() { return this.getSize() == 0; }

    /**
     * Accessor method to look at the object on the top of the Stack.
     * @return E
     *   The top object on the Stack if there is one, otherwise returns null.
     * @postcondition
     *   The Stack is not modified and the object on the top of the Stack remains on the top of the Stack.
     */
    public E peek() {
        if (this.getSize() == 0) { return null; }
        return this.getHead().getData();
    }

    /**
     * Mutator method that retrieves the top object from the Stack. The next object (if there is one) is now at the top
     * of the Stack.
     * @return E
     *   The top object from the Stack.
     * @postcondition
     *   The top object was removed from the Stack and the next object (if there is one) is now at the top of the
     *   Stack. The size of the Stack has decreased by one.
     */
    public E pop() {
        NodeList<E> answer;

        if (this.getSize() == 0) { return null; }
        answer = this.removeHead();
        return answer.getData();
    }

    /**
     * Mutator method that adds a new object to the top of the Stack.
     * @param item
     *   The item being pushed onto the Stack.
     * @return E
     *   The item being pushed onto the Stack.
     * @postcondition
     *   The item is now on the top of the Stack and the size of the Stack has increased by one.
     */
    public E push(E item) {
        this.add(item);
        return item;
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
        NodeList<E> current;

        current = this.getHead();
        for (count = 1; current != null; current = current.getNext()) {
            if (current.getData().equals(obj)) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
