class Solution {
    public int[] dijkstra(int totalVertices, int[][] edges, int source) {
        int[] vertexDistances = new int[totalVertices];
        for (int i = 0; i < totalVertices; i++) {
            vertexDistances[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (pair1, pair2) -> Integer.compare(pair1[1], pair2[1]));

        vertexDistances[source] = 0;
        minHeap.add(new int[] { source, 0 });

        ArrayList<ArrayList<int[]>> graph = createUndirectedWeightedGraph(totalVertices, edges);

        while (!minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int currentVertex = pair[0];
            int currentDistance = pair[1];

            if (currentDistance <= vertexDistances[currentVertex]) {
                ArrayList<int[]> neighboursList = graph.get(currentVertex);
                for (int[] neighbourPair : neighboursList) {
                    int neighbour = neighbourPair[0];
                    int edgeDistance = neighbourPair[1];

                    if (currentDistance + edgeDistance < vertexDistances[neighbour]) {
                        int newDistance = currentDistance + edgeDistance;
                        vertexDistances[neighbour] = newDistance;
                        minHeap.add(new int[] { neighbour, newDistance });
                    }
                }
            }
        }

        return vertexDistances;
    }

    ArrayList<ArrayList<int[]>> createUndirectedWeightedGraph(int totalVertices, int[][] edges) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < totalVertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int distance = edge[2];

            graph.get(source).add(new int[] { destination, distance });
            graph.get(destination).add(new int[] { source, distance });
        }

        return graph;
    }
}
