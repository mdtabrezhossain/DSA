class GraphCycleDirected {
    boolean isCyclic(int totalVertices, int[][] edges) {
        boolean[] isVisited = new boolean[totalVertices];
        boolean[] isInPath = new boolean[totalVertices];
        ArrayList<ArrayList<Integer>> graph = createDirectedGraph(totalVertices, edges);

        for (int v = 0; v < totalVertices; v++) {
            if (dfsDetectCycle(v, isVisited, isInPath, graph)) {
                return true;
            }
        }

        return false;
    }

    ArrayList<ArrayList<Integer>> createDirectedGraph(int totalVertices, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int v = 0; v < totalVertices; v++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        return graph;
    }

    boolean dfsDetectCycle(int current, boolean[] isVisited, boolean[] isInPath, ArrayList<ArrayList<Integer>> graph) {
        isVisited[current] = true;
        isInPath[current] = true;
        ArrayList<Integer> neighbours = graph.get(current);

        for (int neighbour : neighbours) {
            if (isVisited[neighbour]) {
                if (isInPath[neighbour]) {
                    return true;
                }
            } else if (dfsDetectCycle(neighbour, isVisited, isInPath, graph)) {
                return true;
            }
        }

        isInPath[current] = false;
        return false;
    }
}