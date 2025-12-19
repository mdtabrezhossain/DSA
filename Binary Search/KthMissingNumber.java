class KthMissingNumber {
    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 7, 11 };
        int k = 5;

        // // Approach 1 ---
        // int max = array[array.length -1];

        // boolean[] isPresentInArrayHashTable = new boolean[max + 1];

        // for (int num : array) {
        // isPresentInArrayHashTable[num] = true;
        // }

        // for (int num = 1, missingCount = 0; num <= isPresentInArrayHashTable.length -
        // 1; num++) {
        // if (!isPresentInArrayHashTable[num]) {
        // missingCount++;

        // if (missingCount == k) {
        // System.out.println(num);
        // }
        // }
        // }

        // Approach 2 ---
        // for (int i = 0; i <= array.length - 1; i++) {
        // if (array[i] <= k) {
        // k++;
        // } else {
        // System.out.println(k);
        // break;
        // }
        // }

        /*
         * Approach 3:
         * Here in the array we can see that an element is always placed at index which
         * is just one less than it. So the index at which an element is there tells us
         * how many numbers are missing till that index.
         */
        int startIdx = 0;
        int endIdx = array.length - 1;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;
            int totalMissingNumbers = array[midIdx] - midIdx - 1;

            /*
             * If missing numbers till mid are less than k,
             * it means the kth missing number lies on the right side.
             */
            if (totalMissingNumbers < k) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }

        /*
         * At the end of the loop, startIdx tell us how many numbers from the array
         * are less than or equal to the kth missing number that we are finding. So the
         * kth missing number is startIdx + k
         */
        System.out.println("Missing number: " + (startIdx + k));

    }
}
