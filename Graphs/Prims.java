class Prims {
    int getMinimumSpanningTreeCost(int totalVertices, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = createGraph(totalVertices, edges);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] isVisited = new boolean[totalVertices];
        int totalCost = 0;

        minHeap.offer(new int[] { 0, 0 });

        while (!minHeap.isEmpty()) {
            int[] item = minHeap.poll();
            int vertex = item[0];
            int cost = item[1];

            if (isVisited[vertex]) {
                continue;
            }

            isVisited[vertex] = true;
            totalCost += cost;

            ArrayList<int[]> neighbours = graph.get(vertex);

            for (int[] neighbour : neighbours) {

                int nextVertex = neighbour[0];
                int nextCost = neighbour[1];

                if (!isVisited[nextVertex]) {
                    minHeap.offer(new int[] { nextVertex, nextCost });
                }
            }
        }

        return totalCost;
    }

    private ArrayList<ArrayList<int[]>> createGraph(int totalVertices, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int v = 0; v < totalVertices; v++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int source = edge[0];
            int destination = edge[1];
            int cost = edge[2];

            graph.get(source).add(new int[] { destination, cost });
            graph.get(destination).add(new int[] { source, cost });
        }

        return graph;
    }
}