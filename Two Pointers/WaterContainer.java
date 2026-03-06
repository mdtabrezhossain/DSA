class WaterContainer {
    int maxArea(int[] heights) {
        int maxAmount = Integer.MIN_VALUE;

        for (int i = 0; i <= heights.length - 1; i++) {
            for (int j = i + 1; j <= heights.length - 1; j++) {
                int width = j - i;
                int height = Math.min(heights[i], heights[j]);
                int amount = width * height;
                maxAmount = Math.max(maxAmount, amount);
            }
        }

        return maxAmount;
    }

    static int maxArea2(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
