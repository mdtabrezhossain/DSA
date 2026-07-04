class UniquePaths {
    private int[][] ways;

    public int uniquePaths(int m, int n) {
        ways = new int[m][n];

        for (int[] row : ways) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (ways[i][j] != -1) {
            return ways[i][j];
        }

        int goRight = helper(i, j + 1, m, n);
        int goDown = helper(i + 1, j, m, n);

        return ways[i][j] = goRight + goDown;
    }

    int uniquePaths2(int m, int n) {
        int[][] ways = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    ways[i][j] = 1;
                } else {
                    int goRight = ways[i][j + 1];
                    int goDown = ways[i + 1][j];

                    ways[i][j] = goRight + goDown;
                }
            }
        }

        return ways[0][0];
    }
}