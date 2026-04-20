class BFSUndirectedConnected {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVertexVisited = new boolean[adjacencyList.size()];

        int vertex = 0;
        queue.offer(vertex);
        isVertexVisited[vertex] = true;

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            resultList.add(vertex);
            ArrayList<Integer> neighbourList = adjacencyList.get(vertex);

            for (Integer neighbour : neighbourList) {
                if (!isVertexVisited[neighbour]) {
                    queue.offer(neighbour);
                    isVertexVisited[neighbour] = true;
                }
            }
        }

        return resultList;
    }
}