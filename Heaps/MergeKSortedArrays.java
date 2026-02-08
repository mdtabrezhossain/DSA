import java.util.ArrayList;
import java.util.PriorityQueue;

class MergeKSortedArrays {
    public ArrayList<Integer> mergeArrays(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value));

        for (int i = 0; i <= matrix.length - 1; i++) {
            minHeap.offer(new Node(matrix[i][0], i, 0));
        }

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result.add(node.value);

            int nextCol = node.column + 1;

            if (nextCol <= matrix[node.row].length - 1) {
                minHeap.offer(
                        new Node(matrix[node.row][nextCol],
                                node.row,
                                nextCol));
            }
        }

        return result;
    }

    static class Node {
        int value;
        int row;
        int column;

        Node(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }
}
