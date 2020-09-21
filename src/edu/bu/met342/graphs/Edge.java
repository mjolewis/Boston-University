// File Edge.java from the package edu.bostonuniveristy.graphs

package edu.bu.met342.graphs;

/**********************************************************************************************************************
 * An edge is a link in a graph that connects two vertices. We sometimes say that the edge "connects" its two vertices
 * in an undirected graph. Each edge is associated with a source and target vertices in a directed graph.
 *
 * The order of the two connected vertices in an undirected graph is unimportant, so it does not matter whether we say
 * "This edge connects vertices u and v", or "This edge connects vertices v and u." However, the order is important in
 * a directed graph.
 *
 * @author mlewis
 * @version Dec 12, 2019
 *********************************************************************************************************************/

public class Edge<E> {
    // Invariant of the Edge.java class
    //  1. The instance variable cost a non-negative integer incurred for using it. For example, the cost could be the
    //     amount of energy required to use a path or the time required to transmit a message.
    //  2. The instance variable vertex is a node on a graph. These nodes are connected by a set of links called edges.
    //  3. The instance variable next is the edge used to connect two vertices.
    private int cost;
    private int vertex;
    private Edge<E> next;

    /**
     * public Edge()
     * Initializes an empty Edge.
     * @postcondition
     *  An empty Edge has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this Edge.
     */
    public Edge() {
        cost = 0;
        vertex = 0;
        next = null;
    }

    /**
     * public Edge(int cost, int vertex, Edge<E> next)
     * Initializes an empty Edge. Note that the Edge next can be null.
     * @param cost
     *  A non-negative integer.
     * @param vertex
     *  Represents the number of the vertex.
     * @param next
     *  A Edge used to connect two vertices.
     * @precondition
     *  Cost is a non-negative integer.
     * @postcondition
     *  An Edge has been initialized with the specified cost, vertex, and edge.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new Edge.
     * @exception IllegalArgumentException
     *  Indicates that cost is not a non-negative integer.
     */
    public Edge(int cost, int vertex, Edge<E> next) {
        if (cost < 0) { throw new IllegalArgumentException("Cost is negative: " + cost); }
        this.cost = cost;
        this.vertex = vertex;
        this.next = next;
    }

    /**
     * public int getCost()
     * Accessor method that retrieves the cost of this Edge.
     * @return int
     *  A non-negative integer representing the cost to use this Edge.
     */
    public int getCost() { return cost; }

    /**
     * public int getVertex()
     * Accessor method that retrieves the vertex of this Edge.
     * @return int
     *  The integer value representing the vertex connected to this Edge.
     */
    public int getVertex() { return vertex; }

    /**
     * public Edge<E> getNext()
     * Accessor method that retrieves a reference to the next vertex connected by an Edge.
     * @return next
     *  A reference to the vertex connected by an Edge (or the null reference if there is nothing connected to this
     *  vertex.
     */
    public Edge<E> getNext() { return next; }

    /**
     * public void setCost(int cost)
     * Mutator method to set the cost of this Edge.
     * @precondition
     *  The cost is a non-negative integer.
     * @param cost
     *  A non-negative integer representing the cost to use this Edge.
     * @postcondition
     *  The cost of this Edge has been set.
     * @exception IllegalArgumentException
     *  Indicates that cost is a non-negative integer.
     */
    public void setCost(int cost) {
        if (cost < 0) { throw new IllegalArgumentException("Cost is negative: " + cost); }
        this.cost = cost;
    }

    /**
     * public void setNext(Edge<E> next)
     * Mutator method that sets a reference to the edge that connects two vertices.
     * @param next
     *  A reference to the edge that connects two vertices. Note that the edge could be a null reference if no other
     *  vertex is connected to this vertex.
     * @postcondition
     *  The Edge to the next vertex has been set. Any other edge that used to be in this Edge is no longer connected
     *  to this vertex.
     */
    public void setNext(Edge<E> next) { this.next = next; }

    /**
     * public void setVertex(int vertex)
     * Mutator method that sets the integer value representing this vertex.
     * @param vertex
     *  The integer value representing this vertex.
     * @postcondition
     *  The integer value representing this vertex has been set.
     */
    public void setVertex(int vertex) { this.vertex = vertex; }
}
