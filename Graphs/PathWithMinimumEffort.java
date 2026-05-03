class PathWithMinimumEffort {
    int minimumEffortPath(int[][] heights) {
        int totalRows = heights.length;
        int totalCols = heights[0].length;

        int[][] effortGrid = new int[totalRows][totalCols];
        for (int i = 0; i < totalRows; i++) {
            Arrays.fill(effortGrid[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(cell -> cell[2]));

        effortGrid[0][0] = 0;
        minHeap.offer(new int[] { 0, 0, 0 });

        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentEffort = current[2];

            if (currentEffort > effortGrid[currentRow][currentCol]) {
                continue;
            }

            if (currentRow == totalRows - 1 && currentCol == totalCols - 1) {
                return currentEffort;
            }

            for (int[] direction : directions) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (isInsideGrid(nextRow, nextCol, totalRows, totalCols)) {
                    int heightDifference = Math.abs(
                            heights[currentRow][currentCol] - heights[nextRow][nextCol]);

                    int nextEffort = Math.max(currentEffort, heightDifference);

                    if (nextEffort < effortGrid[nextRow][nextCol]) {
                        effortGrid[nextRow][nextCol] = nextEffort;
                        minHeap.offer(new int[] { nextRow, nextCol, nextEffort });
                    }
                }
            }
        }

        return effortGrid[totalRows - 1][totalCols - 1];
    }

    private boolean isInsideGrid(int row, int col, int totalRows, int totalCols) {
        if (row >= 0 && col >= 0
                && row < totalRows && col < totalCols) {
            return true;
        }

        return false;
    }
}