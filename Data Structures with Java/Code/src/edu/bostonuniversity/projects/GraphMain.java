package edu.bostonuniversity.projects;

import edu.bostonuniversity.graphs.Graph;

public class GraphMain {
    public static void main(String[] args) {
        GraphMain graph = new GraphMain();
        graph.start();
    }

    public void start() {
        Graph<String> graph = new Graph<>(7);
        int[][] matrix = {{0, 5, 2, -1, -1, 5, -1},
                {-1, 0, -1, -1, 2, 4, -1},
                {-1, -1, -1, -1, 3, -1, -1},
                {-1, -1, 3, -1, -1, -1, 4},
                {-1, -1, -1, -1, 0, -1, 2},
                {-1, -1, -1, -1, -1, 0, 3},
                {-1, -1, -1, -1, -1, -1, 0}};

        for (int i = 0; i < matrix.length; i++) {
            graph.shortestPath(i);
        }


        graph.setDistance(matrix);
        //graph.shortestPath(0);
        graph.test();
    }
}
