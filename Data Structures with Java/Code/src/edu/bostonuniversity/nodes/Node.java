package edu.bostonuniversity.nodes;

public interface Node<E> {

    E getData();

    Node<E> getNext();

    void setData(E data);

    void setNext(Node<E> next);
}
