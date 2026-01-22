class MaximumSubArrayProduct {
    static int maxProduct(int[] array) {

        // max and min product till current index
        int maxEnding = array[0];
        int minEnding = array[0];

        // global maximum product
        int maxProd = array[0];

        for (int i = 1; i <= array.length - 1; i++) {
            int currentValue = array[i];

            /*
             * If current number is negative, max becomes min and min becomes max
             */
            if (currentValue < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            // Either start fresh or extend previous subarray
            maxEnding = Math.max(currentValue, maxEnding * currentValue);
            minEnding = Math.min(currentValue, minEnding * currentValue);

            // Update global maximum
            maxProd = Math.max(maxProd, maxEnding);
        }

        return maxProd;
    }
}
