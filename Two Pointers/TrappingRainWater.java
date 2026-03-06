class TrappingRainWater {
    int trap(int[] heights) {
        int trappedWaterAmount = 0;

        for (int i = 0; i <= heights.length - 1; i++) {
            int currentHeight = heights[i];
            int maxLeftHeight = currentHeight;
            int maxRightHeight = currentHeight;

            for (int j = 0; j < i; j++) {
                maxLeftHeight = Math.max(maxLeftHeight, heights[j]);
            }

            for (int j = i + 1; j <= heights.length - 1; j++) {
                maxRightHeight = Math.max(maxRightHeight, heights[j]);
            }

            trappedWaterAmount += Math.min(maxLeftHeight, maxRightHeight) - currentHeight;
        }

        return trappedWaterAmount;

    }

    int trap2(int[] heights) {
        int[] maxLeftHeights = new int[heights.length];
        maxLeftHeights[0] = heights[0];

        for (int i = 1; i <= heights.length - 1; i++) {
            int currentHeight = heights[i];

            maxLeftHeights[i] = Math.max(maxLeftHeights[i - 1], currentHeight);
        }

        int[] maxRightHeights = new int[heights.length];
        maxRightHeights[maxRightHeights.length - 1] = heights[heights.length - 1];

        for (int i = heights.length - 2; i >= 0; i--) {
            int currentHeight = heights[i];

            maxRightHeights[i] = Math.max(maxRightHeights[i + 1], currentHeight);
        }

        int trappedWaterAmount = 0;

        for (int i = 0; i <= heights.length - 1; i++) {
            int currentHeight = heights[i];
            int maxLeftHeight = maxLeftHeights[i];
            int maxRightHeight = maxRightHeights[i];

            trappedWaterAmount += Math.min(maxLeftHeight, maxRightHeight) - currentHeight;
        }

        return trappedWaterAmount;
    }

    int trap3(int[] heights) {
        int trappedWaterAmount = 0;
        int i = 1;
        int j = heights.length - 2;
        int maxLeftHeight = heights[0];
        int maxRightHeight = heights[heights.length - 1];

        while (i <= j) {
            if (maxLeftHeight <= maxRightHeight) {
                int currentHeight = heights[i];

                if (currentHeight < maxLeftHeight) {
                    trappedWaterAmount += maxLeftHeight - currentHeight;
                } else {
                    maxLeftHeight = currentHeight;
                }

                i++;
            } else {
                int currentHeight = heights[j];

                if (currentHeight < maxRightHeight) {
                    trappedWaterAmount += maxRightHeight - currentHeight;
                } else {
                    maxRightHeight = currentHeight;
                }

                j--;
            }
        }

        return trappedWaterAmount;
    }
}
