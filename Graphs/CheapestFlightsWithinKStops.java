import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int source, int destination, int k) {
        ArrayList<ArrayList<int[]>> graph = createGraph(n, flights);

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { source, 0, 0 });

        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int currentVertex = item[0];
            int currentDistance = item[1];
            int stopsTaken = item[2];

            if (stopsTaken > k) {
                continue;
            }

            ArrayList<int[]> neighbours = graph.get(currentVertex);

            for (int[] neighbour : neighbours) {
                int neighbourVertex = neighbour[0];
                int neighbourDistance = neighbour[1];

                int newDistance = currentDistance + neighbourDistance;

                if (newDistance < distances[neighbourVertex]) {
                    distances[neighbourVertex] = newDistance;
                    queue.offer(new int[] { neighbourVertex, newDistance, stopsTaken + 1 });
                }
            }
        }

        return distances[destination] == Integer.MAX_VALUE ? -1 : distances[destination];
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
        }

        return graph;
    }
}