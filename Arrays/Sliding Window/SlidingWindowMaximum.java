class SlidingWindowMaximum {
    int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int currentMax = nums[i];

            for (int j = i; j < i + k; j++) {
                currentMax = Math.max(currentMax, nums[j]);
            }

            result[i] = currentMax;
        }

        return result;
    }

    int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));
        int[] result = new int[nums.length - k + 1];
        int resultIdx = 0;
        int currentIdx = 0;

        while (currentIdx < nums.length) {
            maxHeap.offer(new int[] { nums[currentIdx], currentIdx });

            while (maxHeap.peek()[1] <= currentIdx - k) {
                maxHeap.poll();
            }

            if (currentIdx >= k - 1) {
                result[resultIdx] = maxHeap.peek()[0];
                resultIdx++;
            }

            currentIdx++;
        }

        return result;
    }
}