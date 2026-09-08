class Solution {
    boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(i, j, 0, new boolean[board.length][board[0].length], board, word))
                    return true;
            }
        }

        return false;
    }

    boolean helper(int i, int j, int k, boolean[][] visited, char[][] board, String word) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;

        if (visited[i][j])
            return false;

        if (board[i][j] != word.charAt(k))
            return false;

        if (k == word.length() - 1)
            return true;

        visited[i][j] = true;

        boolean found = helper(i + 1, j, k + 1, visited, board, word)
                || helper(i - 1, j, k + 1, visited, board, word)
                || helper(i, j - 1, k + 1, visited, board, word)
                || helper(i, j + 1, k + 1, visited, board, word);

        visited[i][j] = false;

        return found;
    }
}