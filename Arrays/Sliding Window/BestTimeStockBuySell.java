class BestTimeStockBuySell {
    int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPtr = 0;
        int sellPtr = 1;

        while (sellPtr <= prices.length - 1) {
            if (prices[buyPtr] < prices[sellPtr]) {
                int profit = prices[sellPtr] - prices[buyPtr];
                maxProfit = Math.max(maxProfit, profit);

            } else {
                buyPtr = sellPtr;
            }

            sellPtr++;
        }

        return maxProfit;
    }
}
