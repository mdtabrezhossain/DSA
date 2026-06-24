class PerfectSum {
    private int[][] ways;

    int perfectSum(int[] nums, int target) {
        ways = new int[nums.length][target + 1];

        for (int[] row : ways) {
            Arrays.fill(row, -1);
        }

        return countSubsets(nums.length - 1, target, nums);
    }

    private int countSubsets(int i, int sum, int[] numbers) {
        if (i < 0) {
            if (sum == 0) {
                return 1;
            }

            return 0;
        }

        if (ways[i][sum] != -1) {
            return ways[i][sum];
        }

        int current = numbers[i];
        int take = 0;

        if (current <= sum) {
            take = countSubsets(i - 1, sum - current, numbers);
        }

        int skip = countSubsets(i - 1, sum, numbers);

        return ways[i][sum] = take + skip;
    }

    int perfectSum2(int[] numbers, int sum) {
        ways = new int[numbers.length][sum + 1];

        ways[0][0] = (numbers[0] == 0) ? 2 : 1;

        if (numbers[0] != 0 && numbers[0] == sum) {
            ways[0][numbers[0]] = 1;
        }

        for (int i = 1; i < numbers.length; i++) {
            for (int s = 1; s <= sum; s++) {
                int current = numbers[i];
                int take = 0;

                if (current <= s) {
                    take = ways[i - 1][s - current];
                }

                int skip = ways[i - 1][s];

                ways[i][s] = take + skip;
            }
        }

        return ways[numbers.length - 1][sum];
    }
}
