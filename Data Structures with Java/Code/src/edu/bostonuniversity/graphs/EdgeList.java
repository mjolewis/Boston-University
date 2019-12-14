// File EdgeList.java from the package edu.bostonuniversity.graphs

package edu.bostonuniversity.graphs;

/**********************************************************************************************************************
 * An EdgeList is a linked list used to connect n vertices in a Graph. List number i provides the connections for
 * vertex i. To be specific: For each entry j in list number i, there is an edge from i to j. Representing a graph as
 * an edge list is more efficient than an adjacency matrix representation when iterating a loop that executes for each
 * edge with a particular source vertex is a more common operation.
 *
 * @author mlewis
 * @version Dec 13, 2019
 *********************************************************************************************************************/

public class EdgeList<E> implements Graph<E>{
    // Invariant of the EdgeList.java class
    //  1. The instance variable vertex is an array of vertices that act as a reference to the head of a linked list.
    //     If the vertex has any neighbors, we can access those neighbors by looping through the linked list at the
    //     specified vertex.
    //  2. The instance variable INITIAL_CAPACITY is the default initial capacity of the vertices array.
    private Vertex[] vertices;
    private static final int INITIAL_CAPACITY = 13;

    /**
     * public EdgeList()
     * Initializes an array of vertices whose size is equal to the INITIAL_CAPACITY and whose label is set by our call
     * to the setLabel method. Our implementation suppresses warnings because our programming ensures tha the label is
     * of type E.
     * @postcondition
     *  The Vertex array has been initialized with an initial size of INITIAL_CAPACITY. Each vertex is a null
     *  reference.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new Vertex array.
     */
    @SuppressWarnings("unchecked")
    public EdgeList() {
        vertices = new Vertex[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            vertices[i] = new Vertex();
            vertices[i].setLabel("V" + i);
        }
    }

    /**
     * public EdgeList(int initialCapacity)
     * Initializes an array of vertices whose size is equal to the initialCapacity and whose label is set by our call
     * to the setLabel method. Our implementation suppresses warnings because our programming ensures that the label is
     * of type E.
     * @precondition
     *  The initialCapacity is a non-negative integer.
     * @param initialCapacity
     *  The initial capacity of the Vertex array.
     * @postcondition
     *  The Vertex array has been initialized with the specified initial capacity. Each vertex is a null reference.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new Vertex array.
     * @exception IllegalArgumentException
     *  Indicates a negative initial capacity.
     */
    @SuppressWarnings("unchecked")
    public EdgeList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity is negative: " + initialCapacity);
        }
        vertices = new Vertex[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            vertices[i] = new Vertex();
            vertices[i].setLabel("V" + i);
        }
    }

    /**
     * void addEdge(int source, int target)
     * Adds an edge from the specified source to the specified target. Note that target may be null, which indicates
     * that the edge is only connected to the source vertex.
     * @param source
     *  A reference to source vertex. Note that the source vertex cannot be a null reference.
     * @param target
     *  A reference to the target vertex.
     * @precondition
     *  The source vertex is not null.
     * @postcondition
     *  An edge has been added between the source vertex and target vertex. Note that if the target is a null reference
     *         then the edge is only connected to the source vertex.
     */
    @Override
    public void addEdge(int source, int target) {

    }

    /**
     * getLabel(source)
     * Accessor method that retrieves a reference to the vertex's label. Our implementation suppresses warnings because
     * our programming ensures that the label is of type E.
     * @param source
     *  A reference to the source vertex whose label we are retrieving.
     * @return E
     *  A reference to the source vertex's label
     */
    @Override
    @SuppressWarnings("unchecked")
    public E getLabel(int source) { return (E) vertices[source].getLabel(); }

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
    @Override
    public boolean isEdge(int source, int target) {
        return false;
    }

    /**
     * removeEdge(int source, int target)
     * Mutator method that removes the edge (if one exists) between the source and target vertices. If there is no edge
     * then no work is performed.
     * @param source
     *  A reference to the source vertex.
     * @param target
     *  A reference to the target vertex. Note that the target vertex can be a null reference.
     * @precondition
     *  The reference to the source vertex is a non-null reference.
     * @postcondition
     *  The edge (if it existed) has been removed and the source and target vertices are no longer connected.
     */
    @Override
    public void removeEdge(int source, int target) {

    }

    /**
     * setLabel(int source, E label)
     * Mutator method that sets the label for the specified source vertex. Our implementation suppresses warnings
     * because our programming ensures that the label is of type E.
     * @precondition
     *  The source vertex is within the bounds of the vertices array.
     * @param source
     *  A reference to the source vertex.
     * @param label
     *  A reference to the label of this vertex.
     * @postcondition
     *  The label for this vertex has been set. However, if the source vertex is outside the bounds of this Vertex,
     *  then an ArrayIndexOutOfBoundsException is thrown.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the source vertex is outside the bounds of this Vertex.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void setLabel(int source, E label) { vertices[source].setLabel(label); }

    /**
     * size()
     * Accessor method that retrieves the size of this Graph.
     * @return int
     *  The size of this Graph. Note that the size can be 0.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * int[] neighbors(int vertex)
     * Utility method that retrieves all of the neighbors of the specified vertex. A vertex has neighbors if there is
     * an edge between the vertex and a target vertex. For example, if there is an edge between vertex1 and vertex2,
     * then vertex1 and vertex2 are neighbors.
     * @param vertex
     *  A non-null reference to the source vertex.
     * @return int[]
     *  A reference to an integer array that contains all of the specified vertex's neighbors.
     * @precondition
     *  Vertex is a non-null reference.
     */
    @Override
    public int[] neighbors(int vertex) {
        return new int[0];
    }
}