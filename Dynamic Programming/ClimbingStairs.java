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
}
