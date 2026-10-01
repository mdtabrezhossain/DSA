class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] array = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int result = getMinSubArrayLen2(target, array);
        System.out.println("The smallest subarray length with sum greater than equal to target : " + result);

    }

    static int getMinSubArrayLen1(int target, int[] array) {

        for (int minimumSubArrayLength = 1; minimumSubArrayLength <= array.length; minimumSubArrayLength++) {

            for (int i = 0; i + minimumSubArrayLength - 1 <= array.length - 1; i++) {
                int sum = 0;

                for (int j = i; j <= i + minimumSubArrayLength - 1; j++) {
                    sum += array[j];
                }

                if (sum >= target) {
                    return minimumSubArrayLength;
                }
            }
        }

        return 0;
    }

    static int getMinSubArrayLen2(int target, int[] nums) {
        int minimumSubArrayLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        int sum = 0;

        // Expand the window by moving 'right' until it reaches the end
        while (right <= nums.length - 1) {

            // Add the current right element to the window sum
            sum += nums[right];

            // While the current window sum is sufficient (>= target), shrink the window
            // from the left to find the minimum length
            while (sum >= target) {

                // Update the minimum subarray length found so far
                minimumSubArrayLength = Math.min(right - left + 1, minimumSubArrayLength);

                sum -= nums[left];
                left++;
            }

            // Expand the window
            right++;
        }

        return minimumSubArrayLength == Integer.MAX_VALUE ? 0 : minimumSubArrayLength;
    }

}