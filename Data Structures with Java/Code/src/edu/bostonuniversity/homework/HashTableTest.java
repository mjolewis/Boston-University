// File HashTableTest.java from the package edu.bostonuniversity.homework

package edu.bostonuniversity.homework;

import edu.bostonuniversity.collections.HashTable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**********************************************************************************************************************
 * A HashTableTest class provides a terminal interface to test the functionality of the HashTable.java class.
 *
 * @author mlewis
 * @version November 24, 2019
 *********************************************************************************************************************/

public class HashTableTest {

    public static void main(String[] args) {
        String sentinelValue = "";
        int key;
        String value;
        HashTable table = new HashTable();

        while (!sentinelValue.toUpperCase().equals("N")) {
            Scanner scanner = new Scanner(System.in);
            key = getKey();
            value = getValue();

            System.out.print("Enter 'N' to end or 'Y' to continue: ");
            sentinelValue = scanner.next();
            table.put(key, value);
        }

        System.out.println("\nCurrent table looks like ->");
        table.printHash();

        sentinelValue = "";
        while (!sentinelValue.toUpperCase().equals("N")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a key to delete: ");
            key = Integer.parseInt(scanner.next());
            table.delete(key);

            System.out.print("Enter 'Y' to continue deleting. 'N' to end: ");
            sentinelValue = scanner.next();
        }

        System.out.println("\nModified table looks like ->");
        table.printHash();
    }

    /*
     * private static int getKey()
     * A helper method to get an integer key from the user.
     * @return int
     *  The integer key provided by the user.
     */
    private static int getKey() {
        int key = -1;
        Scanner scanner = new Scanner(System.in);
        boolean sentinelValue = false;

        while (!sentinelValue) {
            try {
                System.out.print("Enter an integer key: ");
                key = scanner.nextInt();
                sentinelValue = true;
            } catch (InputMismatchException e) {
                sentinelValue = false;
                scanner = new Scanner(System.in);
                System.out.print("You must enter an integer.\n");
            }
        }

        return key;
    }

    /*
     * private static String getValue()
     * A helper method to get a String value from the user.
     * @return String
     *  The String value provided by the user.
     */
    private static String getValue() {
        String value;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string value: ");
        value = scanner.nextLine();
        return value;
    }
}
