class BestTimeToBuyAndSellStock4 {
    int[][] maxProfitAt;

    int maxProfit(int k, int[] prices) {
        int transactions = 2 * k;
        maxProfitAt = new int[prices.length][transactions + 1];

        for (int[] row : maxProfitAt) {
            Arrays.fill(row, -1);
        }

        return helper(0, transactions, prices);
    }

    private int helper(int day, int transactions, int[] prices) {
        if (day == prices.length || transactions == 0)
            return 0;

        if (maxProfitAt[day][transactions] != -1)
            return maxProfitAt[day][transactions];

        int price = prices[day];

        if (transactions % 2 == 0) {
            int buy = helper(day + 1, transactions - 1, prices) - price;
            int skip = helper(day + 1, transactions, prices);

            return maxProfitAt[day][transactions] = Math.max(buy, skip);
        } else {
            int sell = price + helper(day + 1, transactions - 1, prices);
            int skip = helper(day + 1, transactions, prices);

            return maxProfitAt[day][transactions] = Math.max(sell, skip);
        }
    }

    int maxProfit2(int k, int[] prices) {
        int transactions = 2 * k;
        int[][] maxProfitsAt = new int[prices.length + 1][transactions + 1];

        for (int day = prices.length - 1; day >= 0; day--) {
            for (int t = 1; t <= transactions; t++) {
                int price = prices[day];

                if (t % 2 == 0) {
                    int buy = maxProfitsAt[day + 1][t - 1] - price;
                    int skip = maxProfitsAt[day + 1][t];

                    maxProfitsAt[day][t] = Math.max(buy, skip);
                } else {
                    int sell = price + maxProfitsAt[day + 1][t - 1];
                    int skip = maxProfitsAt[day + 1][t];

                    maxProfitsAt[day][t] = Math.max(sell, skip);
                }
            }
        }

        return maxProfitsAt[0][transactions];
    }
}