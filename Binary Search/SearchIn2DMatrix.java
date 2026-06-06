class SearchIn2DMatrix {
    boolean searchMatrix(int[][] matrix, int target) {
        int isFound = -1;

        for (int[] row : matrix) {
            isFound = search(row, target);

            if (isFound != -1) {
                return true;
            }
        }

        return isFound != -1;
    }

    boolean searchMatrix2(int[][] matrix, int target) {
        int row = findRow(matrix, target);

        if (row == -1) {
            return false;
        }

        return searchInRow(matrix[row], target);
    }

    static boolean searchMatrix3(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    private int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    int findRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int row = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                row = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return row;
    }

    boolean searchInRow(int[] row, int target) {
        int start = 0;
        int end = row.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
