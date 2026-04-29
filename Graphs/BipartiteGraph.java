class BipartiteGraph {
    boolean isBipartite(int[][] graph) {
        int totalVertices = graph.length;
        int[] vertexColors = new int[totalVertices];

        for (int v = 0; v < totalVertices; v++) {
            vertexColors[v] = -1;
        }

        for (int v = 0; v < totalVertices; v++) {
            if (vertexColors[v] == -1) {
                if (dfsDetectIsBipartite(v, 1, vertexColors, graph) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfsDetectIsBipartite(int vertex, int color, int[] vertexColors, int[][] graph) {
        vertexColors[vertex] = color;

        int[] neighbors = graph[vertex];
        for (int neighbor : neighbors) {
            if (vertexColors[neighbor] != -1) {
                if (vertexColors[neighbor] == color) {
                    return false;
                }
            } else {
                if (dfsDetectIsBipartite(neighbor, 1 - color, vertexColors, graph) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}