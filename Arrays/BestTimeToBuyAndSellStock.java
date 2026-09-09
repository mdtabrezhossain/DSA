class BestTimeToBuyAndSellStock {
    int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                int sellPrice = prices[j];
                int profit = sellPrice - buyPrice;

                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int[] nextMaxPrices = new int[prices.length];
        int nextMaxPrice = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            nextMaxPrice = Math.max(nextMaxPrice, prices[i + 1]);
            nextMaxPrices[i] = nextMaxPrice;
        }

        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            int sellPrice = nextMaxPrices[i];
            int profit = sellPrice - buyPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    // To sell today, we only care about the cheapest day behind
    int maxProfit3(int[] prices) {
        int prevMinPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            if (currentPrice < prevMinPrice) {
                prevMinPrice = currentPrice;
                continue;
            }

            int profit = currentPrice - prevMinPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}