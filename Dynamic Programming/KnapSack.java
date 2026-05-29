class KnapSack {
    int knapsack(int capacity, int values[], int weights[]) {
        int[][] memo = new int[values.length][capacity + 1];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(0, capacity, values, weights, memo);
    }

    private int helper(int i, int capacity, int values[], int weights[], int[][] memo) {
        if (i == values.length || capacity == 0) {
            return 0;
        }

        if (memo[i][capacity] != -1) {
            return memo[i][capacity];
        }

        int take = 0;

        if (weights[i] <= capacity) {
            take = values[i] + helper(i + 1, capacity - weights[i], values, weights, memo);
        }

        int skip = helper(i + 1, capacity, values, weights, memo);

        memo[i][capacity] = Math.max(take, skip);

        return memo[i][capacity];
    }
}