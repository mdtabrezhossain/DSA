class IslandsAndTreasure {
    int[][] grid;
    int m;
    int n;

    int[][] directions = {
            { 0, -1 },
            { 0, 1 },
            { -1, 0 },
            { 1, 0 }
    };

    Queue<int[]> queue;

    void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                if (grid[row][col] == Integer.MAX_VALUE) {
                    visited = new boolean[m][n];
                    grid[row][col] = findNearestTreasure(row, col);
                }
    }

    int findNearestTreasure(int row, int col) {
        int distance = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { row, col });
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                row = location[0];
                col = location[1];

                if (grid[row][col] == 0)
                    return distance;

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (isValidLocation(newRow, newCol)
                            && grid[newRow][newCol] != -1
                            && !visited[newRow][newCol]) {
                        queue.offer(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;

                    }
                }
            }

            distance++;
        }

        return Integer.MAX_VALUE;
    }

    void islandsAndTreasure2(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        queue = new LinkedList<>();

        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                if (grid[row][col] == 0)
                    queue.add(new int[] { row, col });

        spreadTreasure();
    }

    void spreadTreasure() {
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int row = location[0];
            int col = location[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValidLocation(newRow, newCol) && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }
    }

    void spreadTreasure2() {
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                int row = location[0];
                int col = location[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (isValidLocation(newRow, newCol) && grid[newRow][newCol] == Integer.MAX_VALUE) {
                        grid[newRow][newCol] = distance;
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }
        }
    }

    boolean isValidLocation(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}
