class TrappingRainWater {
    int trap(int[] heights) {
        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftMax = 0;

            for (int j = i - 1; j >= 0; j--)
                leftMax = Math.max(leftMax, heights[j]);

            int rightMax = 0;

            for (int j = i + 1; j < heights.length; j++)
                rightMax = Math.max(rightMax, heights[j]);

            int current = heights[i];

            result += Math.max(0, Math.min(leftMax, rightMax) - current);
        }

        return result;
    }

    int trap2(int[] heights) {
        int[] leftMaxes = new int[heights.length];
        leftMaxes[0] = 0;

        for (int i = 1; i < heights.length; i++)
            leftMaxes[i] = Math.max(leftMaxes[i - 1], heights[i - 1]);

        int[] rightMaxes = new int[heights.length];
        rightMaxes[heights.length - 1] = 0;

        for (int i = heights.length - 2; i >= 0; i--)
            rightMaxes[i] = Math.max(rightMaxes[i + 1], heights[i + 1]);

        int result = 0;

        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            int leftMax = leftMaxes[i];
            int rightMax = rightMaxes[i];

            result += Math.max(0, Math.min(leftMax, rightMax) - current);
        }

        return result;
    }

    int trap3(int[] heights) {
        int result = 0;

        int leftMax = 0;
        int rightMax = 0;

        int i = 1;
        int j = heights.length - 2;

        while (i <= j) {
            leftMax = Math.max(leftMax, heights[i - 1]);
            rightMax = Math.max(rightMax, heights[j + 1]);

            if (leftMax < rightMax) {
                int current = heights[i];
                result += Math.max(0, leftMax - current);

                i++;
            } else {
                int current = heights[j];
                result += Math.max(0, rightMax - current);

                j--;
            }
        }

        return result;
    }
}