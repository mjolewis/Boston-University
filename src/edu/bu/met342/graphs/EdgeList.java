// File EdgeList.java from the package edu.bostonuniversity.graphs

package edu.bu.met342.graphs;

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
    //  1. INITIAL_CAPACITY is the default initial capacity of the vertices array.
    //  2. vertices is an array of Vertex's that act as a reference to the head of a linked list. Each vertices[i] has
    //     a label and an edge list. If the vertex has any any neighbors, we can access those neighbors by looping
    //     through the linked list at v[i].
    //  3. visited is an array that tracks the vertices have been visited during a Graph traversal.
    private static final int INITIAL_CAPACITY = 13;
    private Vertex[] vertices;
    private boolean[] visited;

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
        visited = new boolean[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            visited[i] = false;
            vertices[i] = new Vertex();
            vertices[i].setLabel("V" + i);
        }
    }

    /**
     * public EdgeList(int initialCapacity)
     * Initializes an array of vertices whose size is equal to the initialCapacity and whose label is set by our call
     * to the setLabel method. Our implementation suppresses warnings because our programming ensures that the label is
     * of type E.
     * @param initialCapacity
     *  The initial capacity of the Vertex array.
     * @precondition
     *  The initialCapacity is a non-negative integer.
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
        visited = new boolean[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            visited[i] = false;
            vertices[i] = new Vertex();
            vertices[i].setLabel("V" + i);
        }
    }

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
    @Override
    @SuppressWarnings("unchecked")
    public void addEdge(int source, int target, int cost) {
        if (isEdge(source, target)) { return; } // If the edge already exists, then no work is performed.

        Edge<E> edge = new Edge<>();
        edge.setCost(cost);
        edge.setVertex(target);
        edge.setNext(vertices[source].getList());

        vertices[source].setList(edge);

    }

    /**
     * public void breadthFirstTraversal(int vertex)
     * Traversal method to print the labels of a Graph with a breadth-first search.
     * @param vertex
     *  The vertex number from this Graph.
     * @precondition
     *  Vertex is non-negative and is less than the size of this Graph.
     * @postcondition
     *  A breadth-first search of this Graph has been conducted, starting at the specified start vertex. Each vertex
     *  has its label printed using System.out.println(). Note that vertices that are not connected to the start
     *  vertex will not be visited.
     * @exception NullPointerException
     *  Indicates that this Graph is null.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates insufficient memory for an array of boolean values used by this method.
     */
    public void breadthFirstTraversal(int vertex) {
        GraphQueue graphQueue;
        int[] neighbors;

        for (int i = 0; i < vertices.length; i++) { visited[i] = false; }

        graphQueue = new GraphQueue();
        visited[vertex] = true;
        graphQueue.add(vertex);
        while (!graphQueue.isEmpty()) {
            Integer front = graphQueue.remove(); // Removes the front of the GraphQueue
            neighbors = neighbors(front);
            for (int i = 0; i < neighbors.length; i++) {
                if (!visited[neighbors[i]]) {
                    visited[neighbors[i]] = true;
                    System.out.println("Adding " + neighbors[i] + " to the queue.");
                    graphQueue.add(i);
                }
            }
        }
    }

    /**
     * public void depthFirstTraversal(int vertex)
     * Traversal method to print the labels of a Graph with a depth-first search.
     * @param vertex
     *  The vertex number from this Graph.
     * @precondition
     *  Vertex is non-negative and is less than the size of this Graph.
     * @postcondition
     *  A depth-first search of this Graph has been conducted, starting at the specified start vertex. Each vertex has
     *  its label printed using System.out.println(). Note that vertices that are not connected to the start vertex
     *  will not be visited.
     * @exception NullPointerException
     *  Indicates that this Graph is null.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the start vertex was not a valid vertex number.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for an array of boolean values used by this method.
     */
    public void depthFirstTraversal(int vertex) {
        for (int i = 0; i < vertices.length; i++) { visited[i] = false; }
        recursiveDepthFirstTraversal(vertex);
    }

    /**
     * public int getCost(int source, int target)
     * Accessor method that retrieves the cost of the edge that connects a source and target vertex. Our implementation
     * suppresses warnings because our programming ensures that the list is of type E.
     * @param source
     *  The source vertex.
     * @param target
     *  The target vertex.
     * @precondition
     *  The source and target vertex are non-negative and are less than the size of this Graph.
     * @return int
     *  The cost of the edge that connects the source and target vertex.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates an invalid source or target index.
     */
    @SuppressWarnings("unchecked")
    public int getCost(int source, int target) {
        Edge<E> edge;

        edge = (Edge<E>) vertices[source].getList();
        while (edge != null) {
            if (edge.getVertex() == target) { return edge.getCost(); }
            edge = edge.getNext();
        }
        return Integer.MAX_VALUE;
    }

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
    @Override
    @SuppressWarnings("unchecked")
    public E getLabel(int source) { return (E) vertices[source].getLabel(); }

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
    @Override
    @SuppressWarnings("unchecked")
    public boolean isEdge(int source, int target) {
        Edge<E> edge;

        edge = (Edge<E>) vertices[source].getList();
        while (edge != null) {
            if (edge.getVertex() == target) { return true; }
            edge = edge.getNext();
        }
        return false;
    }

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
    @Override
    @SuppressWarnings("unchecked")
    public int[] neighbors(int vertex) {
        int[] answer;
        int count;
        Edge<E> edge;

        count = 0;
        edge = (Edge<E>) vertices[vertex].getList();
        while (edge != null) {
            count++;
            edge = edge.getNext();
        }

        answer = new int[count];
        count = 0;
        edge = (Edge<E>) vertices[vertex].getList();
        while (edge != null) {
            answer[count++] = edge.getVertex();
            edge = edge.getNext();
        }
        return answer;
    }

    /*
     * private void recursiveDepthFirstTraversal(int vertex)
     * Helper method to recursively traverse a Graph and write the label of each visited vertex using
     * System.out.println().
     * @param vertex
     *  The starting vertex of this recursive Graph traversal.
     * @postcondition
     *  Each vertex has been visited by this Graph traversal if an edge existed between the source vertex and a target
     *  vertex and the label of each vertex has been written using System.out.println().
     */
    private void recursiveDepthFirstTraversal(int vertex) {
        int[] neighbors;

        if (visited[vertex]) { return; } // Stop if already visited.

        visited[vertex] = true;
        System.out.println("Visited " + getLabel(vertex));

        neighbors = neighbors(vertex);
        for (int neighbor : neighbors) { recursiveDepthFirstTraversal(neighbor); }
    }

    /**
     * public removeEdge(int source, int target)
     * Mutator method that removes the edge (if one exists) between the source and target vertices. If there is no edge
     * then no work is performed.
     * @param source
     *  A reference to the source vertex.
     * @param target
     *  A reference to the target vertex. Note that the target vertex can be a null reference. Our implementation
     *  suppresses warnings because our programming ensures that the list is of type E.
     * @precondition
     *  The reference to the source vertex is a non-null reference.
     * @postcondition
     *  The edge (if it existed) has been removed and the source and target vertices are no longer connected.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates that the source and/or target were not valid vertex numbers.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void removeEdge(int source, int target) {
        Edge<E> previous;
        Edge<E> edge;

        if (!isEdge(source, target)) { return; }

        previous = null;
        edge = (Edge<E>) vertices[source].getList();
        while (edge != null) {
            if (edge.getVertex() == target) {
                if (previous == null) {
                    vertices[source].setList(edge.getNext());
                } else {
                    previous.setNext(edge.getNext());
                }
            }
            previous = edge;
            edge = edge.getNext();
        }
    }

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
    @Override
    @SuppressWarnings("unchecked")
    public void setLabel(int source, E label) { vertices[source].setLabel(label); }

    /**
     * public int[] shortestPath(int vertex)
     * Utility method that determines the shortest path using Dijkstra's algorithm. The shortest path between two
     * vertices is the path with the lowest total cost.
     * @param start
     *  The starting vertex.
     * @precondition
     *  The vertex is non-negative and is less than the size of this Graph.
     * @return int[]
     *  A distance array filled with integers such that for each vertex v, the value of int[v] is the cost of the
     *  shortest path from the starting vertex to v.
     * @exception ArrayIndexOutOfBoundsException
     *  Indicates the the start vertex was not a valid vertex number.
     */
    public int[] shortestPath(int start) {
        boolean done;
        int current;
        int[] distance;
        int[] neighbors;
        boolean[] unvisited;

        distance = new int[vertices.length];
        unvisited = new boolean[vertices.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            unvisited[i] = true;
        }

        current = start;
        distance[current] = 0;

        // Loop until all processable vertices are processed.
        done = false;
        while (!done) {
            neighbors = neighbors(current);

            for (int i = 0; i < neighbors.length; i++) {
                if (unvisited[neighbors[i]]) { // If the vertex is unvisited...
                    int newCost = distance[current] + getCost(current, neighbors[i]); // ...find the cost of the path...
                    if (newCost < distance[neighbors[i]]) { // ...if the current path has a lower cost then...
                        distance[neighbors[i]] = newCost; // ...use the lower cost.
                    }
                }
            }

            unvisited[current] = false; // Mark the current vertex as visited.
            int currentMinimumCost = Integer.MAX_VALUE; // Use as the new lowest cost of the unvisited vertex.

            for (int i = 0; i < distance.length; i++) {
                if (unvisited[i]) {
                    if (distance[i] < currentMinimumCost) {
                        currentMinimumCost = distance[i];
                        current = i;
                    }
                }
            }

            done = true;
            for (int i = 0; i < distance.length; i++) {
                if (unvisited[i] && (distance[i] != Integer.MAX_VALUE)) {
                    // There are unvisited neighbors that we still need to process
                    done = false;
                }
            }
        }
        return distance;
    }

    /**
     * public int size()
     * Accessor method that retrieves the size of this Graph.
     * @return int
     *  The size of this Graph. Note that the size can be 0.
     */
    @Override
    public int size() { return vertices.length; }
}