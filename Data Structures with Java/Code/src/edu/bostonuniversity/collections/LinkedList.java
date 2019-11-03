// FILE: LinkedList.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;
import edu.bostonuniversity.nodes.Node;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    private Node<E> prev;
    private Node<E> head;
    private Node<E> cursor;
    private Node<E> tail;

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
    public LinkedList(E data, Node<E> next) {
        size++;
        prev = null;
        head = new Node(data, next);
        cursor = head;
        tail = head;
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
        if (!isCurrent() && head == tail) {
            prev = null;
            head = new Node<>(element, head);
            cursor = head;
            tail = head;
        } else if (!isCurrent()) {
            prev = tail;
            tail = new Node(element, tail);
            tail.setNext(tail.getNext());
        } else if (head == tail) { // If the head and tail are the first element, then...
            prev = cursor;
            cursor = new Node(element, cursor.getNext()); // ...add the new node and...
            tail = cursor; // ...update the location of the tail otherwise...
        } else { // ...the new node is added somewhere between the head and tail.
            prev = cursor;
            cursor = new Node(element, cursor.getNext());
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
        Node<E> newNodeList = new Node<>(element, cursor);

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
        Node<E> newNodeList = new Node<>(element, head);

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
        Node<E> current;
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
        tmp = listCopyWithTail(head);
        answer.head = (Node<E>) tmp[0];
        answer.tail = (Node<E>) tmp[1];

        // ...3) precursor and 4) cursor.
        if (prev != null && cursor != null) {
            tmp = listPart(this.prev, cursor);
            answer.prev = (Node<E>) tmp[0];
            answer.cursor = (Node<E>) tmp[1];
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
     * Accessor method to return the data within the current element of the sequence.
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
     * public Node<E> getCursor()
     * Accessor to return the current element of the sequence.
     * @precondition
     *   isCurrent() returns true.
     * @return E
     *   The current element of the sequence.
     * @exception IllegalStateException
     *   Indicates that there is no current element.
     */
    public Node<E> getCursor() {
        if (isCurrent()) { return cursor; }
        else { throw new IllegalStateException("There is no current element."); }
    }

    /**
     * public Node<E> getHead()
     * Accessor method to retrieve the head of the LinkedList.
     * @return NodeList<E>
     */
    public Node<E> getHead() { return head; }

    /**
     * public E getPrevious()
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
        if (isCurrent() && prev != null) { return prev.getData(); }
        else { throw new IllegalStateException("There is no previous element."); }
    }

    /**
     * public E getTail()
     * Accessor method to determine the tail element of the sequence
     * @precondition
     *   isCurrent() returns true.
     * @return E
     *   The tail element of the sequence.
     * @exception IllegalStateException
     *   Indicates that there is no tail element.
     */
    public E getTail() {
        if (isCurrent() && tail != null) { return tail.getData(); }
        else { throw new IllegalStateException("There is no tail element."); }
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
     * Copy a linked list
     * @param source
     *   The head reference for a linked list that will be copied (which may be an empty list where source is null).
     * @return Node
     *   The method has made a copy of the linked list starting at source. The return value is the head reference for
     *   the copy.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node.
     */
    @Contract("null -> null")
    public static <E> Node<E> listCopy(Node<E> source) {
        Node<E> copyHead;
        Node<E> copyTail;

        // Handle the special case of an empty list.
        if (source == null) { return null; }

        // Make the first node for the newly created list.
        copyHead = new Node<>(source.getData(), source.getNext());
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list...
        while (source.getNext() != null) {
            source = source.getNext();
            copyTail.setNext(new Node<>(source.getData(), copyTail.getNext()));
            copyTail = copyTail.getNext();
        }

        // Return the head reference for the new list.
        return copyHead;
    }

    /**
     * Copy a list, returning both a head and a tail reference for the copy
     * @param source
     *   The head reference for a linked list that will be copied (which may be an empty list where source is null).
     * @return Node[]
     *   The method has made a copy of the linked list starting at source. The return value is an array where [0]
     *   element is a head reference for the copy and the [1] element is a tail reference for the copy.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node.
     */
    @NotNull
    public static <E> Object[] listCopyWithTail(Node<E> source) {
        Node<E> copyHead;
        Node<E> copyTail;
        Object[] answer = new Object[2];

        // Handle the special case of an empty list.
        if (source == null) { return answer; }

        // Make the first node for the newly created list.
        copyHead = new Node<>(source.getData(), source.getNext());
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list...
        while (source.getNext() != null) {
            source = source.getNext();
            copyTail.setNext(new Node<>(source.getData(), copyTail.getNext()));
            copyTail = copyTail.getNext();
        }

        // ...Return the head and tail references for the new list. The [0] component is the head and the [1] component
        // is the tail.
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }

    /**
     * Compute the number of nodes in a linked list
     * @param head
     *   The head reference for a linked list (which may be an empty list with a null head)
     * @return int
     *   The number of nodes in the list with the given head
     * @note
     *   A wrong answer occurs for lists longer than Integer.MAX_VALUE due to arithmetic overflow.
     */
    @Contract(pure = true)
    public static <E> int listLength(Node<E> head) {
        Node<E> cursor;
        int answer;

        answer = 0;
        for (cursor = head; cursor != null; cursor = cursor.getNext()) { answer++; }
        return answer;
    }

    /**
     * Copy part of a list, providing a head and tail reference for the new copy.
     * @param start
     *   A reference to the start node of a linked list
     * @param end
     *   A reference to the end node of a linked list
     * @precondition
     *   Start and end are non-null references to nodes on the same linked list, with the start node at or before the
     *   end node.
     * @return Node[]
     *   The method has made a copy of part of a linked list, from the specified start node to the specified end node.
     *   The return value is an array where the [0] component is a head reference for the copy and the [1] component is
     *   a tail reference for the copy.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for a new Node.
     * @exception IllegalArgumentException
     *   Indicates that start and end do not satisfy the precondition.
     */
    @NotNull
    @Contract("null, _ -> fail; !null, null -> fail")
    public static <E> Object[] listPart(Node<E> start, Node<E> end) {
        Node<E> copyHead;
        Node<E> copyTail;
        Object[] answer = new Object[2];

        // Check for illegal null at start or end.
        if (start == null) { throw new IllegalArgumentException("Start is null."); }
        if (end == null) { throw new IllegalArgumentException("End is null."); }

        // Make the first node for the newly created list.
        copyHead = new Node<>(start.getData(), start.getNext());
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list...
        while (start != end) {
            start = start.getNext();
            if (start == null) { throw new IllegalArgumentException("End node was not found on the list."); }
            copyTail.setNext(new Node<>(start.getData(), copyTail.getNext()));
            copyTail = copyTail.getNext();
        }

        // ...Return the head and tail references for the new list. The [0] component is the head and the [1] component
        // is the tail.
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }

    /**
     * Find a node at a specified position in a linked list.
     * @param head
     *   The head reference for a linked list (which may be an empty list with a null head)
     * @param position
     *   A node number
     * @return Node
     *   The return value is a reference to the node at the specified position in the list. (The head node is position
     *   1, the next node is position 2, and so on). If there is no such position (because the list is too short), then
     *   null reference is returned.
     * @exception IllegalArgumentException
     *   Indicates a position is less than or equal to 0
     */
    @Contract(pure = true)
    public static <E> Node<E> listPosition(Node<E> head, int position) {
        Node<E> cursor;
        int i;

        if (position <= 0) { throw new IllegalArgumentException("The position must be greater than 0."); }

        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++) {
            cursor = cursor.getNext();
        }
        return cursor;
    }

    /**
     * Search for a particular piece of data in a linked list.
     * @param head
     *   The head reference for a linked list (which may be an empty list with a null head).
     * @param target
     *   A piece of data to search for.
     * @return Node
     *   The return is a reference to the first node that contains the specified target. If there is no such node, the
     *   null reference is returned.
     */
    @Nullable
    @Contract(pure = true)
    public static <E> Node<E> listSearch(Node<E> head, E target) {
        Node<E> cursor;

        if (target == null) { // Search for a node in which the data is a null reference.
            for (cursor = head; cursor != null; cursor = cursor.getNext()) {
                if (cursor.getData() == null) {
                    return cursor;
                }
            }
        } else { // Search for a node that contains the non-null target.
            for (cursor = head; cursor != null; cursor = cursor.getNext()) {
                if (target.equals(cursor.getData())) {
                    return cursor;
                }
            }
        }

        return null;
    }

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
    public Node<E> removeHead() {
        Node<E> answer = head;
        head = head.getNext();
        size--;
        return answer;
    }

    /**
     * Modification method to remove the node after this node.
     * @precondition
     *   This node must not be the tail node of the list.
     * @postcondition
     *   The node after this node has been removed from the linked list. If there were further nodes after that one,
     *   they are still present on the list and the node previous to this node is now linked to the node after this
     *   node.
     * @exception NullPointerException
     *   Indicates that this was the tail node of the list, so there is nothing after it to remove.
     */
    public void removeNodeAfter() { cursor = cursor.getNext().getNext(); }

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
