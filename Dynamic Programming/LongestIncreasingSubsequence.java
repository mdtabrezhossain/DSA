class LongestIncreasingSubsequence {
    private int[][] memo;

    int lengthOfLIS(int[] nums) {
        memo = new int[nums.length][nums.length + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return helper(0, -1, nums);
    }

    private int helper(int idx, int prevIdx, int[] nums) {
        if (idx == nums.length) {
            return 0;
        }

        if (memo[idx][prevIdx + 1] != -1) {
            return memo[idx][prevIdx + 1];
        }

        int take = 0;

        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + helper(idx + 1, idx, nums);
        }

        int skip = helper(idx + 1, prevIdx, nums);

        return memo[idx][prevIdx + 1] = Math.max(take, skip);
    }

    int lengthOfLIS2(int[] numbers) {
        int[] memo = new int[numbers.length];
        int result = 1;

        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;

            for (int j = 0; j < i; j++) {
                int current = numbers[i];
                int previous = numbers[j];

                if (current > previous) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    result = Math.max(result, memo[i]);
                }
            }
        }

        return result;
    }
}