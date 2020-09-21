// File Map.java from the package edu.bostonuniversity.collections

package edu.bu.met342.collections;

/**********************************************************************************************************************
 * A Map is an object that maps keys to values. A map cannot contain duplicate keys and each key can map to at most one
 * value.
 *
 * @author mlewis
 * @version Nov 24, 2019
 *********************************************************************************************************************/

public interface Map {

    boolean contains(int k);

    void delete(int k);

    String get(int k);

    void printHash();

    void put(int k, String v);
}
