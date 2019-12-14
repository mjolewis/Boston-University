// File GraphNode.java from the package edu.bostonuniversity.nodes

package edu.bostonuniversity.nodes;

/**********************************************************************************************************************
 * A GraphNode is used to implement a breadth-first search of a Graph. The node is used by a queue to  keep track of
 * which vertices might still have unprocessed neighbors. The search beings with a starting vertex, which is processed,
 * marked, and placed in this queue.
 *
 * @author mlewis
 * @version Dec 14, 2019
 *********************************************************************************************************************/

public class GraphNode<E> {
    // Invariant of the GraphNode.java class
    //  1. The instance variable vertex
    //  2. The instance variable next is a reference to the next node in the queue. For the final node of the queue,
    //     the link is a null reference.
    private Integer vertex;
    private GraphNode<E> next;

    /**
     * public Integer getVertex()
     * Accessor method that retrieves a reference to this vertex.
     * @return Integer
     *  A reference to the specified vertex.
     */
    public Integer getVertex() { return vertex; }

    /**
     * public GraphNode<E> getNext()
     * Accessor method that retrieves a reference to the next node in this Graph.
     * @return GraphNode<E>
     *  The next GraphNode in this Queue.
     */
    public GraphNode<E> getNext() { return next; }

    /**
     * public void setNext(GraphNode<E> next)
     * Mutator method that sets a reference to the next node in this Queue.
     * @param next
     *  The next GraphNode in this Queue.
     */
    public void setNext(GraphNode<E> next) { this.next = next; }

    /**
     * public void setVertex(Integer vertex)
     * Mutator method that set the vertex to the specified vertex
     * @param vertex
     *  The specified vertex used to set this vertex.
     */
    public void setVertex(Integer vertex) { this.vertex = vertex; }
}
