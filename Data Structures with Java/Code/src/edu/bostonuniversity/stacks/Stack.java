package edu.bostonuniversity.stacks;

public interface Stack<E> {
    boolean isEmpty();
    E peek();
    E pop();
    E push(E item);
    boolean clear();
    int search(Object obj);
}
