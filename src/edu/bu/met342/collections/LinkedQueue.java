//FILE LinkedQueue.java from the package edu.bostonuniversity.collections

package edu.bu.met342.collections;
import edu.bu.met342.nodes.Node;

/**********************************************************************************************************************
 * A LinkedQueue is a First-in/First-out data structure of ordered items such that items can be inserted at one end
 * (called the rear) and removed from the other end (called the front). The item at the front of the Queue is called
 * the first item.
 *
 * @note
 *   1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *
 * @author mlewis
 * @version Nov 1, 2019
 *********************************************************************************************************************/

public class LinkedQueue<E> implements Queue<E> {
    // Invariant of the LinkedQueue class.
    // 1. The instance variable front is a reference to the first item in this LinkedQueue.
    // 2. The instance variable rear is a reference to the last item in this LinkedQueue.
    // 3. The instance variable size is a count of the number of items in this LinkedQueue.
    // 4. This LinkedQueue is a first-in/first-out data structure, so items are added at the rear and removed at the
    //    front.
    private Node<E> front;
    private Node<E> rear;
    private int size;

    /**
     * public LinkedQueue()
     * Initialize an empty LinkedQueue.
     * @postcondition
     *  This LinkedQueue is empty.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this LinkedQueue.
     */
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * public void add(E item)
     * Mutator method that adds a new item to the rear of the Queue. The new item may be a null reference. Note that
     * the object being removed has had its type erased; however, we have ensured that the returned object is of type
     * E. Therefore, we suppress the compile time warning.
     * @param item
     *  The item to be added to the Queue.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this item.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void add(Object item) {
        E element = (E) item;
        if (isEmpty()) {
            front = new Node<>(element, front);
            rear = front;
        } else {
            rear.setNext(new Node<>(element, rear));
            rear = rear.getNext();
        }
        size++;
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

    /**
     * public Node<E> getFront()
     * Accessor method to retrieve the front node from this Queue.
     * @return Node<E>
     *  The front node from this Queue.
     * @postcondition
     *  This Queue has not been modified.
     */
    public Node<E> getFront() { return front; }

    /**
     * public Node<E> getRear()
     * Accessor method to retrieve the rear node from this Queue.
     * @return Node<E>
     *  The rear node from this Queue.
     * @postcondition
     *  This Queue has not been modified.
     */
    public Node<E> getRear() { return rear; }

    /**
     * public E remove()
     * Mutator method that removes the front item from this Queue. Note that the object being removed has had its type
     * erased; however, we have ensured that the returned object is of type E. Therefore, we suppress the compile time
     * warning.
     * @precondition
     *  This Queue is not empty.
     * @return E
     *  The front item from this Queue.
     * @postcondition
     *  The front item from this Queue has been removed and the next item (if there is one) is now the front item. Size
     *  has been decreased by one.
     */
    @Override
    @SuppressWarnings("unchecked")
    public E remove() {
        Node<E> answer;
        if (isEmpty()) { return null; }
        answer = front;
        front = front.getNext();
        size--;
        return answer.getData();
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
