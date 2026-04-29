class TopologicalSort {
    ArrayList<Integer> topoSort(int totalVertices, int[][] edges) {
        ArrayList<Integer> inDegreeList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = createGraph(totalVertices, edges, inDegreeList);

        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < totalVertices; v++) {
            if (inDegreeList.get(v) == 0) {
                queue.offer(v);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();

            resultList.add(v);
            ArrayList<Integer> neighboursList = graph.get(v);

            for (int neighbour : neighboursList) {
                int inDegree = inDegreeList.get(neighbour);
                inDegree--;
                inDegreeList.set(neighbour, inDegree);

                if (inDegree == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return resultList;
    }

    ArrayList<ArrayList<Integer>> createGraph(int totalVertices, int[][] edges, ArrayList<Integer> inDegreeList) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int v = 0; v < totalVertices; v++) {
            graph.add(new ArrayList<>());
            inDegreeList.add(0);
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            graph.get(source).add(destination);

            int inDegree = inDegreeList.get(destination);
            inDegree++;
            inDegreeList.set(destination, inDegree);
        }

        return graph;
    }
}