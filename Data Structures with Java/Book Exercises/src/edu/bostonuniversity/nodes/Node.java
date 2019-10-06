// FILE: Node.java from the package edu.bostonuniversity.nodes
// This is a programming project from chapter 4 of "Data Structures and Other Objects Using Java" by Michael Main.

package edu.bostonuniversity.nodes;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**********************************************************************************************************************
 * A generic Node that provides a node for a linked list with a generic type parameter in each node.
 *
 * @note
 *   (1) Lists can be of any length, limited only by the amount of free memory on the heap. But beyond
 *   Integer.MAX_VALUE, the answer from listLength is incorrect because of arithmetic overflow.
 *
 * @author mlewis
 * @version Oct 6, 2019
 *
 *********************************************************************************************************************/

public class Node<E> {
    // Invariant of the Node class:
    //   1. The node's generic data type is in the instance variable data.
    //   2. For the final node of a list, the link part is null. Otherwise, the link part is a reference to the next
    //      node of the list.
    private E data;
    private Node<E> next;

    /**
     * Initializes an empty node. Note that the initial next is a null reference, which indicates that the new node has
     * nothing after it.
     * @postcondition
     *   This new node is an empty node with a null reference as its link.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node
     */
    @Contract(pure = true)
    private Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * Initializes a node with the specified initial data and a link to the next node. Note that the initial next may
     * be a null reference, which indicates that the new node has nothing after it.
     * @param data
     *   The initial data of this new node.
     * @param next
     *   A reference to the node after this new node (this reference may be null to indicate that there is no node
     *   after this new node).
     * @postcondition
     *   This new node contains the specified data and a link to the next node.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node.
     */
    @Contract(pure = true)
    private Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Activates the no arg constructor for Node. Note that the initial next is a null reference, which indicates
     * that the new node has nothing after it.
     * @postcondition
     *   This new node is an empty node with a null reference as its link
     * @return Node
     *   A reference to a new Node object. Initial link is null.
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node.
     */
    @NotNull
    @Contract(value = " -> new", pure = true)
    public static <E> Node<E> getInstance() { return new Node<>(); }

    /**
     * Activates the overloaded constructor for Node. Note that the initial next may be a null reference, which
     * indicates that the new node has nothing after it.
     * @param data
     *   The initial data of this new node.
     * @param next
     *   A reference to the node after this new node (this reference may be null to indicate that there is no node
     *   after this new node).
     * @return Node
     *   A reference to a new Node object with the specified initial data and initial link (next)
     * @exception OutOfMemoryError
     *   Indicates insufficient memory for the new Node.
     */
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    public static <E> Node<E> getInstance(E data, Node<E> next) { return new Node<E>(data, next); }

    /**
     * Modification method to add a new node after this node.
     * @param element
     *   The data to be placed in the new node.
     * @postcondition
     *   A new node has been created and placed after this node. The data for the new node is element. Any other nodes
     *   that used to be after this node are now after the new node.
     * @exception OutOfMemoryError
     *   Indicates that there is insufficient memory for a new Node.
     */
    public void addNodeAfter(E element) {
        next = new Node<>(element, next);
    }

    /**
     * Accessor method to get the data from this node.
     * @return data
     *   The data from this node.
     */
    public E getData() { return data; }

    /**
     * Accessor method to get a reference to the next node after this node.
     * @return next
     *   A reference to the node after this node (or the null reference if there is nothing after this node).
     */
    @SuppressWarnings("unchecked")
    public E getNext() { return (E) next; }

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
        copyHead = getInstance(source.data, null);
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list...
        while (source.next != null) {
            source = source.next;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.next;
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
        copyHead = getInstance(source.data, null);
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list...
        while (source.next != null) {
            source = source.next;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.next;
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
     * @return double
     *   The number of nodes in the list with the given head
     * @note
     *   A wrong answer occurs for lists longer than Integer.MAX_VALUE due to arithmetic overflow.
     */
    @Contract(pure = true)
    public static <E> int listLength(Node<E> head) {
        Node<E> cursor;
        int answer;

        answer = 0;
        for (cursor = head; cursor != null; cursor = cursor.next) { answer++; }
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
        copyHead = getInstance(start.data, null);
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list...
        while (start != end) {
            start = start.next;
            if (start == null) { throw new IllegalArgumentException("End node was not found on the list."); }
            copyTail.addNodeAfter(start.data);
            copyTail = copyTail.next;
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
            cursor = cursor.next;
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

        for (cursor = head; cursor != null; cursor = cursor.next) {
            if (cursor.data.equals(target)) { return cursor; }
        }

        return null;
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
    public void removeNodeAfter() { next = next.next; }

    /**
     * Modification method to set the data in this node.
     * @param data
     *   The new data to place in this node.
     * @postcondition
     *   The data of this node has been set to data
     */
    public void setData(E data) { this.data = data; }

    /**
     * Modification method to set a reference to the next node after this node.
     * @param next
     *   A reference to the node that should appear after this node in the linked list (or the null reference if there
     *   should be no node after this node).
     * @postcondition
     *   The link to the node after this node has been set to next. Any other node (that used to be in this link) is no
     *   longer connected to this node.
     */
    public void setNext(Node<E> next) { this.next = next; }
}