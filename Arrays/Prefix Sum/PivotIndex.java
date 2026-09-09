class PivotIndex {
    static int pivotIndex(int[] array) {
        int arraySum = 0;

        for (int num : array) {
            arraySum += num;
        }

        int currentPrefixSum = 0;
        int currentSuffixSum = 0;

        for (int i = 0; i <= array.length - 1; i++) {
            currentSuffixSum = arraySum - array[i] - currentPrefixSum;

            if (currentSuffixSum == currentPrefixSum) {
                return i;
            } else {
                currentPrefixSum += array[i];
            }
        }

        return -1;
    }
}