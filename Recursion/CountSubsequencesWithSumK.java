class CountSubsequencesWithSumK {
    public static void main(String[] args) {
        int[] array = { 5, 9, 4 };
        int k = 9;

        int count = countSubsequences(array, k, 0, 0);
        System.out.println("Total subsequences with sum equal to k: " + count);
    }

    static int countSubsequences(int[] array, int k, int sum, int index) {
        if (sum == k) {
            return 1;
        }

        if (sum > k) {
            return 0;
        }

        if (index > array.length - 1) {
            return 0;
        }

        // pick the element at the current index
        int countIncludingCurrentElement = countSubsequences(array, k, sum + array[index], index + 1);
        /*
         * countIncludingCurrentElement represents all valid subsequences formed by
         * including the current element
         */

        // do not pick the element at the current index
        int countExcludingCurrentElement = countSubsequences(array, k, sum, index + 1);
        /*
         * countExcludingCurrentElement represents all valid subsequences formed by
         * excluding the current element
         */

        /*
         * Returning Total valid subsequences from this index = valid subsequences
         * formed by
         * including the current element + valid subsequences formed by excluding the
         * current element
         */
        return countIncludingCurrentElement + countExcludingCurrentElement;
    }
}