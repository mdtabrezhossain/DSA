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
        leftMaxes[0] = heights[0];

        for (int i = 1; i < heights.length; i++)
            leftMaxes[i] = Math.max(leftMaxes[i - 1], heights[i]);

        int[] rightMaxes = new int[heights.length];
        rightMaxes[heights.length - 1] = heights[heights.length - 1];

        for (int i = heights.length - 2; i >= 0; i--)
            rightMaxes[i] = Math.max(rightMaxes[i + 1], heights[i]);

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

        int i = 0;
        int j = heights.length - 1;

        while (i < j) {
            leftMax = Math.max(leftMax, heights[i]);
            rightMax = Math.max(rightMax, heights[j]);

            if (leftMax < rightMax) {
                result += leftMax - heights[i];
                i++;
            } else {
                result += rightMax - heights[j];
                j--;
            }
        }

        return result;
    }
}