class AdjacencyList {
    List<List<Integer>> createGraph(int vertices, int edges[][]) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 1; i <= vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int source = e[0];
            int destination = e[1];

            if (!adjacencyList.get(source).contains(destination)) {
                adjacencyList.get(source).add(destination);
            }

            if (!adjacencyList.get(destination).contains(source)) {
                adjacencyList.get(destination).add(source);
            }
        }

        return adjacencyList;
    }
}