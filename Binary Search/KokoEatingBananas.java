class KokoEatingBananas {
    int minEatingSpeed(int[] piles, int maxHours) {
        int speed = 1;

        while (true) {
            int hours = 0;

            for (int pile : piles) {
                hours += Math.ceilDiv(pile, speed);
            }

            if (hours <= maxHours) {
                return speed;
            }

            speed++;
        }
    }

    int minEatingSpeed2(int[] piles, int maxHours) {
        int speed = 1;
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;

        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            long hours = getHours(midSpeed, piles);

            if (hours <= maxHours) {
                speed = midSpeed;
                maxSpeed = midSpeed - 1;
            } else {
                minSpeed = midSpeed + 1;
            }
        }

        return speed;
    }

    private long getHours(int speed, int[] piles) {
        long hours = 0;

        for (int pile : piles) {
            hours += Math.ceilDiv(pile, speed);
        }

        return hours;
    }
}