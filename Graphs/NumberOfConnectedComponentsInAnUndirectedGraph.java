class NumberOfConnectedComponentsInAnUndirectedGraph {
    int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = createAdjacencyList(n, edges);

        int result = 0;
        boolean[] visited = new boolean[n];

        for (int node = 0; node < n; node++)
            if (!visited[node]) {
                dfs(node, visited, list);
                result++;
            }

        return result;
    }

    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> list) {
        visited[node] = true;
        ArrayList<Integer> neighbors = list.get(node);

        for (int neighbor : neighbors)
            if (!visited[neighbor])
                dfs(neighbor, visited, list);
    }

    ArrayList<ArrayList<Integer>> createAdjacencyList(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            list.get(source).add(destination);
            list.get(destination).add(source);
        }

        return list;
    }
}
