class HouseRobber {
    int rob(int[] houses) {
        int[] memo = new int[houses.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return maxMoneyFrom(0, houses, memo);
    }

    private int maxMoneyFrom(int currentIndex, int[] houses, int[] memo) {
        if (currentIndex >= houses.length) {
            return 0;
        }

        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }

        int robCurrentHouse = houses[currentIndex]
                + maxMoneyFrom(currentIndex + 2, houses, memo);

        int skipCurrentHouse = maxMoneyFrom(currentIndex + 1, houses, memo);

        memo[currentIndex] = Math.max(robCurrentHouse, skipCurrentHouse);

        return memo[currentIndex];
    }
}