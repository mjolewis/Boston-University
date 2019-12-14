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
     * public void addEdge(int source, int target, int cost)
     * Adds an edge from the specified source to the specified target. Our implementation suppresses warnings because
     * our programming ensures that the list is of type E.
     * @param source
     *  The source vertex.
     * @param target
     *  The target vertex.
     * @param cost
     *  The cost of using this Edge.
     * @postcondition
     *  An edge has been added between the source vertex and target vertex.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the source or target vertex is not a valid vertex number.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for the new Edge used by this method.
     */
    void addEdge(int source, int target, int cost);

    /**
     * public getLabel(source)
     * Accessor method that retrieves a reference to the vertex's label. Our implementation suppresses warnings because
     * our programming ensures that the label is of type E.
     * @param source
     *  A reference to the source vertex whose label we are retrieving.
     * @precondition
     *  Source is non-negative and is less that the size of this Graph.
     * @return E
     *  A reference to the source vertex's label
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the source vertex is not a valid vertex number.
     */
    E getLabel(int source);

    /**
     * public boolean isEdge(int source, int target)
     * Accessor method that determines if there is an edge between the source and target vertices. Our implementation
     * suppresses warnings because our programming ensures that the list is of type E.
     * @param source
     *  The source vertex.
     * @param target
     *  The target vertex.
     * @precondition
     *  Source and target are non-negative and are less that the size of this Graph.
     * @return boolean
     *  True if there is an edge between the source and target vertices. Otherwise, false.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the start vertex was not a valid vertex number.
     */
    boolean isEdge(int source, int target);

    /**
     * public int[] neighbors(int vertex)
     * Utility method that retrieves all of the neighbors of the specified vertex. A vertex has neighbors if there is
     * an edge between the vertex and a target vertex. For example, if there is an edge between vertex1 and vertex2,
     * then vertex1 and vertex2 are neighbors. Our implementation suppresses warnings because our programming ensures
     * that the list is of type E.
     * @param vertex
     *  A non-null reference to the source vertex.
     * @precondition
     *  Vertex is non-negative and is less that the size of this Graph.
     * @return int[]
     *  A reference to an integer array that contains all of the specified vertex's neighbors.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for integer array used by this method.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the vertex is not a valid vertex number.
     */
    int[] neighbors(int vertex);

    /**
     * public removeEdge(int source, int target)
     * Mutator method that removes the edge (if one exists) between the source and target vertices. If there is no edge
     * then no work is performed.
     * @param source
     *  A reference to the source vertex.
     * @param target
     *  A reference to the target vertex. Note that the target vertex can be a null reference. Our implementation
     * @precondition
     *  The reference to the source vertex is a non-null reference.
     *  suppresses warnings because our programming ensures that the list is of type E.
     * @postcondition
     *  The edge (if it existed) has been removed and the source and target vertices are no longer connected.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the source and/or target were not valid vertex numbers.
     */
    void removeEdge(int source, int target);

    /**
     * public setLabel(int source, E label)
     * Mutator method that sets the label for the specified source vertex. Our implementation suppresses warnings
     * because our programming ensures that the label is of type E.
     * @param source
     *  A reference to the source vertex.
     * @param label
     *  A reference to the label of this vertex.
     * @precondition
     *  The source vertex is within the bounds of the vertices array.
     * @postcondition
     *  The label for this vertex has been set. However, if the source vertex is outside the bounds of this Vertex,
     *  then an ArrayIndexOutOfBoundsException is thrown.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the source was not valid vertex number.
     */
    void setLabel(int source, E label);

    /**
     * public int size()
     * Accessor method that retrieves the size of this Graph.
     * @return int
     *  The size of this Graph. Note that the size can be 0.
     */
    int size();
}
