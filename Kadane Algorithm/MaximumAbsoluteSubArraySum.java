class MaximumAbsoluteSubArraySum {
    static int getMaxAbsoluteSum(int[] nums) {
        return Math.max(
                Math.abs(getMaxSubArraySum(nums)),
                Math.abs(getMinSubArraySum(nums)));
    }

    static int getMaxSubArraySum(int[] array) {
        int localMaxSum = array[0];
        int maxSum = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            int currentValue = array[i];

            localMaxSum = Math.max(localMaxSum + currentValue, currentValue);
            maxSum = Math.max(localMaxSum, maxSum);
        }

        return maxSum;
    }

    static int getMinSubArraySum(int[] array) {
        int localMinSum = array[0];
        int minSum = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            int currentValue = array[i];

            localMinSum = Math.min(localMinSum + currentValue, currentValue);
            minSum = Math.min(localMinSum, minSum);
        }

        return minSum;
    }
}