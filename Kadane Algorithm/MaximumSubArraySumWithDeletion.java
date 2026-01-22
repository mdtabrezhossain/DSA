class Solution {
    static int maximumSum(int[] arr) {
        // Maximum subarray sum ending at the current index without any deletion
        int localMaxSum = arr[0];

        // Maximum subarray sum ending at the current index after one deletion
        int localMaxSumWithDeletion = 0;
        // Initialized to 0 to represent deleting the first element

        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];

            /*
             * Update localMaxSumWithDeletion (one deletion case):
             * Two possibilities:
             * 1) Join the subarray with one deletion
             * 2) Delete the current element
             */
            localMaxSumWithDeletion = Math.max(localMaxSumWithDeletion + currentValue, localMaxSum);

            /*
             * Update localMaxSum (no deletion case): Join the subarray with one deletion or
             * start a new subarray
             */
            localMaxSum = Math.max(currentValue, localMaxSum + currentValue);

            maxSum = Math.max(maxSum,
                    Math.max(localMaxSum, localMaxSumWithDeletion));
        }

        return maxSum;
    }
}
