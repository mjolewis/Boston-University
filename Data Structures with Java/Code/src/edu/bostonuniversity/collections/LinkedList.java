// FILE: LinkedList.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;
import edu.bostonuniversity.nodes.NodeList;

/**********************************************************************************************************************
 * A LinkedList is a sequence of generic types. The sequence can have a special "current element", which is
 * specified and accessed through four methods (start, getCurrent, advance, and isCurrent).
 *
 * @note
 *   1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *
 * @author mlewis
 * @version Nov 2, 2019
 *********************************************************************************************************************/

public class LinkedList<E> implements List<E>, Cloneable {
    // Invariant of the LinkedList class:
    //   1. The number of nodes in the sequence is stored in the instance variable size.
    //   2. The head and tail are references to the head node and tail node of the linked list. If the list has no
    //      elements, then these references are both null. The reason for the tail reference is the addAfter method.
    //      Normally, this method adds a new element immediately after the current element. But if there is no current
    //      element, the addAfter places its new element at the tail of the list.
    //   3. Cursor refers to the node with the current element (or null if there is no current element).
    //   4. Precursor refers to the node before the current element (or null if there is no current element or if the
    //      current element is the first node). The addBefore method leverages the precursor node to add a new node
    //      after the precursor (or before the current node).
    //   5. For an empty sequence (with no elements), both the head and tail links are null; for a non-empty sequence,
    //      the elements of the sequence are stored from the head to the tail.
    //   6. If there is a current element, then it lies between the head node and tail node (inclusive).
    private int size;
    private NodeList<E> prev;
    private NodeList<E> head;
    private NodeList<E> cursor;
    private NodeList<E> tail;

    /**
     * public LinkedList()
     * Initialize an empty sequence.
     * @postcondition
     *   This sequence is empty.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedList.
     */
    public LinkedList() {
        size = 0;
        prev = null;
        head = null;
        cursor = null;
        tail = null;
    }

    /**
     * public LinkedList(E data, NodeList<E> next)
     * Initialize an sequence with one node. The node contains the initial specified data and link to the next node.
     * Note that the initial next link may be a null reference, which indicates that the new node has nothing after it.
     * @param data
     *   The element that is being added.
     * @param next
     *   A reference to the next node if there is one. If there is no next node, then next can be null.
     */
    public LinkedList(E data, NodeList<E> next) {
        size++;
        prev = null;
        head = NodeList.getInstance(data, next);
        cursor = head;
        tail = this.head.getNext();
    }

    /**
     * public static <E> LinkedList<E> getInstance()
     * Activates the no arg constructor for LinkedList. Note that the addBefore and addAfter methods work
     * efficiently (without ever needing more capacity).
     * @return LinkedList
     *   A reference to the LinkedList object.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedList.
     */
    public static <E> LinkedList<E> getInstance() { return new LinkedList<>(); }

    /**
     * public static <E> LinkedList<E> getInstance(E data, NodeList<E> next)
     * Activates an initial sequence with one node. The node contains the initial specified data and link to the next
     * node. Note that the initial next link may be a null reference, which indicates that the new node has nothing
     * after it.
     * @param data
     *   The element that is being added.
     * @param next
     *   A reference to the next node if there is one. If there is no next node, then next can be null.
     * @return LinkedList
     *   A reference to the LinkedList object.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedList.
     */
    public static <E> LinkedList<E> getInstance(E data, NodeList<E> next) {
        return new LinkedList<>(data, next);
    }

    /**
     * public void addAfter(E element)
     * Adds a new element to this sequence after the current element.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to this sequence. If there was a current element, addAfter places the
     *   new element after the current element. If there was no current element, addAfter places the new element at the
     *   end of the sequence. The new element always becomes the new current element of the sequence.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new node.
     */
    @Override
    public void addAfter(E element) {
        if (isCurrent()) {
            prev = this.cursor;
            cursor.addNodeAfter(element);
            cursor = cursor.getNext(); // The new node becomes the new current element and...
        } else {
            tail.addNodeAfter(element);
            prev = tail; // The current tail will become the precursor to the new node and...
            cursor = tail.getNext(); // ...the new node becomes the new current element and...
            tail = tail.getNext(); // ...the tail becomes the last node of the sequence.
        }

        size++;
    }

    /**
     * public void addBefore(E element)
     * Add a new element to this sequence before the current element.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to this sequence. If there was a current element, addBefore places
     *   the new element before the current element. If there was no current element, addBefore places the new element
     *   at the front of the sequence. The new element always becomes the new current element of the sequence.
     */
    @Override
    public void addBefore(E element) {
        NodeList<E> newNodeList = NodeList.getInstance(element, cursor);

        if (prev == null) {
            head = newNodeList;
            cursor = newNodeList;
        } else {
            prev.setNext(newNodeList);
            cursor = newNodeList;
        }

        size++;
    }

    /**
     * public void addFirst(E element)
     * Add a new element to the front of this sequence.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to the front of this sequence. The new element becomes the new
     *   current element of the sequence.
     */
    @Override
    public void addFirst(E element) {
        NodeList<E> newNodeList = NodeList.getInstance(element, head);

        head = newNodeList;
        cursor = newNodeList;
        size++;
    }

    /**
     * public void addAll(List<E> addend)
     * Place the contents of another sequence at the end of this sequence
     * @param addend
     *   A sequence whose contents will be placed at the end of this sequence.
     * @precondition
     *   The parameter, addend, is not null.
     * @postcondition
     *   The elements from addend have been placed at the end of this sequence. The current element of this sequence
     *   remains where it was, and the addend is also unchanged.
     * @exception NullPointerException
     *   Indicates that addend is null.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory to increase the size of this sequence.
     */
    public void addAll(List<E> addend) {
        NodeList<E> current;
        LinkedList<E> tmp;

        if (addend == null) { throw new NullPointerException("addend is null."); }

        current = head;
        tmp = (LinkedList<E>) addend;
        while (current.getNext() != null) { current = current.getNext(); }
        current.setNext(tmp.head); // The tail of the activating object is linked to the head of addend and...
        tail = tmp.tail; // ... the tail of addend becomes the tail of this new sequence.
        size += addend.size();
    }

    /**
     * public void advance()
     * Move forward so that the current element is now the next element in the sequence.
     * @precondition
     *   isCurrent() returns true.
     * @postcondition
     *   If the current element was already the end element of the sequence (with nothing after it), then there is no
     *   longer any current element. Otherwise, the new element is the element immediately after the original current
     *   element.
     * @exception IllegalStateException
     *   Indicates that there is no current element, so advance may not be called.
     */
    @Override
    public void advance() {
        if (isCurrent()) {
            prev = cursor;
            cursor = cursor.getNext();
        } else {
            throw new IllegalStateException("There is no current element.");
        }
    }

    /**
     * public LinkedList<E> clone()
     * Generate a copy of this sequence. Super.clone() returns a generic object that has had its type information
     * erased at run time and generates an unchecked warning. However, this implementation suppresses that warning.
     * @return LinkedList
     *   The return value is a copy of this sequence. Subsequent changes to the copy will not affect the original, nor
     *   vice versa. The return value must be typecast to a LinkedList before it is used.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedList.
     */
    @SuppressWarnings("unchecked")
    public LinkedList<E> clone() {
        LinkedList<E> answer;
        Object[] tmp;

        try {
            answer = (LinkedList<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception should not occur. But if it does, it would probably indicate a programming error that
            // made super.clone unavailable. The most common error would be forgetting the "Implement Cloneable" clause
            // at the start of the class.
            throw new RuntimeException("This class does not implement Cloneable.");
        }

        // The clone method needs extra work before it returns. The extra work creates new Node<E> components for
        // the clone's reference variables to refer to. 1) head, 2) tail...
        tmp = NodeList.listCopyWithTail(head);
        answer.head = (NodeList<E>) tmp[0];
        answer.tail = (NodeList<E>) tmp[1];

        // ...3) precursor and 4) cursor.
        if (prev != null && cursor != null) {
            tmp = NodeList.listPart(this.prev, cursor);
            answer.prev = (NodeList<E>) tmp[0];
            answer.cursor = (NodeList<E>) tmp[1];
        }

        return answer;
    }

    /**
     * public static <E> LinkedList<E> concatenate(List<E> s1, List<E> s2)
     * Create a new sequence that contains all the elements from one sequence followed by another.
     * @param s1
     *   The first of two sequences.
     * @param s2
     *   The second of two sequences.
     * @return LinkedList
     *   A new sequence that has the elements of s1 followed by s2 (with no current element).
     * @exception IllegalArgumentException
     *   Indicates that one of the arguments is null.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new LinkedList.
     */
    public static <E> LinkedList<E> concatenate(List<E> s1, List<E> s2) {
        if (s1 == null) { throw new IllegalArgumentException("s1 is null."); }
        if (s2 == null) { throw new IllegalArgumentException("s2 is null."); }

        LinkedList<E> answer = ((LinkedList<E>) s1).clone(); // Clone the s1 sequence and...
        LinkedList<E> copyS2 = ((LinkedList<E>) s2).clone(); // ...clone the s2 sequence and...
        answer.addAll(copyS2); // ...join the two cloned sequences together.
        return answer;
    }

    /**
     * public E getCurrent()
     * Accessor method to determine the current element of the sequence
     * @precondition
     *   isCurrent() returns true.
     * @return E
     *   The current element of the sequence.
     * @exception IllegalStateException
     *   Indicates that there is no current element.
     */
    @Override
    public E getCurrent() {
        if (isCurrent()) { return cursor.getData(); }
        else { throw new IllegalStateException("There is no current element."); }
    }

    /**
     * public E getPrevious()
     * Accessor method to retrieve the head of the LinkedList.
     * @return NodeList<E>
     */
    public NodeList<E> getHead() { return head; }

    /**
     * Accessor method to determine the previous element of the sequence
     * @precondition
     *   isCurrent() returns true.
     * @return E
     *   The element before the current element of the sequence.
     * @exception IllegalStateException
     *   Indicates that there is no previous element.
     */
    @Override
    public E getPrevious() {
        if (isCurrent()) { return prev.getData(); }
        else { throw new IllegalStateException("There is no previous element."); }
    }

    /**
     * public boolean isCurrent()
     * Accessor method to determine whether this sequence has a specified current element that can be retrieved with
     * the getCurrent method
     * @return boolean
     *   true (there is a current element) or false (there is no current element at the moment).
     */
    @Override
    public boolean isCurrent() { return cursor != null; }

    /**
     * public void removeCurrent()
     * Modification method to remove the current element from this sequence.
     * @precondition
     *   isCurrent() returns true.
     * @postcondition
     *   The current element has been removed from the sequence, and the following element (if there is one) is now the
     *   new current element. If there was no following element, then there is now no current element.
     * @exception IllegalStateException
     *   Indicates that there is no current element, so removeCurrent may not be activated.
     */
    @Override
    public void removeCurrent() {
        if (!isCurrent()) { throw new IllegalStateException("There is no current element"); }

        if (prev == null) { // The current element is referenced by the head
            head = head.getNext();
            cursor = head;
        } else if (cursor.getNext() == null) { // The current element is the final element
            prev = null;
            cursor = null;
            tail = null;
        } else {
            cursor = cursor.getNext();
            prev.setNext(cursor);
        }

        size--;
    }

    /**
     * public NodeList<E> removeHead()
     * Mutator method that removes the head of the LinkedList. The next item (if there is one) becomes the new head.
     * Otherwise, head becomes a null reference.
     * @return NodeList<E>
     *   The head of the LinkedList
     * @postcondition
     *   The head of the LinkedList has been removed. The next item (if there is one) becomes the new head. Otherwise,
     *   the head becomes a null reference. The size of the LinkedList is decreased by one.
     */
    public NodeList<E> removeHead() {
        NodeList<E> answer = head;
        head = head.getNext();
        size--;
        return answer;
    }

    /**
     * public int size()
     * Accessor method to determine the number of elements in this sequence.
     * @return int
     *   The number of elements in this sequence.
     */
    @Override
    public int size() { return size; }

    /**
     * public void start()
     * Modification method to set the current element at the front of the sequence.
     * @postcondition
     *   The front element of this sequence is now the current element (but if the sequence has no elements at all,
     *   then there is no current element).
     */
    @Override
    public void start() {
        if (size > 0) {
            cursor = head;
            prev = null;
        } else {
            cursor = null; }
    }
}
