//File Vertex.java from the package edu.bostonuniversity.graphs

package edu.bostonuniversity.graphs;

/**********************************************************************************************************************
 *
 * @author mlewis
 * @version Dec 13, 2019
 */

public class Vertex<E> {
    // 1. The instance variable label is used to make our graph a Labeled Graph. The label is used to store information
    //    at each vertex such as a city name or other unique identifier for this vertex.
    // 2. The instance variable list is a reference to a linked list of connected vertices. If the specified vertex has
    //    no connected vertices, then the list is a null reference.
    private E label;
    private Edge<E> list;

    /**
     * public Vertex()
     * Initializes an empty Vertex.
     * @postcondition
     *  This Vertex is empty.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new Vertex.
     */
    public Vertex() {
        label = null;
        list = null;
    }

    /**
     * public Vertex(E label, Edge list)
     * Initializes one new Vertex with the specified label and edge list. Note that the label and edge list may be a
     * null reference, which indicates that this Vertex has no connections in the graph.
     * @param label
     *  The label of this Vertex.
     * @param list
     *  An edge list representing the connections point between two vertices.
     */
    public Vertex(E label, Edge<E> list) {
        this.label = label;
        this.list = list;
    }

    /**
     * public E getLabel()
     * Accessor method that retrieves a reference to the label of this Vertex.
     * @return E
     *  The label of this Vertex.
     */
    public E getLabel() { return label; }

    /**
     * public Edge<E> getList()
     * Accessor method that retrieves a reference to a linked list of edges and vertices.
     * @return Edge
     *  A reference to a linked list of edges and vertices.
     */
    public Edge<E> getList() { return list; }

    /**
     * public void setLabel(E label)
     * Mutator method that sets the reference for the label of this Vertex.
     * @param label
     *  The new label of this Vertex.
     * @postcondition
     *  The label of this Vertex has been updated. If the label is null, then this vertex's label is now null.
     */
    public void setLabel(E label) { this.label = label; }

    /**
     * public void setList(Edge list)
     * Mutator method that sets the reference list for this Vertex. A list is a set of edge's and vertices that are
     * connected in a graph. Note that the list may be a null reference, which indicates that this Vertex has no
     * connections.
     * @param list
     *  The new edge list for this Vertex.
     * @postcondition
     *  The edge list of this Vertex has been updated. If the edge list is null, then this vertex has no connections.
     */
    public void setList(Edge<E> list) { this.list = list; }
}
