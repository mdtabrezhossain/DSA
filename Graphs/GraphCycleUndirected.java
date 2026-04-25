class GraphCycleUndirected {
    boolean isCycle(int totalVertices, int[][] edges) {
        boolean[] isVisited = new boolean[totalVertices];
        ArrayList<ArrayList<Integer>> adjacencyList = createGraph(totalVertices, edges);

        for (int i = 0; i <= totalVertices - 1; i++) {
            if (!isVisited[i]) {
                if (dfsDetectCycle(i, -1, isVisited, adjacencyList)) {
                    return true;
                }
            }
        }

        return false;
    }

    ArrayList<ArrayList<Integer>> createGraph(int totalVertices, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 1; i <= totalVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        return adjacencyList;
    }

    boolean dfsDetectCycle(int current, int parent, boolean[] isVisited,
            ArrayList<ArrayList<Integer>> graph) {
        isVisited[current] = true;
        ArrayList<Integer> neighbours = graph.get(current);

        for (int neighbour : neighbours) {
            if (isVisited[neighbour]) {
                if (neighbour != parent) {
                    return true;
                }
            } else if (dfsDetectCycle(neighbour, current, isVisited, graph)) {
                return true;
            }
        }

        return false;
    }
}