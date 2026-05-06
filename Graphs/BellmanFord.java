class BellmanFord {
    public int[] bellmanFord(int totalVertices, int[][] edges, int src) {
        int INF = 100000000;

        int[] vertexDistances = new int[totalVertices];
        Arrays.fill(vertexDistances, INF);
        vertexDistances[src] = 0;

        for (int i = 0; i < totalVertices - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int source = edges[j][0];
                int destination = edges[j][1];
                int weight = edges[j][2];

                if (vertexDistances[source] != INF &&
                        vertexDistances[source] + weight < vertexDistances[destination]) {

                    vertexDistances[destination] = vertexDistances[source] + weight;
                }
            }
        }

        // Detect negative cycle
        for (int j = 0; j < edges.length; j++) {
            int source = edges[j][0];
            int destination = edges[j][1];
            int weight = edges[j][2];

            if (vertexDistances[source] != INF &&
                    vertexDistances[source] + weight < vertexDistances[destination]) {
                return new int[] { -1 };
            }
        }

        return vertexDistances;
    }
}