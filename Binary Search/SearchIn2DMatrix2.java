class SearchIn2DMatrix2 {
    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1;
        int j = 0;

        while (i >= 0 && j < cols) {
            int element = matrix[i][j];

            if (element == target) {
                return true;
            } else if (element < target) {
                j++;
            } else if (element > target) {
                i--;
            }
        }

        return false;
    }
}