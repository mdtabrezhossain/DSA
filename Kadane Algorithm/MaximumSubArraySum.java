class MaximumSubArraySum {

    static int getMaxSubArraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        /*
         * At each index, decide whether to start a new subarray or extend the previous
         * one.
         */
        for (int i = 0; i <= array.length - 1; i++) {
            currentSum += array[i];
            maxSum = Math.max(currentSum, maxSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
