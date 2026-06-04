class LargestRectangleInHistogram {
    int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {
                int height = heights[j];
                int width = j - i + 1;

                minHeight = Math.min(minHeight, height);
                int area = minHeight * width;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    int largestRectangleArea2(int[] heights) {
        int[] leftBoundaries = new int[heights.length];
        int[] rightBoundaries = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                leftBoundaries[i] = 0;
            } else {
                while (!stack.isEmpty()
                        && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }

                leftBoundaries[i] = stack.isEmpty()
                        ? 0
                        : stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.empty()) {
                rightBoundaries[i] = heights.length - 1;
            } else {
                while (!stack.isEmpty()
                        && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }

                rightBoundaries[i] = stack.isEmpty()
                        ? heights.length - 1
                        : stack.peek() - 1;
            }

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftBoundary = leftBoundaries[i];
            int rightBoundary = rightBoundaries[i];

            int height = heights[i];
            int width = rightBoundary - leftBoundary + 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
