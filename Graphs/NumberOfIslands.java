class NumberOfIslands {
    int numIslands(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int totalIslands = 0;

        for (int row = 0; row <= grid.length - 1; row++) {
            for (int col = 0; col <= grid[0].length - 1; col++) {
                if (grid[row][col] == '1' && !isVisited[row][col]) {
                    dfs(row, col, isVisited, grid);
                    totalIslands++;
                }
            }
        }

        return totalIslands;
    }

    void dfs(int row, int col, boolean[][] isVisited, char[][] grid) {
        if (row < 0 || col < 0
                || row >= grid.length || col >= grid[0].length
                || isVisited[row][col]
                || grid[row][col] == '0') {
            return;
        }

        isVisited[row][col] = true;

        dfs(row - 1, col, isVisited, grid);
        dfs(row + 1, col, isVisited, grid);
        dfs(row, col - 1, isVisited, grid);
        dfs(row, col + 1, isVisited, grid);
    }
}