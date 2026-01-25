import java.util.HashMap;

class SubArraySumEqualsK {
    static int getSubArraySum(int[] array, int k) {
        int currentSum = 0;
        int result = 0;

        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(currentSum, 1);

        for (int i = 0; i <= array.length - 1; i++) {
            currentSum += array[i];

            if (sumCountMap.containsKey(currentSum - k)) {
                result += sumCountMap.get(currentSum - k);
            }

            sumCountMap.put(
                    currentSum,
                    sumCountMap.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}

/*
 * Logic:
 * 
 * Let the sum of the array till the current index be 'S'.
 * So, if there is a subarray till the current index whose sum is 'S - K'.
 * Then the remaining part is definitely equal to 'K'.
 * 
 * And this situation can occur multiple times in the current array till the
 * current index.
 */
