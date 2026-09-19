class MaxSubArraySum {
    public static void main(String[] args) {
        int[] numbers = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int k = 4;

        int result = getMaxSubArraySum(numbers, k);
        System.out.println(result);
    }

    static int getMaxSubArraySum(int[] array, int k) {
        int startPointer = 0;
        int endPointer = k - 1;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = startPointer; i <= endPointer; i++) {
            sum += array[i];
        }

        while (endPointer <= array.length - 1) {
            maxSum = Math.max(sum, maxSum);

            startPointer++;
            endPointer++;

            if (endPointer == array.length) {
                break;
            }

            sum -= array[startPointer - 1];
            sum += array[endPointer];

        }

        return maxSum;
    }
}
