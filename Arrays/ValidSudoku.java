import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    static boolean isValidSudoku(char[][] board) {

        for (int row = 0; row <= 8; row++) {
            HashSet<Character> set = new HashSet<>();

            for (int col = 0; col <= 8; col++) {
                char element = board[row][col];

                if (element == '.') {
                    continue;
                } else if (!set.add(element)) {
                    return false;
                } else {
                    set.add(element);
                }
            }
        }

        for (int col = 0; col <= 8; col++) {
            HashSet<Character> set = new HashSet<>();

            for (int row = 0; row <= 8; row++) {
                char element = board[row][col];

                if (element == '.') {
                    continue;
                } else if (!set.add(element)) {
                    return false;
                } else {
                    set.add(element);
                }
            }
        }

        for (int rowStart = 0; rowStart <= 8; rowStart += 3) {
            int rowEnd = rowStart + 2;

            for (int colStart = 0; colStart <= 8; colStart += 3) {
                int colEnd = colStart + 2;
                HashSet<Character> set = new HashSet<>();

                for (int i = rowStart; i <= rowEnd; i++) {

                    for (int j = colStart; j <= colEnd; j++) {
                        char element = board[i][j];

                        if (element == '.') {
                            continue;
                        } else if (!set.add(element)) {
                            return false;
                        } else {
                            set.add(element);
                        }
                    }
                }
            }
        }

        return true;
    }

    static boolean isValidSudoku2(char[][] board) {
        Set<Character>[] rowSets = new HashSet[9];
        Set<Character>[] colSets = new HashSet[9];
        Set<Character>[] subBoxSets = new HashSet[9];

        for (int i = 0; i <= 8; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            subBoxSets[i] = new HashSet<>();
        }

        for (int row = 0; row <= 8; row++) {
            for (int col = 0; col <= 8; col++) {
                char element = board[row][col];

                if (element != '.') {
                    int subBoxIdx = (row / 3) * 3 + (col / 3);

                    if (rowSets[row].contains(element) ||
                            colSets[col].contains(element) ||
                            subBoxSets[subBoxIdx].contains(element)) {
                        return false;
                    }

                    rowSets[row].add(element);
                    colSets[col].add(element);
                    subBoxSets[subBoxIdx].add(element);
                }
            }
        }

        return true;
    }
}