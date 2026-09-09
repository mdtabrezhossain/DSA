class MaximumSubArraySum {
    int maxSubArray(int[] numbers) {
        int maxSum = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;

            for (int j = i; j < numbers.length; j++) {
                sum += numbers[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    int maxSubArray2(int[] numbers) {
        int maxSum = numbers[0];
        int sum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            sum = Math.max(numbers[i], sum + numbers[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}