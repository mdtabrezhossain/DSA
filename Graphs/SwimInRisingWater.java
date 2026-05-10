class SwimInRisingWater {
    int swimInWater(int[][] grid) {
        int minimumPossibleTime = grid[0][0];
        int maximumPossibleTime = grid[0][0];

        for (int[] row : grid) {
            for (int elevation : row) {
                maximumPossibleTime = Math.max(maximumPossibleTime, elevation);
            }
        }

        int minimumTime = maximumPossibleTime;

        while (minimumPossibleTime <= maximumPossibleTime) {
            int middleTime = minimumPossibleTime + (maximumPossibleTime - minimumPossibleTime) / 2;

            if (canReachDestination(grid, middleTime)) {
                minimumTime = middleTime;
                maximumPossibleTime = middleTime - 1;
            } else {
                minimumPossibleTime = middleTime + 1;
            }
        }

        return minimumTime;
    }

    private boolean canReachDestination(int[][] grid, int waterLevel) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        boolean[][] visited = new boolean[totalRows][totalCols];
        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];

            if (currentRow == totalRows - 1 && currentCol == totalCols - 1) {
                return true;
            }

            for (int[] direction : directions) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (isInsideGrid(nextRow, nextCol, totalRows, totalCols)
                        && !visited[nextRow][nextCol]
                        && grid[nextRow][nextCol] <= waterLevel) {
                    queue.offer(new int[] { nextRow, nextCol });
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return false;
    }

    private boolean isInsideGrid(int row, int col, int totalRows, int totalCols) {
        if (row >= 0 && col >= 0
                && row < totalRows && col < totalCols) {
            return true;
        }

        return false;
    }
}

// Note: a better solution is using the dijkstra's algorithm because the
// question is same as path with minimum effort