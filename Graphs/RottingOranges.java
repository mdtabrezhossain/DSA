import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOrangesQueue = new LinkedList<>();
        int totalFreshOranges = 0;
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        for (int row = 0; row <= totalRows - 1; row++) {
            for (int col = 0; col <= totalCols - 1; col++) {
                int element = grid[row][col];

                if (element == 2) {
                    int[] coordinates = { row, col };
                    rottenOrangesQueue.offer(coordinates);
                    grid[row][col] = 0;
                } else if (element == 1) {
                    totalFreshOranges++;
                }
            }
        }

        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        int minutes = 0;

        while (!rottenOrangesQueue.isEmpty() && totalFreshOranges > 0) {
            minutes++;

            int queueSize = rottenOrangesQueue.size();

            while (queueSize > 0) {
                int[] coordinates = rottenOrangesQueue.poll();
                int row = coordinates[0];
                int col = coordinates[1];

                for (int i = 0; i <= directions.length - 1; i++) {
                    int newRow = row + directions[i][0];
                    int newCol = col + directions[i][1];

                    if (isValidDirection(newRow, newCol, grid) && grid[newRow][newCol] == 1) {
                        int[] freshOrangeCoordinates = { newRow, newCol };
                        rottenOrangesQueue.offer(freshOrangeCoordinates);

                        grid[newRow][newCol] = 0;
                        totalFreshOranges--;
                    }
                }

                queueSize--;
            }
        }

        if (totalFreshOranges > 0) {
            return -1;
        }

        return minutes;
    }

    boolean isValidDirection(int row, int col, int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        if (row < 0 || col < 0
                || row > totalRows - 1 || col > totalCols - 1) {
            return false;
        }

        return true;
    }
}