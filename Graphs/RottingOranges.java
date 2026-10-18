class RottingOranges {
    int[][] grid;
    int m;
    int n;

    int freshCount;
    Queue<int[]> rotten;

    int[][] directions = {
            { 0, -1 },
            { 0, 1 },
            { -1, 0 },
            { 1, 0 }
    };

    int orangesRotting(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        freshCount = 0;
        rotten = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    freshCount++;
                } else if (grid[row][col] == 2) {
                    rotten.add(new int[] { row, col });
                }
            }
        }

        return spreadRotting();
    }

    int spreadRotting() {
        int minutes = 0;

        while (!rotten.isEmpty() && freshCount > 0) {
            int rottenCount = rotten.size();

            while (rottenCount > 0) {
                int[] cell = rotten.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (isValid(newRow, newCol) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshCount--;

                        rotten.offer(new int[] { newRow, newCol });
                    }
                }

                rottenCount--;
            }

            minutes++;
        }

        return freshCount > 0 ? -1 : minutes;
    }

    boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}