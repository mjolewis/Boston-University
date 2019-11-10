package edu.bostonuniversity.projects;

import edu.bostonuniversity.collections.ArrayQueue;

/**********************************************************************************************************************
 * SieveOfEratosthenesMain.java initiates the SieveOfEratosthenes class where the class calculates all the prime
 * numbers up to some integer n. The technique was developed by a Greek mathematician and poet Eratosthenes who lived
 * in the third century BC.
 *
 * @author mlewis
 * @version Nov 8, 2019
 *********************************************************************************************************************/

public class SieveOfEratosthenesMain {
    public static void main(String[] args) {
//        BuildGUI start = new BuildGUI();
//        start.constructGUI();

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        System.out.println(queue.isEmpty());

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        System.out.println("Capacity is: " + queue.getCapacity());
        System.out.println("Size is: " + queue.size());
        System.out.println();

        queue.add(11);

        System.out.println("Capacity is: " + queue.getCapacity());
        System.out.println("Size is: " + queue.size());
        System.out.println("Front index is: " + queue.getFront());
        System.out.println("Rear index  is: " + queue.getRear());

        Object[] test = queue.getData();

        System.out.println();
        System.out.println("Front item is: " + test[queue.getFront()]);
        System.out.println("Rear item is: " + test[queue.getRear()]);

        System.out.println();
        System.out.println("Removing front: " + queue.remove());
        System.out.println("Front index is: " + queue.getFront());
        System.out.println("Front item is: " + test[queue.getFront()]);

        System.out.println();
        System.out.println("Rear index  is: " + queue.getRear());
        System.out.println("Rear item is: " + test[queue.getRear()]);

        System.out.println();
        System.out.println(queue.isEmpty());
        System.out.println("Size is: " + queue.size());
        System.out.println("Capacity is: " + queue.getCapacity());

        queue.trimToSize();
        System.out.println("Size is: " + queue.size());
        System.out.println("Capacity is: " + queue.getCapacity());
    }
}
