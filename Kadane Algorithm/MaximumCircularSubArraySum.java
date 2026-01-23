class MaximumCircularSubArraySum {
    static int getMaxSubArraySumCircular(int[] array) {
        int totalSum = array[0];

        int maxSum = array[0];
        int minSum = array[0];

        int localMaxSum = array[0];
        int localMinSum = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            int currentValue = array[i];
            totalSum += currentValue;

            localMaxSum = Math.max(currentValue, localMaxSum + currentValue);
            maxSum = Math.max(maxSum, localMaxSum);

            localMinSum = Math.min(currentValue, localMinSum + currentValue);
            minSum = Math.min(minSum, localMinSum);
        }

        /*
         * If all numbers are negative,
         * then minSum will be equal to totalSum
         * and totalSum - minSum will be zero which is invalid, empty sub-array
         * So we must return maxSum in that case.
         */
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
