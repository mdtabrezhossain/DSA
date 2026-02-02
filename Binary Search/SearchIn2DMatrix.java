class SearchIn2DMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int row = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] == target) {
                return true;
            }

            else if (matrix[mid][0] < target) {
                row = mid;
                low = mid + 1;
            }

            else if (matrix[mid][0] > target) {
                high = mid - 1;
            }

        }

        if (row == -1) {
            return false;
        }

        low = 0;
        high = matrix[row].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }

            else if (matrix[row][mid] < target) {
                low = mid + 1;
            }

            else if (matrix[row][mid] > target) {
                high = mid - 1;
            }

        }

        return false;
    }

    static boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
