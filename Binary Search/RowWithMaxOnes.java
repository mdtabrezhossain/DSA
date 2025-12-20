class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1 },
        };

        // // Approach 1 ---
        // int maxCount = Integer.MIN_VALUE;
        // int rowWithMaxOne = -1;

        // for (int row = 0; row <= matrix.length - 1; row++) {
        // int count = 0;

        // for (int column = 0; column < matrix[row].length; column++) {
        // if (matrix[row][column] == 1) {
        // count++;
        // }
        // }

        // if (count > maxCount) {
        // maxCount = count;
        // rowWithMaxOne = row;
        // }
        // }

        // System.out.println("The row with maximum 1's: " + rowWithMaxOne);

        // Approach 2 ---
        int maxCount = Integer.MIN_VALUE;
        int rowWithMaxOne = -1;

        for (int row = 0; row <= matrix.length - 1; row++) {
            int index = getLowerBound(matrix[row], 1);
            int count = matrix[row].length - index;

            if (count > maxCount) {
                maxCount = count;
                rowWithMaxOne = row;
            }
        }

        System.out.println("The row with maximum 1's: " + rowWithMaxOne);
    }

    // Note: lowerbound => smallest at index such that array[i] >= target.
    static int getLowerBound(int[] array, int target) {
        int index = array.length;
        int high = array.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}