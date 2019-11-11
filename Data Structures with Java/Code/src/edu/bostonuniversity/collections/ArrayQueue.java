// File ArrayQueue.java from the package edu.bostonuniversity.collections

package edu.bostonuniversity.collections;

/**********************************************************************************************************************
 * An ArrayQueue is a First-in/First-out data structure of ordered items such that items can be inserted at one end
 * (called the rear) and removed from the other end (called the front).
 *
 * @note
 *  1. Beyond Integer.MAX_VALUE elements, the size method does not work.
 *  2. An ArrayQueue's capacity cannot exceed Integer.MAX_VALUE.
 *  3. The capacity of this ArrayQueue can change after it's created by directly or indirectly activated the
 *     ensureCapacity() method. However, the capacity is limited by the amount of free memory. Any attempt to exceed
 *     the free memory will result in an OutOfMemoryError.
 *
 * @author mlewis
 * @version Nov 11, 2019
 *********************************************************************************************************************/

public class ArrayQueue<E> implements Queue {
    // Invariant of the ArrayQueue class.
    // 1. For a nonempty ArrayQueue, the items in the ArrayQueue are stored in a circular array beginning at
    //    data[front] and continuing through data[rear]. Note that the rear can be at a lower index than the front due
    //    to the mechanics of a circular array.
    // 2. The instance variable size is the number of items in this ArrayQueue.
    // 3. The instance variable INITIAL_CAPACITY is a constant and is used as the initial capacity of this ArrayQueue.
    // 3. This ArrayQueue is a first-in/first-out data structure, so items are added at the rear and removed at the
    //    front.
    private int front;
    private int rear;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;

    /**
     * public ArrayQueue()
     * Initialize an ArrayQueue with an initial capacity of 10 elements.
     * @postcondition
     *  This ArrayQueue has been initialized with an initial capacity of 10 elements.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this ArrayQueue.
     */
    public ArrayQueue() {
        front = 0;
        rear = 0;
        size = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    /**
     * public ArrayQueue(int capacity)
     * Initialize an ArrayQueue with the given initial capacity.
     * @postcondition
     *  This ArrayQueue has been initialized with the given initial capacity.
     * @exception IllegalArgumentException
     *  Indicates an invalid initial capacity. Initial capacity must be a positive integer.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this ArrayQueue.
     */
    public ArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity. Capacity must be positive: " + capacity);
        }
        front = 0;
        rear = 0;
        size = 0;
        data = new Object[capacity];
    }

    /**
     * public void add(E item)
     * Mutator method that adds a new item to the rear of the Queue. The new item may be a null reference. Note that
     * the rear item may be at an lower index than the front item due to the mechanics of a circular array.
     * @param item
     *  The item to be added to this ArrayQueue.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for a larger ArrayQueue.
     */
    @Override
    public void add(Object item) {
        if (size == data.length) { ensureCapacity(size * 2 + 1); }

        if (size == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = nextIndex(rear); // Increment rear so the new item doesn't overwrite the current rear item.
        }

        data[rear] = item;
        size++;
    }

    /**
     * public void clear()
     * Mutator method that clears the queue and resets front, rear, and size to zero.
     * @postcondition
     *  The array is now empty and front, rear, and size are zero.
     */
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * public void ensureCapacity(int capacity)
     * Increase the capacity of this ArrayQueue. Note that the capacity will not be increased if the current capacity
     * is already larger than the given capacity.
     * @param capacity
     *  The new capacity of this ArrayQueue.
     * @postcondition
     *  This ArrayQueue's capacity has been increased to the given capacity. Note that the capacity will not be
     *  increased if the current capacity is already larger than the given capacity.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the larger ArrayQueue.
     */
    public void ensureCapacity(int capacity) {
        Object[] largerArray;
        int distanceToEnd;
        int distanceToFront;

        if (data.length >= capacity) {
            // No work required because the capacity of this ArrayQueue is larger than the given capacity.
        } else if (size == 0) {
            data = new Object[capacity];
        } else if (front <= rear) {
            // Don't reset front and rear because they are already in the correct position.
            largerArray = new Object[capacity];
            System.arraycopy(data, front, largerArray, front, size);
            data = largerArray;
        } else {
            largerArray = new Object[capacity];
            distanceToEnd = data.length - front;
            distanceToFront = rear + 1;
            System.arraycopy(data, front, largerArray, 0, distanceToEnd);
            System.arraycopy(data, 0, largerArray, distanceToEnd, distanceToFront);

            // Reset front and rear because they are in the wrong position due to the mechanics of a circular array.
            front = 0;
            rear = size - 1;
            data = largerArray;
        }
    }

    /**
     * public int getCapacity()
     * Accessor method that returns the capacity of this ArrayQueue.
     * @return int
     *  The capacity of this ArrayQueue.
     */
    public int getCapacity() { return data.length; }

    /**
     * public E getData()
     * Accessor method that returns a reference to the instance variable data, which is an ArrayQueue.
     * @return E
     *  A reference to the instance variable data, which is an ArrayQueue.
     */
    public Object[] getData() { return data; }

    /**
     * public int getFront()
     * Accessor method that returns the front item of this ArrayQueue. Note, we have suppressed warnings because
     * our programming guarantees that an E object is returned.
     * @return int
     *  The front index of this ArrayQueue.
     */
    @SuppressWarnings("unchecked")
    public E getFront() { return (E) data[front]; }

    /**
     * public int getItem(int index)
     * Accessor method that returns the item at the specified index. Note, we have suppressed warnings because
     * our programming guarantees that an E object is returned.
     * @param index
     *  The target index.
     * @return int
     *  The item at the target index.
     */
    @SuppressWarnings("unchecked")
    public E getItem(int index) {
        if (index >= size) {
            // No work needed.
        }
        return (E) data[index];
    }

    /**
     * public int getRear()
     * Accessor method that returns the rear item of this ArrayQueue. Note, we have suppressed warnings because
     * our programming guarantees that an E object is returned.
     * @return int
     *  The rear index of this ArrayQueue.
     */
    @SuppressWarnings("unchecked")
    public E getRear() { return (E) data[rear]; }

    /**
     * public boolean isEmpty()
     * Accessor method that determines whether or not this ArrayQueue is empty.
     * @return boolean
     *  True if this ArrayQueue is empty. Otherwise false.
     */
    @Override
    public boolean isEmpty() { return size == 0; }

    /**
     * private int nextIndex(int index)
     * Helper method that finds the next index when adding or removing from this ArrayQueue.
     * @param index
     *  The current front or rear index in this ArrayQueue.
     * @return int
     *  The next available index in this ArrayQueue
     * @postcondition
     *  The return value is 0 if front equals the length of the array. Otherwise the return value is index + 1.
     */
    private int nextIndex(int index) {
        if (++index == data.length) {
            return 0;
        } else {
            return index;
        }
    }

    /**
     * public void print()
     * Prints every element contained in the activating queue. Note that front may be at a higher index than rear.
     * @postcondition
     *  The values in the activating queue have been written using System.out.println()
     */
    public void print() {
        for (Object elem : data) {
            System.out.println(elem);
        }
    }

    /**
     * public E remove()
     * Mutator method that removes the front item from this ArrayQueue. Note, we have suppressed warnings because
     * our programming guarantees that an E object is returned.
     * @precondition
     *  This ArrayQueue is not empty.
     * @return E
     *  The front item from this ArrayQueue.
     * @postcondition
     *  The front item from this ArrayQueue has been removed and the next item is now the front item. Size has been
     *  decreased by one.
     */
    @Override
    @SuppressWarnings("unchecked")
    public E remove() {
        E removedItem;

        if (size == 0) {
            return null;
        } else {
            removedItem = (E) data[front];
            front = nextIndex(front);
            size--;
            return removedItem;
        }
    }

    /**
     * public void setItem(int index, E item)
     * Mutator method that sets the value of the item at the specified index to the given item.
     * @param index
     *  The target index.
     * @param index
     *  The new item.
     * @postcondition
     *  The item at the specified index has been set to the specified item.
     */
    public void setItem(int index, E item) {
        if (index >= size) {
            // No work needed.
        }
        data[index] = item;
    }

    /**
     * public int size()
     * Accessor method to determine the number of elements in this ArrayQueue.
     * @return int
     *  The number of items in this ArrayQueue.
     */
    @Override
    public int size() { return size; }

    /**
     * public void trimToSize()
     * Mutator method to decrease the capacity of this ArrayQueue.
     * @postcondition
     *  The capacity of this ArrayQueue has been decreased to the size of the array. Note, the capacity may not be
     *  decreased if capacity and size are equivalent.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the smaller ArrayQueue.
     */
    public void trimToSize() {
        int distanceToEnd;
        int distanceToFront;
        Object[] smallerArray;

        if (size == data.length) {
            return;
        } else if (size == 0) {
            smallerArray = new Object[size];
        } else if (front <= rear) {
            smallerArray = new Object[size];
            System.arraycopy(data, front, smallerArray, front , size - 1);
        } else {
            smallerArray = new Object[size];
            distanceToEnd = size - front;
            distanceToFront = rear + 1;
            System.arraycopy(data, front, smallerArray, 0, distanceToEnd);
            System.arraycopy(data, 0, smallerArray, distanceToEnd, distanceToFront);
            front = 0;
            rear = size - 1;
        }

        data = smallerArray;
    }
}
