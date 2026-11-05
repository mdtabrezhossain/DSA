class ClimbingStairs {
    int[] results;

    int climbStairs(int stairs) {
        results = new int[stairs + 1];
        Arrays.fill(results, -1);

        return countWays(0, stairs);
    }

    int countWays(int step, int stairs) {
        if (step > stairs)
            return 0;

        if (step == stairs)
            return 1;

        if (results[step] != -1)
            return results[step];

        int oneStepWays = countWays(step + 1, stairs);
        int twoStepWays = countWays(step + 2, stairs);

        int ways = oneStepWays + twoStepWays;

        results[step] = ways;

        return ways;
    }

    int climbStairs2(int stairs) {
        int[] results = new int[stairs + 1];

        results[1] = 1;
        results[2] = 2;

        for (int step = 3; step <= stairs; step++) {
            int oneStepBackWays = results[step - 1];
            int twoStepBackWays = results[step - 2];

            int ways = oneStepBackWays + twoStepBackWays;
            results[step] = ways;
        }

        return results[stairs];
    }
}