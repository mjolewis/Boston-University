package edu.bostonuniversity.collections;
import edu.bostonuniversity.nodes.DoubleNode;

// FILE: DoubleLinkedSeq.java from the package edu.bostonuniversity.collections

// This is a programming project from chapter 4 of "Data Structures and Other Objects Using Java" by Michael Main.

/**********************************************************************************************************************
 * A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a special "current element", which is
 * specified and accessed through four methods (start, getCurrent, advance, and isCurrent).
 *
 * @note
 *   1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *
 * @author mlewis
 * @version Oct 6, 2019
 *********************************************************************************************************************/

public class DoubleLinkedSeq implements Cloneable {
    // Invariant of the DoubleLinkedSeq class:
    //   1. The number of nodes in the sequence sequence is stored in the instance variable manyNodes.
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
    private DoubleNode prev;
    private DoubleNode head;
    private DoubleNode cursor;
    private DoubleNode tail;

    /**
     * Initialize an empty sequence.
     * @postcondition
     *   This sequence is empty.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new DoubleLinkedSeq.
     */
    private DoubleLinkedSeq() {
        this.size = 0;
        this.prev = null;
        this.head = null;
        this.cursor = null;
        this.tail = null;
    }

    /**
     * Initialize an sequence with one node. The node contains the initial specified data and link to the next node.
     * Note that the initial next link may be a null reference, which indicates that the new node has nothing after it.
     * @param data
     *   The element that is being added.
     * @param next
     *   A reference to the next node if there is one. If there is no next node, then next can be null.
     */
    private DoubleLinkedSeq(double data, DoubleNode next) {
        this.size++;
        this.prev = null;
        this.head = DoubleNode.getInstance(data, next);
        this.cursor = head;
        this.tail = this.head.getNext();
    }

    /**
     * Activates the no arg constructor for DoubleLinkedSeq. Note that the addBefore and addAfter methods work
     * efficiently (without ever needing more capacity).
     * @return DoubleLinkedSeq
     *   A reference to the DoubleLinkedSeq object.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new DoubleLinkedSeq.
     */
    public static DoubleLinkedSeq getInstance() { return new DoubleLinkedSeq(); }

    /**
     * Activates an initial sequence with one node. The node contains the initial specified data and link to the next
     * node. Note that the initial next link may be a null reference, which indicates that the new node has nothing
     * after it.
     * @param data
     *   The element that is being added.
     * @param next
     *   A reference to the next node if there is one. If there is no next node, then next can be null.
     * @return DoubleLinkedSeq
     *   A reference to the DoubleLinkedSeq object.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new DoubleLinkedSeq.
     */
    public static DoubleLinkedSeq getInstance(double data, DoubleNode next) {
        return new DoubleLinkedSeq(data, next);
    }

    /**
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
    public void addAfter(double element) {
        if (this.isCurrent()) {
            this.cursor.addNodeAfter(element);
            this.cursor = this.cursor.getNext(); // The new node becomes the new current element and...
            if (this.size == 1) { this.prev = this.head; } // ...the precursor is moved up one position
            else {
                this.prev = this.prev.getNext(); }
        } else {
            this.tail.addNodeAfter(element);
            this.prev = this.tail; // The current tail will become the precursor to the new node and...
            this.cursor = this.tail.getNext(); // ...the new node becomes the new current element and...
            this.tail = this.tail.getNext(); // ...the tail becomes the last node of the sequence.
        }

        this.size++;
    }

    /**
     * Add a new element to this sequence before the current element.
     * @param element
     *   The new element that is being added.
     * @postcondition
     *   A new copy of the element has been added to this sequence. If there was a current element, addBefore places
     *   the new element before the current element. If there was no current element, addBefore places the new element
     *   at the front of the sequence. The new element always becomes the new current element of the sequence.
     */
    public void addBefore(double element) {
        DoubleNode newNode = DoubleNode.getInstance(element, this.cursor);

        if (this.prev == null) {
            this.head = newNode;
            this.cursor = newNode;
        } else {
            this.prev.setNext(newNode);
            this.cursor = newNode;
        }

        this.size++;
    }

    /**
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
    public void addAll(DoubleLinkedSeq addend) {
        DoubleNode current;

        if (addend == null) { throw new NullPointerException("addend is null."); }

        current = this.head;
        while (current.getNext() != null) { current = current.getNext(); }
        current.setNext(addend.head); // The tail of the activating object is linked to the head of addend and...
        this.tail = addend.tail; // ... the tail of addend becomes the tail of this new sequence.
        this.size += addend.size();
    }

    /**
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
    public void advance() {
        if (this.isCurrent()) {
            this.prev = this.cursor;
            this.cursor = this.cursor.getNext();
        } else {
            throw new IllegalStateException("There is no current element.");
        }
    }

    /**
     * Generate a copy of this sequence.
     * @return DoubleLinkedSeq
     *   The return value is a copy of this sequence. Subsequent changes to the copy will not affect the original, nor
     *   vice versa. The return value must be typecast to a DoubleLinkedSeq before it is used.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new DoubleLinkedSeq.
     */
    @Override
    public DoubleLinkedSeq clone() {
        DoubleLinkedSeq answer;
        DoubleNode[] tmp;

        try {
            answer = (DoubleLinkedSeq) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception should not occur. But if it does, it would probably indicate a programming error that
            // made super.clone unavailable. The most common error would be forgetting the "Implement Cloneable" clause
            // at the start of the class.
            throw new RuntimeException("This class does not implement Cloneable.");
        }

        // The clone method needs extra work before it returns. The extra work creates new DoubleNode components for
        // the clone's reference variables to refer to. 1) head, 2) tail...
        tmp = DoubleNode.listCopyWithTail(this.head);
        answer.head = tmp[0];
        answer.tail = tmp[1];

        // ...3) precursor and 4) cursor.
        if (this.prev != null && this.cursor != null) {
            tmp = DoubleNode.listPart(this.prev, this.cursor);
            answer.prev = tmp[0];
            answer.cursor = tmp[1];
        }

        return answer;
    }

    /**
     * Create a new sequence that contains all the elements from one sequence followed by another.
     * @param s1
     *   The first of two sequences.
     * @param s2
     *   The second of two sequences.
     * @return DoubleLinkedSeq
     *   A new sequence that has the elements of s1 followed by s2 (with no current element).
     * @exception IllegalArgumentException
     *   Indicates that one of the arguments is null.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new DoubleLinkedSeq.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2) {
        if (s1 == null) { throw new IllegalArgumentException("s1 is null."); }
        if (s2 == null) { throw new IllegalArgumentException("s2 is null."); }

        DoubleLinkedSeq answer = s1.clone(); // Clone the s1 sequence and...
        DoubleLinkedSeq copyS2 = s2.clone(); // ...clone the s2 sequence and...
        answer.addAll(copyS2); // ...join the two cloned sequences together.
        return answer;
    }

    /**
     * Accessor method to determine the current element of the sequence
     * @precondition
     *   isCurrent() returns true.
     * @return double
     *   The current element of the sequence.
     * @exception IllegalStateException
     *   Indicates that there is no current element.
     */
    public double getCurrent() {
        if (this.isCurrent()) { return this.cursor.getData(); }
        else { throw new IllegalStateException("There is no current element."); }
    }

    /**
     * Accessor method to determine whether this sequence has a specified current element that can be retrieved with
     * the getCurrent method
     * @return boolean
     *   true (there is a current element) or false (there is no current element at the moment).
     */
    public boolean isCurrent() { return this.cursor != null; }

    /**
     * Modification method to remove the current element from this sequence.
     * @precondition
     *   isCurrent() returns true.
     * @postcondition
     *   The current element has been removed from the sequence, and the following element (if there is one) is now the
     *   new current element. If there was no following element, then there is now no current element.
     * @exception IllegalStateException
     *   Indicates that there is no current element, so removeCurrent may not be activated.
     */
    public void removeCurrent() {
        if (!this.isCurrent()) { throw new IllegalStateException("There is no current element"); }

        if (this.prev == null) { // The current element is referenced by the head
            this.head = this.head.getNext();
            this.cursor = this.head;
        } else if (this.cursor.getNext() == null) { // The current element is the final element
            this.prev = null;
            this.cursor = null;
            this.tail = null;
        } else {
            this.cursor = this.cursor.getNext();
            this.prev.setNext(this.cursor);
        }

        this.size--;
    }

    /**
     * Accessor method to determine the number of elements in this sequence.
     * @return int
     *   The number of elements in this sequence.
     */
    public int size() { return this.size; }

    /**
     * Modification method to set the current element at the front of the sequence.
     * @postcondition
     *   The front element of this sequence is now the current element (but if the sequence has no elements at all,
     *   then there is no current element).
     */
    public void start() {
        if (this.size > 0) {
            this.cursor = this.head;
            this.prev = null;
        } else {
            this.cursor = null; }
    }
}
