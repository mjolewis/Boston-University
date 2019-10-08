package edu.bostonuniversity.collections;

public interface List<E> {


    void addAfter(E element);

    void addBefore(E element);

    void addFirst(E element);

    void addAll(LinkedList<E> addend);

    void advance();

    E getCurrent();

    E getPrevious();

    boolean isCurrent();

    void removeCurrent();

    int size();

    void start();
}
