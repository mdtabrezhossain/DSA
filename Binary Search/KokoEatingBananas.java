import java.util.Arrays;

class KokoEatingBananas {
    static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int minEatingSpeed = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalEatingHours = getTotalEatingHours(mid, piles);
            if (totalEatingHours <= h) {
                minEatingSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minEatingSpeed;
    }

    static long getTotalEatingHours(int eatingSpeedPerHour, int[] piles) {
        long totalEatingHours = 0;

        for (int noOfBananas : piles) {
            totalEatingHours += noOfBananas / eatingSpeedPerHour;
            if (noOfBananas % eatingSpeedPerHour != 0) {
                totalEatingHours++;
            }
        }

        return totalEatingHours;
    }
}
