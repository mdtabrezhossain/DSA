class KthSmallestElementInSortedMatrix {
    static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rows - 1][cols - 1];
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int totalSmallerElements = findTotalSmallerElements(mid, matrix);

            if (totalSmallerElements < k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    static int findTotalSmallerElements(int guess, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < cols) {
            int element = matrix[i][j];

            if (element <= guess) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count;
    }
}