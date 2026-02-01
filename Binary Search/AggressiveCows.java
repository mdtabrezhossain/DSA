import java.util.Arrays;

class AggressiveCows {
    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int maxDistanceBetweenCows = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean isPossible = isPossibleToKeepAllCows(k, mid, stalls);

            if (isPossible) {
                maxDistanceBetweenCows = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxDistanceBetweenCows;
    }

    static boolean isPossibleToKeepAllCows(int totalCows, int distance, int[] stalls) {
        int previousCowPosition = stalls[0];
        int cowsPlaced = 1;

        for (int i = 1; i <= stalls.length - 1; i++) {
            if (stalls[i] - previousCowPosition >= distance) {
                cowsPlaced++;
                previousCowPosition = stalls[i];
            }
        }

        return cowsPlaced >= totalCows;
    }
}
