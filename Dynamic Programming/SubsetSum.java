class SubsetSum {
    private Boolean[][] memo;

    Boolean isSubsetSum(int[] numbers, int sum) {
        memo = new Boolean[numbers.length][sum + 1];
        return helper(0, sum, numbers);
    }

    private boolean helper(int i, int remainingSum, int[] numbers) {
        if (remainingSum == 0)
            return true;
        if (i == numbers.length)
            return false;

        if (memo[i][remainingSum] != null) {
            return memo[i][remainingSum];
        }

        boolean result;

        if (numbers[i] > remainingSum) {
            result = helper(i + 1, remainingSum, numbers);
        } else {
            result = helper(i + 1, remainingSum - numbers[i], numbers)
                    || helper(i + 1, remainingSum, numbers);
        }

        return memo[i][remainingSum] = result;
    }

    Boolean isSubsetSum2(int[] numbers, int sum) {
        Boolean[][] memo = new Boolean[numbers.length + 1][sum + 1];

        memo[numbers.length][0] = true;

        for (int s = 1; s <= sum; s++) {
            memo[numbers.length][s] = false;
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            for (int j = 0; j <= sum; j++) {
                int current = numbers[i];

                if (current > j) {
                    memo[i][j] = memo[i + 1][j];
                } else {
                    memo[i][j] = memo[i + 1][j] || memo[i + 1][j - current];
                }
            }
        }

        return memo[0][sum];
    }
}
