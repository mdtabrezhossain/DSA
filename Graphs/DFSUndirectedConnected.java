class Solution {
    ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> resultList = new ArrayList<>();
        boolean[] isVertexVisited = new boolean[adjacencyList.size()];

        int vertex = 0;
        helper(
                vertex,
                isVertexVisited,
                adjacencyList,
                resultList);

        return resultList;
    }

    void helper(
            int vertex,
            boolean[] isVertexVisited,
            ArrayList<ArrayList<Integer>> adjacencyList,
            ArrayList<Integer> resultList) {

        resultList.add(vertex);
        isVertexVisited[vertex] = true;

        ArrayList<Integer> neighbourList = adjacencyList.get(vertex);

        for (Integer neighbour : neighbourList) {
            if (!isVertexVisited[neighbour]) {
                helper(neighbour, isVertexVisited, adjacencyList, resultList);
            }
        }
    }
}