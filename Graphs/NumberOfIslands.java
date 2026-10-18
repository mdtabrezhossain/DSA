class NumberOfIslands {
    int m;
    int n;
    char[][] grid;

    boolean[][] visited;

    int[][] directions = {
            { 0, -1 },
            { 0, 1 },
            { -1, 0 },
            { 1, 0 }
    };

    int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        int result = 0;

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++)
                if (grid[row][col] == '1' && !visited[row][col]) {
                    exploreIsland(row, col);
                    result++;
                }

        return result;
    }

    void exploreIsland(int row, int col) {
        if (grid[row][col] == '0')
            return;

        visited[row][col] = true;

        for (int[] direction : directions) {
            int i = row + direction[0];
            int j = col + direction[1];

            if (isValidLocation(i, j) && !visited[i][j])
                exploreIsland(i, j);
        }
    }

    boolean isValidLocation(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}