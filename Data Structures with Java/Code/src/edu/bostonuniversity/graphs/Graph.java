// File Graph.java from the package edu.bostonuniversity.graphs

package edu.bostonuniversity.graphs;

/**********************************************************************************************************************
 * A Graph is a non-linear data structure consisting of nodes and links between the nodes. A Graph can come in several
 * varieties including an undirected graph or directed graph. Graphs can also have multiple edges and allow for loops;
 * however, our implementation restricts these use cases and requires that the Graph not have multiple edges or loops.
 *
 * @note
 *  1. Beyond Integer.MAX_VALUE, the size method, the size method does not work.
 *
 * @author mlewis
 * @version Dec 14, 2019
 *********************************************************************************************************************/

public interface Graph<E> {

    /**
     * void addEdge(int source, int target)
     * Adds an edge from the specified source to the specified target. Note that target may be null, which indicates
     * that the edge is only connected to the source vertex.
     * @precondition
     *  The source vertex is not null.
     * @param source
     *  A reference to source vertex. Note that the source vertex cannot be a null reference.
     * @param target
     *  A reference to the target vertex.
     * @postcondition
     *  An edge has been added between the source vertex and target vertex. Note that if the target is a null reference
     *  then the edge is only connected to the source vertex.
     */
    void addEdge(int source, int target);

    /**
     * getLabel(source)
     * Accessor method that retrieves a reference to the vertex's label.
     * @param source
     *  A reference to the source vertex whose label we are retrieving.
     * @return E
     *  A reference to the source vertex's label
     */
    E getLabel(int source);

    /**
     * boolean isEdge(int source, int target)
     * Accessor method that determines whether or not there is an edge between the source and target vertices.
     * @param source
     *  A reference to the source vertex.
     * @param target
     *  A reference to the target vertex.
     * @return boolean
     *  True if there is an edge between the source and target vertices. Otherwise, false.
     */
    boolean isEdge(int source, int target);

    /**
     * removeEdge(int source, int target)
     * Mutator method that removes the edge (if one exists) between the source and target vertices. If there is no edge
     * then no work is performed.
     * @precondition
     *  The reference to the source vertex is a non-null reference.
     * @param source
     *  A reference to the source vertex.
     * @param target
     *  A reference to the target vertex. Note that the target vertex can be a null reference.
     * @postcondition
     *  The edge (if it existed) has been removed and the source and target vertices are no longer connected.
     */
    void removeEdge(int source, int target);

    /**
     * setLabel(int source, E label)
     * Mutator method that sets the label for the specified source vertex.
     * @precondition
     *  The source vertex is a non-null reference.
     * @param source
     *  A reference to the source vertex.
     * @param label
     *  A reference to the label of this vertex.
     * @postcondition
     *  The label for this vertex has been set. However, if the source is a null reference, then no work is performed.
     */
    void setLabel(int source, E label);

    /**
     * size()
     * Accessor method that retrieves the size of this Graph.
     * @return int
     *  The size of this Graph. Note that the size can be 0.
     */
    int size();

    /**
     * int[] neighbors(int vertex)
     * Utility method that retrieves all of the neighbors of the specified vertex. A vertex has neighbors if there is
     * an edge between the vertex and a target vertex. For example, if there is an edge between vertex1 and vertex2,
     * then vertex1 and vertex2 are neighbors.
     * @precondition
     *  Vertex is a non-null reference.
     * @param vertex
     *  A non-null reference to the source vertex.
     * @return int[]
     *  A reference to an integer array that contains all of the specified vertex's neighbors.
     */
    int[] neighbors(int vertex);
}
