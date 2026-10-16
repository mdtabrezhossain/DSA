class NQueens {
    List<List<String>> result;
    char[][] board;

    List<List<String>> solveNQueens(int n) {
        board = new char[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        result = new ArrayList<>();
        helper(0);

        return result;
    }

    void helper(int row) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < board.length; i++)
                list.add(new String(board[i]));

            result.add(list);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q';

                helper(row + 1);

                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col) {
        // Check upper
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check upper-left
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;

            i--;
            j--;
        }

        // Check upper-right
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q')
                return false;

            i--;
            j++;
        }

        return true;
    }
}