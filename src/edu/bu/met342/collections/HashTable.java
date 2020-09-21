// File HashTable.java from the package edu.bostonuniversity.collections

package edu.bu.met342.collections;

/**********************************************************************************************************************
 * A HashTable is a collection used to map keys to values. Any non-null object can be used as a key or as a value.
 * Traditionally, the class is implemented using Java Generics but, our implementation will make use of integer keys
 * and String values.
 *
 * @note
 *  1. A HashTable's performance is affected by it's initial capacity, which should always be a twin prime to optimize
 *     performance.
 *  2. This implementation using Open Addressing to resolve collisions. Meaning that if multiple values are hashed to
 *     the same bucket, then we search for the next open bucket in a sequential manner.
 *
 * @author mlewis
 * @version November 24, 2019
 *********************************************************************************************************************/

public class HashTable implements Map{
    // Invariant of the HashTable class.
    // 1. The number of elements in the table is in the instance variable size.
    // 2. The proper bucket for any given value with a specified key is at hash(key). However, if a collision occurs
    //    then we use open addressing to find the next available bucket. Whenever an open bucket is found, we store
    //    the value in data[index] and the value's key in key[index].
    // 3. The instance variable hasBeenUsed indicates whether or not data[index] has ever been used.
    // 4. The instance variable CAPACITY is part of a twin prime, which is an ideal number for the capacity of a
    //    HashTable.
    private int size;
    private Integer[] keys;
    private String[] data;
    private boolean[] hasBeenUsed;
    private static final Integer CAPACITY = 31;

    /**
     * public HashTable()
     * Initialize an empty HashTable with an initial capacity of 31.
     * @postcondition
     *  An empty HashTable with an initial capacity of 31 has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this HashTable.
     */
    public HashTable() {
        size = 0;
        keys = new Integer[CAPACITY];
        data = new String[CAPACITY];
        hasBeenUsed = new boolean[CAPACITY];
    }

    /**
     * public HashTable(int capacity)
     * Initialize a HashTable with the given initial capacity.
     * @param capacity
     *  The initial capacity of the HashTable.
     * @postcondition
     *  A HashTable with an initial capacity has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this HashTable.
     */
    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        }
        size = 0;
        keys = new Integer[capacity];
        data = new String[capacity];
        hasBeenUsed = new boolean[capacity];
    }

    /**
     * public boolean contains(int k)
     * Accessor method that confirms whether or not a specified key is in this HashTable.
     * @param k
     *  The key to search for.
     * @return boolean
     *  True if k is in this HashTable. Otherwise false.
     */
    @Override
    public boolean contains(int k) { return findIndex(k) != -1; }

    /**
     * public void delete(int k)
     * Mutator method that removes the specified key and it's value from this HashTable.
     * @param k
     *  The key to search for.
     * @postcondition
     *  The specified key and it's value have been removed from this HashTable if they existed. Otherwise, no mutation
     *  occurs.
     */
    @Override
    public void delete(int k) {
        int index = findIndex(k);
        if (index != -1) {
            keys[index] = null;
            data[index] = null;
            size--;
        }
    }

    /**
     * public int findIndex(int k)
     * Helper method that returns the index of the specified key if it exists. Otherwise it returns -1.
     * @param k
     *  The key to search for.
     * @return
     *  The index of the specified key or -1 if the key is not in this HashTable.
     */
    private int findIndex(int k) {
        int count = 0;
        int index = hash(k);

        while (count < data.length && hasBeenUsed[index]) {
            if (k == keys[index]) {
                return index;
            } else {
                count++;
                index = nextIndex(index);
            }
        }
        return -1;
    }

    /**
     * public String get(int k)
     * Accessor method that retrieves the value associated with the specified key.
     * @param k
     *  The key to search for.
     * @return String
     *  The value associated with the specified key. If the key is not found, then null is returned.
     */
    @Override
    public String get(int k) {
        int index = findIndex(k);
        if (index != -1) { return data[index]; }
        return null;
    }

    /**
     * public int getSize()
     * Accessor method that retrieves the size of the data array.
     * @return int
     *  The size of the data array.
     */
    public int getSize() { return size; }

    /*
     * private int hash(int k)
     * Helper method that returns a valid index in this HashTable. The index is calculated using division hashing where
     * the hash is the remainder when the key's hash code is divided by the capacity of data.
     * @param k
     *  The key to hash.
     * @return int
     *  The hash code for the specified key.
     */
    private int hash(int k) { return k % data.length; }

    /*
     * private int nextIndex(int index)
     * A helper method used to step through the array one index at a time with wrap around.
     * @param index
     *  The current index in this HashTable.
     * @return int
     *  The next available index using open addressing.
     */
    private int nextIndex(int index) {
        if (++index == data.length) { return 0; }
        return index;
    }

    /**
     * public void put(int k, String v)
     * Mutator method that adds the specified key and value to this HashTable. If the specified key was already in this
     * HashTable, then the old value will be replaced with the specified value.
     * @param k
     *  The key to search for.
     * @param v
     *  The value associated with the specified key.
     * @postcondition
     *  The specified key and value have been added to this HashTable and size has been incremented. If the key already
     *  existed in this HashTable, then the old value has been replaced with the new specified value and size is not
     *  incremented.
     */
    @Override
    public void put(int k, String v) {
        int index = findIndex(k);

        if (index != -1) { // The key already exists
            data[index] = v;
        } else if (size < data.length) {
            index = hash(k);
            while (keys[index] != null) { // Implements open addressing to find the next available bucket
                index = nextIndex(index);
            }
            keys[index] = k;
            data[index] = v;
            hasBeenUsed[index] = true;
            size++;
        } else {
            throw new IllegalStateException("This HashTable is full.");
        }
    }

    /**
     * public void printHash()
     * Prints every key and value pair in this HashTable.
     * @postcondition
     *  The keys and values in this HashTable have been written using System.out.println().
     */
    @Override
    public void printHash() {
        System.out.println(toString());
    }

    /**
     * public String toString()
     * Prints every key and value pair in this HashTable.
     * @postcondition
     *  The keys and values in this HashTable have been written using System.out.println().
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            stringBuilder.append("Table[").append(i).append("] = ");
            if (data[i] == null && !hasBeenUsed[i]) {
                stringBuilder.append("<Never Used> \n");
            } else if (data[i] == null && hasBeenUsed[i]) {
                stringBuilder.append("<Previously Used> \n");
            } else {
                stringBuilder.append(data[i]).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
