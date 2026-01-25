import java.util.HashMap;

class SubArrayWithEqualZeroesAndOnes {
    static int findMaxLength(int[] array) {
        int maxLength = 0;

        int zeroCount = 0;
        int oneCount = 0;
        HashMap<Integer, Integer> differenceCountAtIndexMap = new HashMap<>();

        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }

            int currentDifference = zeroCount - oneCount;

            if (currentDifference == 0) {
                maxLength = Math.max(i + 1, maxLength);
                continue;
            }

            if (differenceCountAtIndexMap.containsKey(currentDifference)) {
                int idx = differenceCountAtIndexMap.get(currentDifference);
                maxLength = Math.max(i - idx, maxLength); // do not include idx where difference was seen
            } else {
                differenceCountAtIndexMap.put(currentDifference, i);
            }
        }

        return maxLength;
    }
}

/*
 * Logic:
 * 
 * Let the count difference between 0s and 1s of the array till the current
 * index be 'd'.
 * So, if there is a part till the current index whose count difference
 * between 0s and 1s is 'd'.
 * And because of this only the difference 'd' in the array till the current
 * index is there.
 * Thus, the remaining part has definitely equal number of zeroes and ones with
 * no count difference between 0s and 1s.
 * 
 * And this situation can occur multiple times in the current array till the
 * current index.
 * But here, we will consider only the first occurrence of each
 * difference because we are finding max length
 */
