class RedundantConnection {
    ArrayList<ArrayList<Integer>> graph;
    int cycleStart;
    Set<Integer> inCycle;

    int[] findRedundantConnection(int[][] edges) {
        graph = createGraph(edges);
        cycleStart = -1;
        inCycle = new HashSet<>();

        hasCycle(1, -1, new boolean[edges.length + 1]);

        for (int i = edges.length - 1; i >= 0; i--) {
            int source = edges[i][0];
            int destination = edges[i][1];

            if (inCycle.contains(source) && inCycle.contains(destination))
                return new int[] { source, destination };
        }

        return null;
    }

    boolean hasCycle(int current, int parent, boolean[] visited) {
        if (visited[current]) {
            cycleStart = current;
            return true;
        }

        visited[current] = true;

        ArrayList<Integer> neighbors = graph.get(current);

        for (int neighbor : neighbors) {
            if (neighbor == parent)
                continue;

            if (hasCycle(neighbor, current, visited)) {
                if (cycleStart != -1)
                    inCycle.add(current);

                if (current == cycleStart)
                    cycleStart = -1;

                return true;
            }
        }

        return false;
    }

    ArrayList<ArrayList<Integer>> createGraph(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= edges.length; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        return graph;
    }
}
