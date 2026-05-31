class ClimbingStairs {
    int waysAtStep[];

    int climbStairs(int n) {
        waysAtStep = new int[n + 1];
        Arrays.fill(waysAtStep, -1);
        return findWays(0, n);
    }

    private int findWays(int currentStep, int totalSteps) {
        if (currentStep > totalSteps) {
            return 0;
        }
        if (currentStep == totalSteps) {
            return 1;
        }

        if (waysAtStep[currentStep] != -1) {
            return waysAtStep[currentStep];
        }

        int waysAfterOneStep = findWays(currentStep + 1, totalSteps);
        int waysAfterTwoStep = findWays(currentStep + 2, totalSteps);

        int totalWays = waysAfterOneStep + waysAfterTwoStep;
        waysAtStep[currentStep] = totalWays;

        return totalWays;
    }

    int climbStairs2(int steps) {
        int[] memo = new int[steps + 2];
        memo[steps + 1] = 0;
        memo[steps] = 1;

        for (int stair = steps - 1; stair >= 0; stair--) {
            memo[stair] = memo[stair + 1] + memo[stair + 2];
        }

        return memo[0];
    }

    int climbStairs3(int steps) {
        int waysFromNext = 1;
        int waysFromAfterNext = 0;

        for (int stair = steps - 1; stair >= 0; stair--) {
            int ways = waysFromNext + waysFromAfterNext;

            waysFromAfterNext = waysFromNext;
            waysFromNext = ways;
        }

        return waysFromNext;
    }
}
