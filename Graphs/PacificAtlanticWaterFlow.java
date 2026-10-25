import java.util.*;

class PacificAtlanticWaterFlow {
    int[][] grid;
    int m;
    int n;

    int[][] directions = {
            { 0, -1 },
            { 0, 1 },
            { -1, 0 },
            { 1, 0 }
    };

    List<List<Integer>> pacificAtlantic(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            pacificQueue.offer(new int[] { row, 0 });
            toPacific[row][0] = true;

            atlanticQueue.offer(new int[] { row, n - 1 });
            toAtlantic[row][n - 1] = true;
        }

        for (int col = 0; col < n; col++) {
            pacificQueue.offer(new int[] { 0, col });
            toPacific[0][col] = true;

            atlanticQueue.offer(new int[] { m - 1, col });
            toAtlantic[m - 1][col] = true;
        }

        checkFlow(pacificQueue, toPacific);
        checkFlow(atlanticQueue, toAtlantic);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (toPacific[i][j] && toAtlantic[i][j])
                    result.add(Arrays.asList(i, j));

        return result;
    }

    void checkFlow(Queue<int[]> queue, boolean[][] canFlow) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol)
                        && !canFlow[newRow][newCol]
                        && grid[newRow][newCol] >= grid[row][col]) {
                    queue.offer(new int[] { newRow, newCol });
                    canFlow[newRow][newCol] = true;
                }
            }
        }
    }

    boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}