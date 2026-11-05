class MinCostClimbingStairs {
    int[] costs;
    int[] results;

    int minCostClimbingStairs(int[] costs) {
        this.costs = costs;
        results = new int[costs.length + 1];

        int minCost = Math.min(findPathCost(0), findPathCost(1));

        return minCost;
    }

    int findPathCost(int step) {
        if (step >= costs.length)
            return 0;

        if (results[step] != -1)
            return results[step];

        int oneStepCost = findPathCost(step + 1);
        int twoStepCost = findPathCost(step + 2);

        int totalCost = costs[step] + Math.min(oneStepCost, twoStepCost);
        results[step] = totalCost;

        return totalCost;
    }

    int minCostClimbingStairs2(int[] costs) {
        int[] results = new int[costs.length];

        results[0] = costs[0];
        results[1] = costs[1];

        for (int step = 2; step < costs.length; step++) {
            int oneStepBackCost = results[step - 1];
            int twoStepBackCost = results[step - 2];

            int totalCost = costs[step] + Math.min(oneStepBackCost, twoStepBackCost);
            results[step] = totalCost;
        }

        return Math.min(results[results.length - 1], results[results.length - 2]);
    }
}