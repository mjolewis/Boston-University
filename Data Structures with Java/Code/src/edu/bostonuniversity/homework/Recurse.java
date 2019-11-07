// File Recurse.java from the package edu.bostonuniversity.homework

/**********************************************************************************************************************
 * I recurse, therefore I recurse. This program illustrates the concept of recursion by writing the output of a
 * recursive call using System.out.println().
 *
 * @note
 *  1) A deep recursive call might lead to a StackOverflowError.
 *  2) A recursive call without a base case and a variant condition will result in infinite recursion (until a
 *     StackOverflowError occurs, but our programming has prevented this type of error.
 *
 * @author mlewis
 * @version Nov 7, 2019
 *********************************************************************************************************************/

package edu.bostonuniversity.homework;

public class Recurse {
    // Invariant of the Recurse.java class.
    //  1) The Recurse.java class does not use any instance variables.

    /**
     * public Recurse()
     * Initialize an empty Recurse object.
     * @postcondition
     *  An empty Recurse object has been initialized.
     */
    public Recurse() {}

    /**
     * public String convert(int n)
     * A recursive method to return an integer as a String of digits.
     * @param n
     *  The integer being converted to a String.
     * @return String
     *  A String representation of the integer argument.
     */
    public String convert(int n) {
        String answer = "";
        if (n == 0) {
            return answer;
        }
        answer += n % 10;
        return convert(n / 10) + answer;
    }

    /**
     * public void printRecursivePattern(int start, int end)
     * A series of asterisks have been written to the terminal using System.out.println(). The first line contains one
     * asterisk, the next line contains 2, and so on, up to the nth line, which contains n asterisks. Line n+1 and n+2
     * contain n asterisks. The next line has n-1 asterisks, and so on until line number 2n+1 which has one asterisk.
     * @param start
     *  The lower end of a range that goes from start to end.
     * @param end
     *  The higher end of a range that goes from start to end.
     * @precondition
     *  The start and end are greater than or equal to zero with end being greater than start.
     * @postcondition
     *  A series of asterisks have been written to the terminal using System.out.println().
     */
    public void printRecursivePattern(int start, int end) {
        if (start < 0 || end < 0) { return; }
        if (start > end) {
            System.out.println("*".repeat(end));
            return;
        }
        System.out.println("*".repeat(start));
        printRecursivePattern(start + 1, end);
        System.out.println("*".repeat(start));
    }
}
