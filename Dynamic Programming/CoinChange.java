class CoinChange {
    int[] coins;
    int[] results;

    int coinChange(int[] coins, int amount) {
        this.coins = coins;
        results = new int[amount + 1];

        Arrays.fill(results, -1);

        int result = helper(amount);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int helper(int amount) {
        if (amount == 0)
            return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (results[amount] != -1)
            return results[amount];

        int minCount = Integer.MAX_VALUE;

        for (int value : coins) {
            int count = helper(amount - value);

            if (count != Integer.MAX_VALUE)
                minCount = Math.min(minCount, 1 + count);
        }

        results[amount] = minCount;
        return minCount;
    }

    int coinChange(int[] coins, int amount) {
        int[] results = new int[amount + 1];

        Arrays.fill(results, Integer.MAX_VALUE);
        results[0] = 0;

        for (int amt = 1; amt <= amount; amt++)
            for (int value : coins)
                if (value <= amt && results[amt - value] != Integer.MAX_VALUE)
                    results[amt] = Math.min(results[amt], 1 + results[amt - value]);

        return results[amount] != Integer.MAX_VALUE ? results[amount] : -1;
    }
}
