class SurroundedRegions {
    int m;
    int n;
    char[][] board;

    Queue<int[]> queue;

    int[][] directions = {
            { 0, -1 },
            { 0, 1 },
            { -1, 0 },
            { 1, 0 }
    };

    void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        queue = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') {
                queue.offer(new int[] { row, 0 });
                board[row][0] = '$';
            }

            if (board[row][n - 1] == 'O') {
                queue.offer(new int[] { row, n - 1 });
                board[row][n - 1] = '$';
            }
        }

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                queue.offer(new int[] { 0, col });
                board[0][col] = '$';
            }

            if (board[m - 1][col] == 'O') {
                queue.offer(new int[] { m - 1, col });
                board[m - 1][col] = '$';
            }
        }

        helper();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';

                if (board[row][col] == '$')
                    board[row][col] = 'O';
            }
        }
    }

    void helper() {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol) && board[newRow][newCol] == 'O') {
                    queue.offer(new int[] { newRow, newCol });
                    board[newRow][newCol] = '$';
                }
            }
        }
    }

    boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}