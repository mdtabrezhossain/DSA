import java.util.Arrays;

class HouseRobber {
    int[] houses;
    int[] results;

    int rob(int[] houses) {
        this.houses = houses;

        results = new int[houses.length];
        Arrays.fill(results, -1);

        return helper(0);
    }

    int helper(int i) {
        if (i >= houses.length)
            return 0;

        if (results[i] != -1)
            return results[i];

        int robAmount = houses[i] + helper(i + 2);
        int skipAmount = helper(i + 1);

        int maxAmount = Math.max(robAmount, skipAmount);
        results[i] = maxAmount;

        return maxAmount;
    }

    int rob2(int[] houses) {
        if (houses.length == 1)
            return houses[0];

        int[] results = new int[houses.length];

        results[0] = houses[0];
        results[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            int robAmount = houses[i] + results[i - 2];
            int skipAmount = results[i - 1];

            int maxAmount = Math.max(robAmount, skipAmount);
            results[i] = maxAmount;
        }

        return results[houses.length - 1];
    }
}