import java.util.HashMap;

class SubArrayCountDivisibleByK {
    static int getSubArrayCountDivisibleByK(int[] array, int k) {
        int result = 0;

        int currentSum = 0;
        int currentRemainder = currentSum % k;
        HashMap<Integer, Integer> remainderCountMap = new HashMap<>();
        remainderCountMap.put(currentRemainder, 1);

        for (int i = 0; i <= array.length - 1; i++) {
            currentSum += array[i];
            currentRemainder = currentSum % k;

            if (currentRemainder < 0) {
                currentRemainder += k;
            }

            if (remainderCountMap.containsKey(currentRemainder)) {
                result += remainderCountMap.get(currentRemainder);
            }

            remainderCountMap.put(
                    currentRemainder,
                    remainderCountMap.getOrDefault(currentRemainder, 0) + 1);
        }

        return result;
    }
}

/*
 * Logic:---
 * 
 * Let the remainder of sum divided by 'K' array till the current index be 'r'.
 * So, if there is a subarray till the current index whose remainder of sum
 * divided by 'K' is 'r'.
 * Then the sum of the remaining part is definitely divisible by 'K'.
 * 
 * And this situation can occur multiple times in the current array till the
 * current index.
 */

/*
 * Logic behind handling negative remainders:---
 *
 * In mathematics, -1 mod 5 = 4.
 * But in Java, -1 % 5 = -1, which breaks modulo-based logic.
 *
 * For subarray problems using modulo, remainders must always be in the range
 * [0, k-1].
 * Adding 'k' converts a negative remainder into its correct positive modulo
 * equivalent.
 * And ensuring equal modulo values are counted correctly in the HashMap.
 */
