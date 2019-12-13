// File Graph.java from the package edu.bostonuniversity.graphs

package edu.bostonuniversity.graphs;

public class Graph<E> {
    // Invariant of the Graph.java class
    //  1. The instance variable adjacencyMatrix determines whether or not an edge exists between two vertices.
    //  2. The instance variable distance stores the total weight from a start vertex to the target vertex.
    //  3. The instance variable predecessor stores a reference to the previous node relative to the target node.
    private boolean[] allowedVertices;
    private int[] cost;
    private int[][] distance;
    private int[] predecessor;

    /**
     * public Graph(int n)
     * Initialize an empty graph with an nxn adjacency matrix.
     * @param n
     *  The number of rows and columns in the adjacency matrix.
     * @precondition
     *  n is a positive integer.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new Graph.
     */
    public Graph(int n) {
        distance = new int[n][n];
        cost = new int[n];
        allowedVertices = new boolean[n];
        predecessor = new int[n];
        for (int i = 1; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
    }

    public int[] neighbors(int vertex) {
        int i;
        int count;
        int[] answer;

        count = 0;
        for (i = 0; i < cost.length; i++) {
            if (distance[vertex][i] > 0) {
                count++;
            }
        }

        answer = new int[count];
        count = 0;
        for (i = 0; i < cost.length; i++) {
            if (distance[vertex][i] > 0) {
                answer[count++] = i;
            }
        }
        return answer;
    }

    public void setDistance(int[][] distance) { this.distance = distance; }

    public void shortestPath(int vertex) {
        int tmp = -1;
        int minimumValue = Integer.MAX_VALUE;
        int[] neighbors = neighbors(vertex);
        allowedVertices[vertex] = true;
        for (int i = 0; i < neighbors.length; i++) {
            if (!allowedVertices[i]) {
                if (distance[vertex][i] < minimumValue) {
                    tmp = i;
                    minimumValue = distance[vertex][i];
                    cost[i] = distance[vertex][i];
                    predecessor[i] = vertex;
                }
            }
        }
        allowedVertices[tmp] = true;
    }

    public void test() {
        for (int i = 0; i < cost.length; i++) {
            System.out.println(cost[i]);
        }
    }
}
