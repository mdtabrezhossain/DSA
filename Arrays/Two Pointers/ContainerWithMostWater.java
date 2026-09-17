class ContainerWithMostWater {
    int maxArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int width = j - i;
                int height = Math.min(heights[i], heights[j]);
                int area = width * height;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    int maxArea2(int[] heights) {
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = width * height;

            maxArea = Math.max(maxArea, area);

            if (heights[left] <= heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}