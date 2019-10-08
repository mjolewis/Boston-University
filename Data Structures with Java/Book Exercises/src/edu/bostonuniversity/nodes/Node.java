package edu.bostonuniversity.nodes;

public interface Node<E> {

    E getData();

    NodeList<E> getNext();

    void setData(E data);

    void setNext(NodeList<E> next);
}
