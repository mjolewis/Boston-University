package edu.bostonuniversity.collections;

public interface List<E> extends Cloneable {
    /**
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
    static <E> LinkedList<E> concatenation(List<E> s1, List<E> s2) {
        if (s1 == null) { throw new IllegalArgumentException("s1 is null."); }
        if (s2 == null) { throw new IllegalArgumentException("s2 is null."); }

        LinkedList<E> answer = s1.clone(); // Clone the s1 sequence and...
        LinkedList<E> copyS2 = s2.clone(); // ...clone the s2 sequence and...
        answer.addAll(copyS2); // ...join the two cloned sequences together.
        return answer;
    }

    void addAfter(E element);

    void addBefore(E element);

    void addFirst(E element);

    void addAll(LinkedList<E> addend);

    void advance();

    @Override
    @SuppressWarnings("unchecked")
    LinkedList<E> clone();

    E getCurrent();

    E getPrevious();

    boolean isCurrent();

    void removeCurrent();

    int size();

    void start();
}
