class KnapSack {
    int knapsack(int capacity, int values[], int weights[]) {
        int[][] memo = new int[values.length][capacity + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
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

    int knapsack2(int capacity, int values[], int weights[]) {
        int[][] memo = new int[values.length + 1][capacity + 1];

        for (int i = values.length - 1; i >= 0; i--) {
            int value = values[i];
            int weight = weights[i];

            for (int c = 0; c <= capacity; c++) {
                if (c < weight) {
                    int skip = memo[i + 1][c];
                    memo[i][c] = skip;
                } else {
                    int skip = memo[i + 1][c];
                    int take = value + memo[i + 1][c - weight];

                    memo[i][c] = Math.max(take, skip);
                }
            }
        }

        return memo[0][capacity];
    }
}