package edu.bostonuniversity.homework;

import edu.bostonuniversity.collections.HashTable;

public class HashTableTest {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(31, "Key is 31, but index is 0 due to hashing");
        table.put(1, "Key is 1 and this is the first entry");
        table.put(32, "Key is 32 and collides with 1.");
        table.put(63, "Key is 63 and collides with 1 and 32");
        table.put(94, "Key is 94 and collides with 1, 32, 63");
        table.put(36, "Key is 36 but index is 5 due to hashing");
        table.put(6, "Key is 6 and this is the first entry");
        table.put(7, "Key is 7 and this is the first entry");
        table.put(8, "Key is 8 and this is the first entry");
        table.put(9, "Key is 9 and this is the first entry");
        table.put(10, "Key is 10 and this is the first entry");
        table.put(11, "Key is 11 and this is the first entry");
        table.put(3, "Key is 3 but index should be 12 due to collisions");
        table.printHash();

        System.out.println("Deleting key 8");
        table.delete(8);
        table.printHash();
    }
}
