class MinimumSubArraySum {

    static int getMinSubArraySum(int array[], int size) {
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int i = 0; i <= array.length - 1; i++) {
            currentSum += array[i];
            minSum = Math.min(currentSum, minSum);

            if (currentSum > 0) {
                currentSum = 0;
            }
        }

        return minSum;
    }
}