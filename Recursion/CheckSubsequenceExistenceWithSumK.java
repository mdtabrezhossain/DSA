class CheckSubsequenceExistenceWithSumK {
    public static void main(String[] args) {
        int[] array = { 5, 9, 4 };

        boolean result = hasSubsequence(array, k, 0, 0);
        System.out.println("Do any subsequences exist with sum equal to k: " + result);
    }

    static boolean hasSubsequence(int[] array, int k, int sum, int index) {
        if (sum == k) {
            return true;
        }

        if (sum > k) {
            return false;
        }

        if (index > array.length - 1) {
            return false;
        }

        boolean isFoundWithCurrent = hasSubsequence(array, k, sum + array[index], index + 1);

        if (isFoundWithCurrent) {
            return true;
        }

        boolean isFoundWithoutCurrent = hasSubsequence(array, k, sum, index + 1);

        if (isFoundWithoutCurrent) {
            return true;
        }

        return false;
    }
}
